package hu.codehunters.threads;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        runAfterEach();
        runInSeparateCompletableFuture();
        runWithExecutorService(2);
        runWithExecutorService(1);
    }

    private void runAfterEach() {
        System.out.println("\nProcess run after each");
        long startTime = System.nanoTime();
        try {
            methodA();
            methodB();
        } catch (InterruptedException e) {
            System.err.println("Error occurred:" + e.getMessage());
        }
        printProcessTime(System.nanoTime() - startTime);
    }

    private void runInSeparateCompletableFuture() {
        System.out.println("Process run in separate CompletableFuture");
        long startTime = System.nanoTime();
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                methodA();
            } catch (InterruptedException e) {
                System.err.println("Error occurred:" + e.getMessage());
            }
        });
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                methodB();
            } catch (InterruptedException e) {
                System.err.println("Error occurred:" + e.getMessage());
            }
        });
        CompletableFuture.allOf(future1, future2).join();
        try {
            future1.get();
            future2.get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error occurred:" + e.getMessage());
        }
        printProcessTime(System.nanoTime() - startTime);
    }

    private void runWithExecutorService(int size) {
        System.out.printf("Process run in separate CompletableFuture and with ExecutorService(%d)\n", size);
        long startTime = System.nanoTime();
        ExecutorService executor = Executors.newFixedThreadPool(size);
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
               methodA();

            } catch (InterruptedException e) {
                System.err.println("Error occurred:" + e.getMessage());
            }
            }, executor);
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                methodB();
            } catch (InterruptedException e) {
                System.err.println("Error occurred:" + e.getMessage());
            }
        }, executor);
        CompletableFuture.allOf(future1, future2).join();
        try {
            future1.get();
            future2.get();
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Error occurred:" + e.getMessage());
        }
        executor.shutdown();
        printProcessTime(System.nanoTime() - startTime);
    }


    private void methodA() throws InterruptedException {
        Thread.sleep(7_000);
    }

    private void methodB() throws InterruptedException {
        Thread.sleep(10_000);
    }

    private void printProcessTime(long period) {
        System.out.printf("Process ran in: %d nanoseconds\n\n", period);
    }

}
