package jdev.dto;

/**
 *Test constants.
 * */

public interface ITestConstants {

    PointDTO    testPoint       = new PointDTO("1", "2", "3", 4L);
    PointDTO    testPointFalse  = new PointDTO("1", "2", "3", 5L);

    String      uri             = "http://localhost:8080/upload";
    String      testKmlFile     = "src/test/resources/test.kml";
    double[][]  testKmlArray    = {{1.1, 2.2}, {4.4, 5.5}, {7.7, 8.8}};

}
