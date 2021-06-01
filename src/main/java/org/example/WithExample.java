package org.example;


import lombok.AccessLevel;
import lombok.NonNull;
import lombok.With;

public class WithExample {
    @With(AccessLevel.PROTECTED) @NonNull private final String name;
    @With private final int age;

    public WithExample(String name, int age) {
        if (name == null) throw new NullPointerException();
        this.name = name;
        this.age = age;
    }
}

class VanillaJavaWithExample {
    private @NonNull final String name;
    private final int age;

    public VanillaJavaWithExample(String name, int age) {
        if (name == null) throw new NullPointerException();
        this.name = name;
        this.age = age;
    }

    protected VanillaJavaWithExample withName(@NonNull String name) {
        if (name == null) throw new java.lang.NullPointerException("name");
        return this.name == name ? this : new VanillaJavaWithExample(name, age);
    }

    public VanillaJavaWithExample withAge(int age) {
        return this.age == age ? this : new VanillaJavaWithExample(name, age);
    }
}
