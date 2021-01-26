package jdev.tracker;

import jdev.dto.PointDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KmlParserTest {

    @Test
    public void kmlParser () {
        String testKmlFile = "src/test/resources/test.kml";
        double[][] array = {{1.1, 2.2}, {4.4, 5.5}, {7.7, 8.8}};
        KmlParser kmlParser = new KmlParser(testKmlFile);

        PointDTO item;

        for (int i=0; i<array.length; i++) {
            item = kmlParser.getNext();

            if (item == null) {
                if (i==0) assert false;
                break;
            }
            else {
                assertEquals(String.valueOf(array[i][0])+"0000", item.getLat());
                assertEquals(String.valueOf(array[i][1])+"0000", item.getLon());
            }
        }
    }

}
