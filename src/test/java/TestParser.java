import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;


public class TestParser {

    Parser parser;

    @Before
    public void startup() { parser = new Parser(); }

    @Test
    public void testGenerateLineList(){
        String input = "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";
        ArrayList<String> expected = new ArrayList<String>();

        expected.add("NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016");
        expected.add("naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016");
        ArrayList<String> actual = parser.splitLines(input);

        assertTrue(expected.equals(actual));
    }

    @Test(expected = LineFormatException.class)
    public void testNameMatcherEXC() throws LineFormatException {
        //missing name
        String input = ":MiLK;price:3.23;type:Food^expiration:1/11/2016##";

        String expected = "MiLK";
        String actual = parser.nameMatcher(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testNameMatcher() throws LineFormatException {
        String input = "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";

        String expected = "MiLK";
        String actual = parser.nameMatcher(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testPriceMatcher() throws LineFormatException {
        String input = "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";

        String expected = "3.23";
        String actual = parser.priceMatcher(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testTypeMatcher() throws LineFormatException {
        String input = "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";

        String expected = "Food";
        String actual = parser.typeMatcher(input);

        assertEquals(expected, actual);
    }

    @Test
    public void testExpirationMatcher() throws LineFormatException {
        String input = "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";

        String expected = "1/11/2016";
        String actual = parser.expirationMatcher(input);

        assertEquals(expected, actual);
    }

}