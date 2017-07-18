package com.mbdebian.codingtasks.models;

/**
 * @author Manuel Bernal Llinares
 *         Project: accession-service
 *         Package: com.mbdebian.codingtasks.models
 *         Timestamp: 2017-07-18 20:27
 *         ---
 *         © 2017 Manuel Bernal Llinares <mbdebian@gmail.com>
 *         All rights reserved.
 *
 *         Unit tests, for main application model, this way we get enough coverage
 */
public class AppModelTest {

    private AppModel appModel = new AppModel();
    private String givenInput;
    private String expectedOutput;

    public AppModelTest(String givenInput, String expectedOutput) {
        this.givenInput = givenInput;
        this.expectedOutput = expectedOutput;
    }
}