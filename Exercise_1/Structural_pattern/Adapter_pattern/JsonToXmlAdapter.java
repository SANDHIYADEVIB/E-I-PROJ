package Structural_pattern.Adapter_pattern;

public class JsonToXmlAdapter implements XmlData {
    private JsonData jsonData;

    public JsonToXmlAdapter(JsonData jsonData) {
        this.jsonData = jsonData;
    }

    @Override
    public String getXml() {
        return convertJsonToXml(jsonData.getJson());
    }

    private String convertJsonToXml(String json) {
        // Basic conversion: replacing JSON syntax with XML tags
        String xml = json.replaceAll("\"([^\"]+)\": \\{", "<$1>")
                .replaceAll("},", "</>")
                .replaceAll("\"([^\"]+)\": \"([^\"]+)\",", "<$1>$2</$1>")
                .replaceAll("}", "</>");
        return xml.substring(0, xml.length() - 2) + "</>";
    }
}
