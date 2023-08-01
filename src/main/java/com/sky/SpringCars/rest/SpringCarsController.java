package com.sky.SpringCars.rest;
import com.sky.SpringCars.domain.Cars;
import com.sky.SpringCars.service.CarsService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class SpringCarsController {

    private CarsService service;

    public SpringCarsController(CarsService service) {
        this.service = service;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @PostMapping("/createCar")
    public HttpEntity<Cars> create(@RequestBody Cars car) {
        System.out.println("RECIEVED: " + car);
        Cars created = this.service.create(car);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping("/createMultiple")
    public HttpEntity<List<Cars>> Carlist(@RequestBody List<Cars> list){
        System.out.println("RECIEVED a list of cars objects" + list);
        List<Cars> created = this.service.createAll(list);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public HttpEntity<Cars> getById(@PathVariable Integer id) {
        System.out.println("ID: " + id);
        Cars car = this.service.getById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public Cars update(
            @PathVariable Integer id,
            @RequestParam(value = "engineSize", required = true) Integer engineSize,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "age", required = false) Integer age) {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Engine Size : " + engineSize);
        System.out.println("Age: " + age);

        return this.service.update(id,name,age,engineSize);
    }

    @DeleteMapping("/remove/{id}")
    public Cars remove(@PathVariable Integer id){
        Cars deleteCar = this.service.getById(id);
        this.service.remove(id);
        return deleteCar;

    }

    @GetMapping("/getAll")
    public List<Cars> getAll(){
        return this.service.getAll();
    }

}
