 class Gen <T , D extends Number>{
    T ob;
    D ov;

    Gen(T ob , D ov){
        this.ob = ob;
        this.ov = ov;
    }
    T getOb(){
        return this.ob;
     }
     D getOv(){
        return this.ov;
     }

     void showTypes(){
         System.out.println("Типом T является " + ob.getClass().getName());
         System.out.println("Типом D является " + ov.getClass().getName());
     }
     static <T extends Comparable<T> , V extends T> boolean isIn(T x , V[] y){
         for (int i = 0; i < y.length ; i++) {
             if(x.equals(y[i])) return true;
         }
         return false;
     }
}

class GenDemo{
    public static void main(String[] args) {
        var ob = new Gen<String , Integer>("Привет" , 44);
       String v = ob.getOb();
       int v1 = ob.getOv();
        System.out.println(v);
        ob.showTypes();
        String[] str = {"Вася" , "Коля"};
        System.out.println(Gen.isIn("Вася" , str ));

    }
}
