package Structural_pattern.Adapter_pattern;

public class JsonDataImpl implements JsonData {
    private String json;

    public JsonDataImpl(String json) {
        this.json = json;
    }

    @Override
    public String getJson() {
        return json;
    }
}
