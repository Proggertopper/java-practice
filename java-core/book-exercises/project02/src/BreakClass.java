public class BreakClass {
    public static void main(String[] args){
       /* for (int i = 0; i < 12; i++) {
            switch(i){
                case 1:
                case 2:
                case 0:
                case 3:
                case 4:
                    System.out.println("i меньше 5");
                    break;
                case 5:
                case 6:
                case 7:
                case 8:
                    System.out.println("i больше 5");
                    break;
                default:
                    System.out.println("i чему-ТО РАВНО");
            }
        }

        int i , j;

        i = 100;
        j = 200;
        while(++i < --j);
        System.out.println("среднее значение равно " + i);*/
        int a , b;
        for (a = 0 , b = 3; a  < b; b-- , a++) {
            System.out.println(a);
            System.out.println(b);
        }
        boolean t = true;

        first:{
            second:{
            third:{
                System.out.println("лда");
                if (t) break second;
              }
                System.out.println("fa");
            }
            System.out.println("dafa");
        }



        for (; ; ) {

        }
    }
}
