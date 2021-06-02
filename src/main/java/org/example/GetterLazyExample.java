package org.example;

import java.util.concurrent.atomic.AtomicReference;
import lombok.Getter;

public class GetterLazyExample {
  @Getter(lazy = true)
  private final double[] cached = expensive();

  private double[] expensive() {
    double[] result = new double[1000000];
    for (int i = 0; i < result.length; i++) {
      result[i] = Math.asin(i);
    }
    return result;
  }
}

class VanillaJavaGetterLazyExample {
  private final AtomicReference<java.lang.Object> cached = new AtomicReference<java.lang.Object>();

  public double[] getCached() {
    java.lang.Object value = this.cached.get();
    if (value == null) {
      synchronized (this.cached) {
        value = this.cached.get();
        if (value == null) {
          final double[] actualValue = expensive();
          value = actualValue == null ? this.cached : actualValue;
          this.cached.set(value);
        }
      }
    }
    return (double[]) (value == this.cached ? null : value);
  }

  private double[] expensive() {
    double[] result = new double[1000000];
    for (int i = 0; i < result.length; i++) {
      result[i] = Math.asin(i);
    }
    return result;
  }
}
