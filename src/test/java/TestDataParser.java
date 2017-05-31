import org.junit.Test;

import static org.junit.Assert.*;

public class TestDataParser{

    DataParser parser;

    @Before
    public void startup() { parser = new DataParser(); }

    @Test
    public void testGenerateLineList(){
        String input = "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##";
        String[] expected = {"NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016", "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016"};
        String[] actual = jerksonParser.generateLineList(input, "##");
        assertArrayEquals(expected, actual);

    }



}