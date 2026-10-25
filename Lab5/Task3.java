package Lab5;

class Vehicle
{
    private String name;
    private String color;
    private double price;
    private int numberOfCylinders;
    static private int numberOfVehicles = 0;

    Vehicle (String name ,String color ,double price ,int numberOfCylinders)
    {
        setName(name); setColor(color);
        setPrice(price); setNumberOfCylinders(numberOfCylinders);
        numberOfVehicles++;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    public void setPrice(double price) {this.price = price;}
    public int getNumberOfCylinders() {return numberOfCylinders;}
    public void setNumberOfCylinders(int numberOfCylinders) {this.numberOfCylinders = numberOfCylinders;}
    public static int getNumberOfVehicles() {return numberOfVehicles;}
    protected static void setNumberOfVehicles(int numberOfVehicle) {Vehicle.numberOfVehicles = numberOfVehicle;}

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", numberOfCylinders=" + numberOfCylinders +
                '}';
    }

    public double getPrice()
    {
        return price;
    }
}

class Car extends Vehicle
{
    private int numberOfPassengers;
    static private int numberOfVehicles = 0;

    Car (String name ,String color ,double price ,int numberOfCylinders,int numberOfPassengers)
    {
        super(name,color,price,numberOfCylinders);
        setNumberOfPassengers(numberOfPassengers);
        numberOfVehicles++;
    }

    public int getNumberOfPassengers() {return numberOfPassengers;}
    public void setNumberOfPassengers(int numberOfPassengers) {this.numberOfPassengers = numberOfPassengers;}
    public static int getNumberOfVehicles() {return numberOfVehicles;}

    @Override
    public String toString() {
        return "Car{" +
                "numberOfPassengers=" + numberOfPassengers +
                '}';
    }

    @Override
    public double getPrice()
    {
        if(getNumberOfCylinders() <= 4)
            return super.getPrice() * 1.15;
        else
            return super.getPrice() * 1.3;
    }
}

class Truck extends Vehicle
{
    private int loadCapacity;
    static private int numberOfVehicles = 0;

    Truck (String name ,String color ,double price ,int numberOfCylinders,int loadCapacity)
    {
        super(name,color,price,numberOfCylinders);
        setLoadCapacity(loadCapacity);
        numberOfVehicles++;
    }

    public int getLoadCapacity() {return loadCapacity;}
    public void setLoadCapacity(int loadCapacity) {this.loadCapacity = loadCapacity;}
    public static int getNumberOfVehicles() {return numberOfVehicles;}

    @Override
    public String toString() {
        return "Truck{" +
                "loadCapacity=" + loadCapacity +
                '}';
    }

    @Override
    public double getPrice()
    {
        if(getNumberOfCylinders() <= 6 && loadCapacity < 3500)
            return super.getPrice() * 1.1;
        else
            return super.getPrice() * 1.2;
    }

}

public class Task3
{
    public static void main(String[] args)
    {
        Vehicle vehicles [] = new Vehicle[5];
        vehicles[0] = new Car("BMW","Black",3500000,2,4);
        vehicles[1] = new Car("BB","Yellow",3000000,3,6);
        vehicles[2] = new Truck("XX","Red",4000000,5,2);
        vehicles[3] = new Car("AA","Black",3700000,2,4);
        vehicles[4] = new Truck("WW","Blue",7000000,10,4);

        double totalPriceOfCars = 0;
        double totalPriceOfTrucks = 0;
        int countOfCars = 0;
        int countOfTrucks = 0;

        for(int i =0;i<vehicles.length;i++)
        {
            if(vehicles[i] instanceof Car) {
                totalPriceOfCars += vehicles[i].getPrice();
                countOfCars++;
            }
            else {
                totalPriceOfTrucks += vehicles[i].getPrice();
                countOfTrucks++;
            }
        }

        System.out.println("Avg Of Cars = " + totalPriceOfCars/countOfCars);
        System.out.println("Avg Of Trucks = " + totalPriceOfTrucks/countOfTrucks);

        System.out.println(Vehicle.getNumberOfVehicles());
        System.out.println(Car.getNumberOfVehicles());
        System.out.println(Truck.getNumberOfVehicles());
    }
}
