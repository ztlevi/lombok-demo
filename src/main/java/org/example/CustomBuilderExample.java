package org.example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.SneakyThrows;
import lombok.extern.jackson.Jacksonized;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.zip.DataFormatException;

// https://trguduru.github.io/2019/06/add-custom-validations-with-lombok-builders/
@Data
@Jacksonized
@AllArgsConstructor
@Builder(toBuilder = true, builderClassName = "CustomBuilder", buildMethodName = "build")
public class CustomBuilderExample {
    private long created;
    private String name;
    private int age;

    public static class CustomBuilder {

        @SneakyThrows
        public CustomBuilderExample build() {
            // Do validation here
            if (age < 0 || age > 130) {
                throw new DataFormatException(String.format("Age %d is not valid", age));
            }
            // Build the object
            return new CustomBuilderExample(System.currentTimeMillis(), name, age);
        }
    }
}


