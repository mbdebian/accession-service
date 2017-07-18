package com.mbdebian.codingtasks.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

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
@RunWith(Parameterized.class)
public class AppModelTest {

    private AppModel appModel = new AppModel();
    private String givenInput;
    private String expectedOutput;

    public AppModelTest(String givenInput, String expectedOutput) {
        this.givenInput = givenInput;
        this.expectedOutput = expectedOutput;
    }

    @Test
    public void testSortAndAggregation() {
        List<String> input = Arrays.asList(givenInput.split(","));
        List<String> output = appModel.sortAndAggregate(input);
        String outputString = String.join(",", output);
        assertTrue(String.format("Expected output '%s' matches calculated output '%s'",
                expectedOutput,
                outputString),
                outputString.equals(expectedOutput));
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
                {"A00000,A0001,ERR000111,ERR000112,ERR000113,ERR000115,ERR000116,ERR100114,ERR200000001,ERR200000002,ERR200000003,DRR2110012,SRR211001,ABCDEFG1",
                        "A00000,A0001,ABCDEFG1,DRR2110012,ERR000111-ERR000113,ERR000115-ERR000116,ERR100114,ERR200000001-ERR200000003,SRR211001"}
        });
    }
}