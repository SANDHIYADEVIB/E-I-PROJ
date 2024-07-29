package Structural_pattern.Adapter_pattern;

public class XmlDataImpl implements XmlData {
    private String xml;

    public XmlDataImpl(String xml) {
        this.xml = xml;
    }

    @Override
    public String getXml() {
        return xml;
    }
}
