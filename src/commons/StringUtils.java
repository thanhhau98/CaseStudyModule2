package commons;

public class StringUtils {
    public static final String COMMA = ",";
    public static final String CSV = ".csv";

    public static String concat(String[] content, String character) {
        StringBuffer outString = new StringBuffer(content[0]);

        for (int i = 1; i < content.length; i++) {
            outString.append(character);
            outString.append(content[i]);

        }
        return outString.toString();
    }

    public static void main(String[] args) {
        String[] content = {"1","2","3"};
        String resylt = StringUtils.concat(content,",");
        System.out.println(resylt);
    }
}


