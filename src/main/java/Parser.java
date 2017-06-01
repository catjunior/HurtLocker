import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {

    private static int errors;
    ArrayList<String> lineList = new ArrayList();
    ArrayList<Item> itemList = new ArrayList();


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
            errors ++;
            throw new LineFormatException("Missing Name");
        }
    }

    public String priceMatcher(String line) throws LineFormatException {
        Matcher price= Pattern.compile("(?i)(price.)([0-9.]+)").matcher(line);
        if(price.find()){
            return price.group(2);
        }
        else{
            errors ++;
            throw new LineFormatException("Missing Price");
        }
    }

    public String typeMatcher(String line) throws LineFormatException {
        Matcher type= Pattern.compile("(?i)(type.)([a-z]+)").matcher(line);
        if(type.find()){
            return type.group(2);
        }
        else{
            errors ++;
            throw new LineFormatException("Missing Type");
        }
    }

    public String expirationMatcher(String line) throws LineFormatException {
        Matcher exp= Pattern.compile("(?i)(expiration.)(\\d{1,2}\\/\\d{1,2}\\/\\d{4})").matcher(line);
        if(exp.find()){
            return exp.group(2);
        }
        else{
            errors ++;
            throw new LineFormatException("Missing Expiration Date");
        }
    }

    public ArrayList<Item> createItemList() throws LineFormatException {

        for (int i=0; i< lineList.size(); i++){
            itemList.add(new Item(nameMatcher(lineList.get(i)), priceMatcher(lineList.get(i)), typeMatcher(lineList.get(i)), expirationMatcher(lineList.get(i))));
        }
        return itemList;
    }



}