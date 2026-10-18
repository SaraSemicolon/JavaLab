package Lab4;

import java.util.ArrayList;

class Car
{
    private String carModel;
    private String carName;
    private float carPrice;
    private int yearOfProduction;

    public Car (String carModel, String carName, float carPrice, int yearOfProduction)
    {
        setCarModel(carModel);
        setCarName(carName);
        setCarPrice(carPrice);
        setYearOfProduction(yearOfProduction);
    }

    public Car (String carModel, String carName, float carPrice)
    {
        setCarModel(carModel);
        setCarName(carName);
        setCarPrice(carPrice);
        setYearOfProduction(2026);
    }

    public String getCarModel() {return carModel;}
    public void setCarModel(String carModel) {this.carModel = carModel.equals("") ? "0.0.0" : carModel;}
    public String getCarName() {return carName;}
    public void setCarName(String carName) {this.carName = carName.equals("") ? "UNKNOW" : carName;}
    public float getCarPrice() {return carPrice;}
    public void setCarPrice(float carPrice) {this.carPrice = carPrice < 0 ? 0 : carPrice;}
    public int getYearOfProduction() {return yearOfProduction;}
    public void setYearOfProduction(int yearOfProduction) {this.yearOfProduction = yearOfProduction > 2026 ? 2026 : yearOfProduction;}

    @Override
    public String toString() {
        return "Car{" +
                "carModel='" + carModel + '\'' +
                ", carName='" + carName + '\'' +
                ", carPrice=" + carPrice +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }
}

class CarTest
{
    private ArrayList<Car> cars;

    public CarTest (ArrayList<Car> cars)
    {
        this.cars = new ArrayList<>(cars);
    }

    public ArrayList<Car> getCars() {return cars;}

    public static boolean equals (Car c1 , Car c2)
    {
        return (c1.getCarModel().equalsIgnoreCase(c2.getCarModel()) &&
                c1.getCarName().equalsIgnoreCase(c2.getCarName()));
    }

    public void replaceAllTheBMW_X5CarsWithX6()
    {
        for(Car car : cars)
            if (car.getCarName().equalsIgnoreCase("BMW") && car.getCarModel().equalsIgnoreCase("X5"))
                car.setCarModel("X6");
    }

    public void removeAllTOYOTA () {
        for (int i = 0; i < cars.size();)
        {
            if (cars.get(i).getCarName().equalsIgnoreCase("TOYOTA") && cars.get(i).getYearOfProduction() <= 2012)
                cars.remove(i);
            else
                i++;
        }
    }
}

public record Task2()
{
    public static void main(String[] args)
    {
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car("X5", "BMW", 500000f, 2020));
        carList.add(new Car("Corolla", "TOYOTA", 250000f, 2010));
        carList.add(new Car("Camry", "TOYOTA", 350000f, 2015));
        carList.add(new Car("X5", "BMW", 550000f, 2021));

        CarTest test = new CarTest(carList);

        System.out.println("--- Before Modifications ---");
        for(Car c : test.getCars()) {
            System.out.println(c);
        }

        test.replaceAllTheBMW_X5CarsWithX6();

        test.removeAllTOYOTA();

        System.out.println("\n--- After Modifications (Replaced & Removed) ---");
        for(Car c : test.getCars()) {
            System.out.println(c);
        }

        if(carList.size() >= 2) {
            boolean isEquals = CarTest.equals(carList.get(0), carList.get(carList.size() - 1));
            System.out.println("\nAre car 0 and last car equal in model and name? " + isEquals);
        }
    }
}
