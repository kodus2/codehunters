package hu.codehunters.visitorpattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        var table = new Table();
        table.setStartTag("|");
        table.setEndTag("|");
        table.setSeparatorTag("|");
        table.setData(populateData());
        System.out.println("\n\nBefore visitor-----------------\n" + table.generateTable());
        var csvVisitor = new CsvVisitor("", "", ",");
        csvVisitor.visit(table);
        System.out.println("\n\nAfter visitor-----------------\n" + table.generateTable());
    }

    private List<List<String>> populateData() {
        List<String> columnName = createDataRow("Keresztnév", "Vezetéknév", "Város");
        List<String> row2 = createDataRow("Ábel", "Nagy", "Pécs");
        List<String> row3 = createDataRow("Gábor", "Áron", "Budapest");
        List<String> row4 = createDataRow("Lajos", "Kossuth", "Fokváros");
        List<String> row5 = createDataRow("Zsigmond", "Rézműves", "Bécs");
        return createData(columnName, row2, row3, row4, row5);
    }

    private List<String> createDataRow(String... word) {
        return new ArrayList<>(Arrays.asList(word));
    }

    @SafeVarargs
    private List<List<String>> createData(List<String>... data) {
        return new ArrayList<>(Arrays.asList(data));
    }

}