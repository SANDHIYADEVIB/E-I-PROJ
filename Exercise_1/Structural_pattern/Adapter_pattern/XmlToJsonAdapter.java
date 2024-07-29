package Structural_pattern.Adapter_pattern;

public class XmlToJsonAdapter implements JsonData {
    private XmlData xmlData;

    public XmlToJsonAdapter(XmlData xmlData) {
        this.xmlData = xmlData;
    }

    @Override
    public String getJson() {
        return convertXmlToJson(xmlData.getXml());
    }

    private String convertXmlToJson(String xml) {
        // Basic conversion: replacing tags with JSON syntax
        String json = xml.replaceAll("<([^/]+)>", "\"$1\": {")
                .replaceAll("</[^>]+>", "},")
                .replaceAll("<([^>]+)>([^<]+)</[^>]+>", "\"$1\": \"$2\",")
                .replaceAll(",}", "}");
        return "{" + json.substring(0, json.length() - 1) + "}";
    }
}
