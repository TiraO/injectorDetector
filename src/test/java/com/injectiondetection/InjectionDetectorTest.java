package com.injectiondetection;

import org.junit.Test;

public class InjectionDetectorTest {

    @Test
    public void findsAutowiredFields() throws Exception {
        InjectionDetector injectionDetector = new InjectionDetector();

        assert injectionDetector.fieldNames("com.injectiondetection.examples").contains("CarController::carService");
    }
}
