package com.mbdebian.codingtasks.models;

import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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

    @Parameterized.Parameters
    public static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
                {"A00000,A0001,ERR000111,ERR000112,ERR000113,ERR000115,ERR000116,ERR100114,ERR200000001,ERR200000002,ERR200000003,DRR2110012,SRR211001,ABCDEFG1",
                        "A00000,A0001,ABCDEFG1,DRR2110012,ERR000111-ERR000113,ERR000115-ERR000116,ERR100114,ERR200000001-ERR200000003,SRR211001"}
        });
    }
}