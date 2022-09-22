package web.Service;


import web.model.Car;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

//@org.springframework.stereotype.Service
@Component
public class ServiceImpl implements Service{

    public ServiceImpl() {
    }

    @Override
    public List<Car> getCarsFromList(int carsQuantity, List<Car> carList) {
        List<Car> processedCarList = new ArrayList<>();
        for (int x = 0; x < carsQuantity; x++) {
            processedCarList.add(carList.get(x));
        }
        return processedCarList;
    }

}
