import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {

    private int errors;
    ArrayList<String> lineList = new ArrayList<String>();


    public ArrayList<String> splitLines(String input) {
        String[] arrayOfItems = input.split("##");
        for (String x : arrayOfItems) {
            lineList.add(x);
        }
        return lineList;
    }

    public String nameMatcher(String line) throws LineFormatException {
        Matcher name= Pattern.compile("(?i)(name.)([a-z0-9]+)").matcher(line);
        if(name.find()){
            return name.group(2);
        }
        else{
            throw new LineFormatException("Missing Name");
            //errors ++; can't add..idk why
        }
    }

    public String priceMatcher(String line) throws LineFormatException {
        Matcher price= Pattern.compile("(?i)(price.)([0-9.]+)").matcher(line);
        if(price.find()){
            return price.group(2);
        }
        else{
            throw new LineFormatException("Missing Price");
            //errors ++; can't add..idk why
        }
    }

    public String typeMatcher(String line) throws LineFormatException {
        Matcher type= Pattern.compile("(?i)(type.)([a-z]+)").matcher(line);
        if(type.find()){
            return type.group(2);
        }
        else{
            throw new LineFormatException("Missing Type");
            //errors ++; can't add..idk why
        }
    }

    public String expirationMatcher(String line) throws LineFormatException {
        Matcher exp= Pattern.compile("(?i)(expiration.)(\\d{1,2}\\/\\d{1,2}\\/\\d{4})").matcher(line);
        if(exp.find()){
            return exp.group(2);
        }
        else{
            throw new LineFormatException("Missing Expiration Date");
            //errors ++; can't add..idk why
        }
    }


}