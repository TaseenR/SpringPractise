package com.sky.SpringCars.service;

import com.sky.SpringCars.domain.Cars;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class CarsServiceList implements CarsService {

    private List<Cars> cars = new ArrayList<>();

    @Override
    public Cars create(Cars car) {
        this.cars.add(car);
        Cars created = this.cars.get(this.cars.size() - 1);
        return created;
    }

    @Override
    public List<Cars> createAll(List<Cars> newCarss) {
        if (this.cars.addAll(newCarss)) {
            return newCarss;
        } else {
            return null;
        }
    }

    @Override
    public List<Cars> getAll() {
        return this.cars;
    }

    @Override
    public Cars getById(Integer id) {
        Cars found = this.cars.get(id);
        return found;
    }

    @Override
    public Cars update(Integer id, String name, Integer size, Integer age) {
        Cars toUpdate = this.cars.get(id);
        if (name != null) toUpdate.setName(name);
        if (size != null) toUpdate.setEngineSize(size);
        if (age != null) toUpdate.setAge(age);
        return toUpdate;
    }

    @Override
    public Cars remove(Integer id) {
        Cars deleteCar = this.cars.get(id);
        this.cars.remove(id.intValue());
        return deleteCar;
    }
}