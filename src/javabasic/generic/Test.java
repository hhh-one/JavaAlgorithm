package javabasic.generic;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) { // Java 5 -> Java 20 -> Java 21 LTS
        Box<Apple> box = new Box<>();
        box.setItem(new Apple());

        Box<String> box2 = new Box<>();
        box2.setItem("apple");
        box2.setItem("apple");

        System.out.println(box.getItem());
        System.out.println(box2.getItem());
    }
}
