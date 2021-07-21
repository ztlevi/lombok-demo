package org.example;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;

import lombok.Lombok;
import lombok.SneakyThrows;

// @SneakyThrows can be used to sneakily throw checked exceptions without actually declaring
// this in your method's throws clause.
public class SneakyThrowsExample implements Runnable {
  @SneakyThrows(UnsupportedEncodingException.class)
  public String utf8ToString(byte[] bytes) {
    return new String(bytes, "UTF-8");
  }

  @SneakyThrows({IOException.class, ParseException.class})
  public void filtersExceptions(String fileName) {
    if (fileName.startsWith("0")) {
      throw new ParseException("test", 1);
    } else {
      throw new IOException();
    }
  }

  @SneakyThrows
  public void run() {
    throw new Throwable();
  }
}

class VanillaJavaSneakyThrowsExample implements Runnable {
  public String utf8ToString(byte[] bytes) {
    try {
      return new String(bytes, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw Lombok.sneakyThrow(e);
    }
  }

  public void run() {
    try {
      throw new Throwable();
    } catch (Throwable t) {
      throw Lombok.sneakyThrow(t);
    }
  }
}
