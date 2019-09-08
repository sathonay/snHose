package net.minecraft.server.v1_7_R4;

import java.util.*;
import org.apache.logging.log4j.*;

public class MojangsonParser
{
    private static final Logger a;
    
    public static NBTBase parse(String trim) {
        trim = trim.trim();
        if (b(trim) != 1) {
            throw new MojangsonParseException("Encountered multiple top tags, only one expected");
        }
        MojangsonTypeParser mojangsonTypeParser;
        if (trim.startsWith("{")) {
            mojangsonTypeParser = a("tag", trim);
        }
        else {
            mojangsonTypeParser = a(b(trim, false), c(trim, false));
        }
        return mojangsonTypeParser.a();
    }
    
    static int b(final String s) {
        int n = 0;
        boolean b = false;
        final Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == '\"') {
                if (i > 0 && s.charAt(i - 1) == '\\') {
                    if (!b) {
                        throw new MojangsonParseException("Illegal use of \\\": " + s);
                    }
                }
                else {
                    b = !b;
                }
            }
            else if (!b) {
                if (char1 == '{' || char1 == '[') {
                    if (stack.isEmpty()) {
                        ++n;
                    }
                    stack.push(char1);
                }
                else {
                    if (char1 == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                        throw new MojangsonParseException("Unbalanced curly brackets {}: " + s);
                    }
                    if (char1 == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                        throw new MojangsonParseException("Unbalanced square brackets []: " + s);
                    }
                }
            }
        }
        if (b) {
            throw new MojangsonParseException("Unbalanced quotation: " + s);
        }
        if (!stack.isEmpty()) {
            throw new MojangsonParseException("Unbalanced brackets: " + s);
        }
        if (n == 0 && !s.isEmpty()) {
            return 1;
        }
        return n;
    }
    
    static MojangsonTypeParser a(final String s, String s2) {
        s2 = s2.trim();
        b(s2);
        if (s2.startsWith("{")) {
            if (!s2.endsWith("}")) {
                throw new MojangsonParseException("Unable to locate ending bracket for: " + s2);
            }
            s2 = s2.substring(1, s2.length() - 1);
            final MojangsonCompoundParser mojangsonCompoundParser = new MojangsonCompoundParser(s);
            while (s2.length() > 0) {
                final String a = a(s2, false);
                if (a.length() > 0) {
                    mojangsonCompoundParser.b.add(a(b(a, false), c(a, false)));
                    if (s2.length() < a.length() + 1) {
                        break;
                    }
                    final char char1 = s2.charAt(a.length());
                    if (char1 != ',' && char1 != '{' && char1 != '}' && char1 != '[' && char1 != ']') {
                        throw new MojangsonParseException("Unexpected token '" + char1 + "' at: " + s2.substring(a.length()));
                    }
                    s2 = s2.substring(a.length() + 1);
                }
            }
            return mojangsonCompoundParser;
        }
        else {
            if (!s2.startsWith("[") || s2.matches("\\[[-\\d|,\\s]+\\]")) {
                return new MojangsonPrimitiveParser(s, s2);
            }
            if (!s2.endsWith("]")) {
                throw new MojangsonParseException("Unable to locate ending bracket for: " + s2);
            }
            s2 = s2.substring(1, s2.length() - 1);
            final MojangsonListParser mojangsonListParser = new MojangsonListParser(s);
            while (s2.length() > 0) {
                final String a2 = a(s2, true);
                if (a2.length() > 0) {
                    mojangsonListParser.b.add(a(b(a2, true), c(a2, true)));
                    if (s2.length() < a2.length() + 1) {
                        break;
                    }
                    final char char2 = s2.charAt(a2.length());
                    if (char2 != ',' && char2 != '{' && char2 != '}' && char2 != '[' && char2 != ']') {
                        throw new MojangsonParseException("Unexpected token '" + char2 + "' at: " + s2.substring(a2.length()));
                    }
                    s2 = s2.substring(a2.length() + 1);
                }
                else {
                    MojangsonParser.a.debug(s2);
                }
            }
            return mojangsonListParser;
        }
    }
    
    private static String a(final String s, final boolean b) {
        int a = a(s, ':');
        if (a < 0 && !b) {
            throw new MojangsonParseException("Unable to locate name/value separator for string: " + s);
        }
        final int a2 = a(s, ',');
        if (a2 >= 0 && a2 < a && !b) {
            throw new MojangsonParseException("Name error at: " + s);
        }
        if (b && (a < 0 || a > a2)) {
            a = -1;
        }
        final Stack<Character> stack = new Stack<Character>();
        int i = a + 1;
        boolean b2 = false;
        boolean b3 = false;
        int n = 0;
        int n2 = 0;
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            if (char1 == '\"') {
                if (i > 0 && s.charAt(i - 1) == '\\') {
                    if (!b2) {
                        throw new MojangsonParseException("Illegal use of \\\": " + s);
                    }
                }
                else {
                    b2 = !b2;
                    if (b2 && n == 0) {
                        b3 = true;
                    }
                    if (!b2) {
                        n2 = i;
                    }
                }
            }
            else if (!b2) {
                if (char1 == '{' || char1 == '[') {
                    stack.push(char1);
                }
                else {
                    if (char1 == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                        throw new MojangsonParseException("Unbalanced curly brackets {}: " + s);
                    }
                    if (char1 == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                        throw new MojangsonParseException("Unbalanced square brackets []: " + s);
                    }
                    if (char1 == ',' && stack.isEmpty()) {
                        return s.substring(0, i);
                    }
                }
            }
            if (!Character.isWhitespace(char1)) {
                if (!b2 && b3 && n2 != i) {
                    return s.substring(0, n2 + 1);
                }
                n = 1;
            }
            ++i;
        }
        return s.substring(0, i);
    }
    
    private static String b(String trim, final boolean b) {
        if (b) {
            trim = trim.trim();
            if (trim.startsWith("{") || trim.startsWith("[")) {
                return "";
            }
        }
        final int index = trim.indexOf(58);
        if (index >= 0) {
            return trim.substring(0, index).trim();
        }
        if (b) {
            return "";
        }
        throw new MojangsonParseException("Unable to locate name/value separator for string: " + trim);
    }
    
    private static String c(String trim, final boolean b) {
        if (b) {
            trim = trim.trim();
            if (trim.startsWith("{") || trim.startsWith("[")) {
                return trim;
            }
        }
        final int index = trim.indexOf(58);
        if (index >= 0) {
            return trim.substring(index + 1).trim();
        }
        if (b) {
            return trim;
        }
        throw new MojangsonParseException("Unable to locate name/value separator for string: " + trim);
    }
    
    private static int a(final String s, final char c) {
        int i = 0;
        boolean b = false;
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            if (char1 == '\"') {
                if (i <= 0 || s.charAt(i - 1) != '\\') {
                    b = !b;
                }
            }
            else if (!b) {
                if (char1 == c) {
                    return i;
                }
                if (char1 == '{' || char1 == '[') {
                    return -1;
                }
            }
            ++i;
        }
        return -1;
    }
    
    static {
        a = LogManager.getLogger();
    }
}
