package org.example;

import lombok.Data;
import lombok.NonNull;

class Something {
  public Something(String hello) {}
}

@Data
class Person {
  String name;
}

public class NonNullExample extends Something {
  private String name;

  public NonNullExample(@NonNull Person person) {
    super("Hello");
    this.name = person.getName();
  }

  public void viallaJavaNonNullExample(@NonNull Person person) {
    if (person == null) {
      throw new NullPointerException("person is marked @NonNull but is null");
    }
    this.name = person.getName();
  }
}
