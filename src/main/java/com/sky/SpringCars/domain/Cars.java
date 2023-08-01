package com.sky.SpringCars.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cars {

    @Id
    @GeneratedValue()
    private Integer age;
    private String name;

    private Integer engineSize;

    private Integer Id;




    public Cars(Integer Id, Integer age, String name, Integer engineSize) {
        this.Id = Id;
        this.age = age;
        this.name = name;
        this.engineSize = engineSize;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public String toString(){
        return "Cars name is " + this.name;
    }
}
