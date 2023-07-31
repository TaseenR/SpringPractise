package com.sky.SpringCars.domain;

public class Cars {

    private int age;
    private String name;

    private int engineSize;

    public Cars() {
    }

    public Cars(int age, String name, int engineSize) {
        this.age = age;
        this.name = name;
        this.engineSize = engineSize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }
}
