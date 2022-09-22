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

@Controller
public class CarController {

    @Autowired
    public Service service;

    @GetMapping(value = "/")
    public String getCars(ModelMap model) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Porsche", 911, "Red"));
        cars.add(new Car("Porsche", 914, "White"));
        cars.add(new Car("ToyotaMark", 2, "Black"));
        cars.add(new Car("Peugeot", 206, "Blue"));
        cars.add(new Car("MitsubishiLancer", 8, "Yellow"));

        List<String> messages = new ArrayList<>();

        /*AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(WebConfig.class);
        Service service = context.getBean(Service.class);*/
        List<Car> processedCarList = service.getCarsFromList(2, cars);
        for (Car car : cars) {
            messages.add(car.getManufacturer() + car.getSeries() + car.getColor());
            }

        model.addAttribute("messages", messages);

        //model.addAttribute("cars", cars);
        return "index";
    }
}
