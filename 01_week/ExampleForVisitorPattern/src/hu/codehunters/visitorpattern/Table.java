package hu.codehunters.visitorpattern;

import java.util.List;
import java.util.stream.Collectors;

public class Table {

    private String startTag;
    private String endTag;
    private String separatorTag;
    private List<List<String>> data;
    private int lengthOfColumn;


    public String generateTable() {
        if (lengthOfColumn < 1) {
            lengthOfColumn = data.stream().mapToInt(row -> row.stream().mapToInt(String::length).max().orElse(1)).max().orElse(1);
        }
        return data.stream().map(row -> generateRow(row, lengthOfColumn)).collect(Collectors.joining("\n"));
    }

    private String generateRow(List<String> row, int charNumber) {

        String format = "%" + charNumber + "s";
        return row.stream().map(word -> String.format(format, word)).collect(Collectors.joining(separatorTag, startTag, endTag));
    }


    public String getStartTag() {
        return startTag;
    }

    public void setStartTag(String startTag) {
        this.startTag = startTag;
    }

    public String getEndTag() {
        return endTag;
    }

    public void setEndTag(String endTag) {
        this.endTag = endTag;
    }

    public String getSeparatorTag() {
        return separatorTag;
    }

    public void setSeparatorTag(String separatorTag) {
        this.separatorTag = separatorTag;
    }

    public List<List<String>> getData() {
        return data;
    }

    public void setData(List<List<String>> data) {
        this.data = data;
    }

    public int getLengthOfColumn() {
        return lengthOfColumn;
    }

    public void setLengthOfColumn(int lengthOfColumn) {
        this.lengthOfColumn = lengthOfColumn;
    }
}
