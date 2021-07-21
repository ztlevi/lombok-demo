package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.zip.DataFormatException;

public class CustomBuilderExampleTest {
    @Test
    public void testCustomBuilderExample() {
        Assertions.assertThrows(DataFormatException.class,
            () -> {
                CustomBuilderExample.builder()
                    .name("hello")
                    .age(200)
                    .build();
            }
        );
    }

    @Test
    public void testCustomBuilderExampleWithJackson() {
        CustomBuilderExample example =
            CustomBuilderExample.builder()
                .name("hello")
                .age(10)
                .build();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(example, JsonNode.class);
        Assertions.assertEquals(node.get("name").asText(), "hello");
    }
}
