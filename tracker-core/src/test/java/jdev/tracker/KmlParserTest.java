package jdev.tracker;

import jdev.dto.ITestConstants;
import jdev.dto.PointDTO;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KmlParserTest implements ITestConstants {

    @Test
    public void kmlParser () {
        KmlParser kmlParser = new KmlParser(testKmlFile);

        PointDTO item;

        for (int i = 0; i< testKmlArray.length; i++) {
            item = kmlParser.getNext();

            if (item == null) {
                if (i==0) assert false;
                break;
            }
            else {
                assertEquals(String.valueOf(testKmlArray[i][0])+"0000", item.getLat());
                assertEquals(String.valueOf(testKmlArray[i][1])+"0000", item.getLon());
            }
        }
    }

}
