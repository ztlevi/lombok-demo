package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BuilderExampleTest {
  @Test
  public void testBuilderWithJackson() {
    BuilderExample<Double> example =
        BuilderExample.<Double>builder()
            .name("hello")
            .age(10)
            .height(181.4)
            .occupation("cook")
            .occupation("engineer")
            .build();
    ObjectMapper mapper = new ObjectMapper();
    JsonNode node = mapper.convertValue(example, JsonNode.class);
    Assertions.assertEquals(node.get("name").asText(), "hello");
  }
}
