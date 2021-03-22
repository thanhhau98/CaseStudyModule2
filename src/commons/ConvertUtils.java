package commons;

public class ConvertUtils {

    public static  String normalizeStr(String string) {
        StringBuilder stringBuilder = new StringBuilder(string.substring(0,1).toUpperCase());
        stringBuilder.append(string.substring(1).toLowerCase());
        return stringBuilder.toString();
    }
}
