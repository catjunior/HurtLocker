import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataParser {
    String input;
    ArrayList<String> lineList = new ArrayList<String>();
    ArrayList<String> itemList = new ArrayList<String>();
    int items;
    int errors;



    public ArrayList<String> generateLineList(String input) {
        String[] arrayOfItems = input.split("##");
        for (String x : arrayOfItems) {
            lineList.add(x);
        }
        return lineList;
    }



}