package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.Service.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

//1. �������� ��� ���� ����������, ������������ �� /cars.
@Controller
public class CarController {

    @Autowired
    public Service service;

    @GetMapping(value = "/")
    public String getCars(ModelMap model) {
        //3. �������� ������ �� 5 �����.
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Porsche", 911, "Red"));
        cars.add(new Car("Porsche", 914, "White"));
        cars.add(new Car("ToyotaMark", 2, "Black"));
        cars.add(new Car("Peugeot", 206, "Blue"));
        cars.add(new Car("MitsubishiLancer", 8, "Yellow"));

        //4. �������� ������ � �������, ������� ����� ���������� ��������� ����� ����� �� ���������� ������.
        List<Car> finalCarList = service.getCarsFromList(2, cars);


        List<String> messages = new ArrayList<>();
        for (Car car : finalCarList) {
            messages.add(car.getManufacturer() + car.getSeries() + car.getColor());
            }

        model.addAttribute("messages", messages);

        return "index";
    }
}
