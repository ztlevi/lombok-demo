package org.example.jackson;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class AddressLombokTest {

  @Test
  public void testAddress() throws JsonProcessingException {
    AddressLombok address =
        AddressLombok.builder()
            .street("street")
            .zipCode("1234")
            .city("my city")
            .province("province")
            .country("country")
            .build();

    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(address);

    AddressLombok read = objectMapper.readValue(json, AddressLombok.class);
    assertEquals(address, read);
  }
}
