package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.FieldNameConstantsExample.Fields;

public class FieldNameConstantsExampleTest {

    @Test
    void testFieldName() {
        Assertions.assertEquals(FieldNameConstantsExample.Fields.I_AM_A_FIELD, "iAmAField");
    }
}
