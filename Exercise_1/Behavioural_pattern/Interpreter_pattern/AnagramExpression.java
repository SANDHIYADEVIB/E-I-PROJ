package Behavioural_pattern.Interpreter_pattern;

import java.util.Arrays;

public class AnagramExpression implements Expression {

    @Override
    public boolean interpret(Context context) {
        String str1 = context.getString1().replaceAll("\\s+", "").toLowerCase();
        String str2 = context.getString2().replaceAll("\\s+", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }
}
