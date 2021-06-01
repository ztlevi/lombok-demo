package org.example;

import lombok.*;

@RequiredArgsConstructor(staticName = "of")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ConstructorExample<T> {
  private int x, y;
  @NonNull private T description;

  @NoArgsConstructor
  public static class NoArgsExample {
    @NonNull private String field;
  }
}

class VanillaJavaConstructorExample<T> {
  private int x, y;
  @NonNull private T description;

  private VanillaJavaConstructorExample(T description) {
    if (description == null) throw new NullPointerException("description");
    this.description = description;
  }

  public static <T> VanillaJavaConstructorExample<T> of(T description) {
    return new VanillaJavaConstructorExample<T>(description);
  }

  @java.beans.ConstructorProperties({"x", "y", "description"})
  protected VanillaJavaConstructorExample(int x, int y, T description) {
    if (description == null) throw new NullPointerException("description");
    this.x = x;
    this.y = y;
    this.description = description;
  }

  public static class NoArgsExample {
    @NonNull private String field;

    public NoArgsExample() {}
  }
}
