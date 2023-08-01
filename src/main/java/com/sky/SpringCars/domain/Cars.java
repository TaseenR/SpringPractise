package com.sky.SpringCars.domain;

public class Cars {

    private Integer age;
    private String name;

    private Integer engineSize;

    private Integer Id;


    public Cars(Integer age, String name, Integer engineSize) {
        this.age = age;
        this.name = name;
        this.engineSize = engineSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(Integer engineSize) {
        this.engineSize = engineSize;
    }
}
