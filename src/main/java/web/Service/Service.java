package web.Service;

import web.model.Car;
import java.util.ArrayList;
import java.util.List;

public interface Service {
    List<Car> getCarsFromList(int carsQuantity, List<Car> carList);
}
