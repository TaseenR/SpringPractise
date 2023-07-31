package com.sky.SpringCars.rest;
import com.sky.SpringCars.domain.Cars;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SpringCarsController {

    private List<Cars> carsList = new ArrayList<>();



    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/createCar")
    public HttpEntity<Cars> create(@RequestBody Cars car) {
        System.out.println("RECIEVED: " + car);
        carsList.add(car);
        Cars created = this.carsList.get(this.carsList.size()-1);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping("/createMultiple")
    public HttpEntity<List<Cars>> Carlist(@RequestBody List<Cars> list){
        System.out.println("RECIEVED a list of cars objects" + list);
        this.carsList.addAll(list);
        List<Cars> created = list;
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public HttpEntity<Cars> getById(@PathVariable Integer id) {
        System.out.println("ID: " + id);
        Cars car = this.carsList.get(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public HttpEntity<Cars> update(
            @PathVariable Integer id,
            @PathParam("engineSize") int engineSize,
            @PathParam("name") String name,
            @PathParam("age") int age) {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Engine Size : " + engineSize);
        System.out.println("Age: " + age);

        this.carsList.get(id).setAge(age);
        this.carsList.get(id).setEngineSize(engineSize);
        this.carsList.get(id).setName(name);

        Cars car = this.carsList.get(id);

        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{id}")
    public HttpEntity<Integer> remove(@PathVariable Integer id) {
        Integer currentSize = this.carsList.size();
        this.carsList.remove(id);
        Integer newSize = this.carsList.size();
        if (newSize < currentSize) {
            return new ResponseEntity<>(newSize, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(currentSize, HttpStatus.NOT_MODIFIED);
        }
    }

}
