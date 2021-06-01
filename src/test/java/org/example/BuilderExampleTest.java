package org.example;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.example.VanillaJavaBuilderExample.BuilderExampleBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuilderExampleTest {
    @Test
    public void testBuilderWithJackson() {
        BuilderExample example = BuilderExample.builder()
            .name("hello")
            .age(10)
            .occupation("cook")
            .occupation("engineer")
            .build();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(example, JsonNode.class);
        Assertions.assertEquals(node.get("name").asText(), "hello");
    }
}
