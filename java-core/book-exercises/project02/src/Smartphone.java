public class Smartphone extends Phone{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public  void setAge(int age){
        this.age = age;
    }

    public Smartphone(String name) {
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public String call(){
        return "siii";
    }
}
