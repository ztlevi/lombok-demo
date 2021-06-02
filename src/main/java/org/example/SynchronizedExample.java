package org.example;

import lombok.Synchronized;

public class SynchronizedExample {
  private final Object readLock = new Object();

  @Synchronized
  public static void hello() {
    System.out.println("world");
  }

  @Synchronized
  public int answerToLife() {
    return 42;
  }

  @Synchronized("readLock")
  public void foo() {
    System.out.println("bar");
  }
}

class VanillaJavaSynchronizedExample {
  private static final Object $LOCK = new Object[0];
  private final Object $lock = new Object[0];
  private final Object readLock = new Object();

  public static void hello() {
    synchronized ($LOCK) {
      System.out.println("world");
    }
  }

  public int answerToLife() {
    synchronized ($lock) {
      return 42;
    }
  }

  public void foo() {
    synchronized (readLock) {
      System.out.println("bar");
    }
  }
}
