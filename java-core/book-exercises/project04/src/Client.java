
public class Client implements CallBack , CopyInterface{
    public static void main(String[] args) {
       CallBack callBack = new Client();
       callBack.callback(12);
       Client client = new Client();
       client.callback(12);
       client.showNumTwo(123);
       int num = CallBack.getDefaultNum();
        System.out.println(num);
    }


    public void showNumTwo(int num){
        System.out.println(num);
    }

    @Override
    public void callback(int param) {
        CallBack.super.callback(param);
    }
}