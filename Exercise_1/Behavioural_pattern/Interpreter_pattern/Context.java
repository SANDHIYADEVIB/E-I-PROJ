package Behavioural_pattern.Interpreter_pattern;

public class Context {
    private String string1;
    private String string2;

    public Context(String string1, String string2) {
        this.string1 = string1;
        this.string2 = string2;
    }

    public String getString1() {
        return string1;
    }

    public String getString2() {
        return string2;
    }
}
