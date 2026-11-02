package MyPackage;

public class Box {
   protected double width;
    protected double height;
    private double depth;

    public Box(double width , double height , double depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public Box() {
    }

    public double volume(){
        return width * height * depth;
    }

    public void show(){
        System.out.println(width + " " + height + " " + depth) ;
    }
}
