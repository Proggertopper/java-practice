public class Car {
    private String name;

    public Car(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o){
        if(this == o) return true;

        if(!(o instanceof Car)) return false;

        Car car = (Car) o;
        return this.getName().equals(car.getName());
    }

    public int hashCode(){
        return name.hashCode();
    }

}
