package Structural_pattern.Adapter_pattern;

import java.util.Scanner;

public class AdapterDemo {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        runConversionDemo();
    }

    private static void runConversionDemo() {
        System.out.println("Enter data (XML, JSON, or type 'exit' to quit):");
        String data = scanner.nextLine();

        if (data.equalsIgnoreCase("exit")) {
            System.out.println("Exiting program.");
            scanner.close();
            return; // Exit the program
        }

        if (isXml(data)) {
            XmlData xml = new XmlDataImpl(data);
            JsonData json = new XmlToJsonAdapter(xml);
            System.out.println("Converted JSON data:");
            System.out.println(json.getJson());
        } else if (isJson(data)) {
            JsonData json = new JsonDataImpl(data);
            XmlData xml = new JsonToXmlAdapter(json);
            System.out.println("Converted XML data:");
            System.out.println(xml.getXml());
        } else {
            System.out.println("Unrecognized data format. Please enter valid XML or JSON data.");
        }

        runConversionDemo(); // Recursive call to continue until user decides to exit
    }

    private static boolean isXml(String data) {
        return data.trim().startsWith("<") && data.trim().endsWith(">");
    }

    private static boolean isJson(String data) {
        data = data.trim();
        return (data.startsWith("{") && data.endsWith("}")) || (data.startsWith("[") && data.endsWith("]"));
    }
}
