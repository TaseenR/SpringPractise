package com.sky.SpringCars.service;

import com.sky.SpringCars.domain.Cars;

import java.util.List;


public interface CarsService {

    Cars create(Cars car);

    List<Cars> createAll(List<Cars> newCars);


    List<Cars> getAll();


    Cars getById(Integer id);

    Cars update(Integer id, String name, Integer size, Integer age);

    Cars remove(Integer id);

}