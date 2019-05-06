package com.example.bean1;

/**
 * Author : JinTao Li
 * Create Time : 2019/5/5
 */
public class Person {
    private String name;
    private int age;
    private String content;


    public Person() {
    }

    public Person(String name, int age, String content) {
        this.name = name;
        this.age = age;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", content='" + content + '\'' +
                '}';
    }
}
