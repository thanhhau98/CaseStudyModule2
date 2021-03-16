package commons;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {

    public static boolean validate(String string,String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);
        return !matcher.matches();
    }

}
