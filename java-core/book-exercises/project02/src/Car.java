public class Car implements Comparable<Car> {
    private int maxSpeed;
    private int manufactureYear;
    private String model;

    public Car(int maxSpeed , int manufactureYear , String model ){
    this.maxSpeed = maxSpeed;
    this.manufactureYear = manufactureYear;
    this.model = model;
    }

    @Override
    public int compareTo(Car o) {
        return this.getManufactureYear() - o.getManufactureYear();
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public String getModel() {
        return model;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return String.format("Car{manufactureYear=%d, model=%s , maxSpeed=%d}\n" , getManufactureYear() , getModel() , getMaxSpeed());
    }
}
