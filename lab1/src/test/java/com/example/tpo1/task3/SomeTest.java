package com.example.tpo1.task3;

import org.junit.jupiter.api.Test;

public class SomeTest {

    @Test
    public void test(){
        Book book = new Book();
        book.getKindOfActionList().forEach(System.out::println);
    }
}
