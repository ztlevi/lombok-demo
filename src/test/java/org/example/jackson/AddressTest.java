package org.example.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class AddressTest {

  @Test
  public void testAddress() throws JsonProcessingException {
    Address address =
        Address.builder()
            .street("street")
            .zipCode("1234")
            .city("my city")
            .province("province")
            .country("country")
            .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(address);

    Address read = objectMapper.readValue(json, Address.class);
    assertEquals(address, read);
  }
}
