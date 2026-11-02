package MyPackage;



public class BoxWeight extends Box {
    public double weight;

    public BoxWeight(double w , double h , double d , double m){
        super(w , h , d);
        weight = m;
    }

    public void show(){
        super.show();
        System.out.println(weight);
    }
}
