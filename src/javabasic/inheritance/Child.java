package javabasic.inheritance;

public class Child extends Parent {
    int age;

    public Child(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println(this.toString());
        System.out.println(super.toString());
    }
}
