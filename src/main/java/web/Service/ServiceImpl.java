package web.Service;


import web.model.Car;


import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{


    @Override
    public List<Car> getCarsFromList(int carsQuantity, List<Car> carList) {
        List<Car> processedCarList = new ArrayList<>();
        for (int x = 0; x >= carsQuantity; x++) {
            processedCarList.add(carList.get(x));
        }
        return processedCarList;
    }

}
