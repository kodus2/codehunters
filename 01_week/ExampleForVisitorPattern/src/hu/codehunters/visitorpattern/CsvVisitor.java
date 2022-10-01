package hu.codehunters.visitorpattern;

public class CsvVisitor implements Visitor {

    private String startTag;
    private String endTag;
    private String separatorTag;

    public CsvVisitor(String startTag, String endTag, String separatorTag) {
        this.startTag = startTag;
        this.endTag = endTag;
        this.separatorTag = separatorTag;
    }


    @Override
    public void visit(Table table) {
        table.setStartTag(startTag);
        table.setEndTag(endTag);
        table.setSeparatorTag(separatorTag);
        table.setLengthOfColumn(1);

    }
}
