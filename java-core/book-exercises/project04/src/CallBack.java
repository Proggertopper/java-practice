public interface CallBack {
    default void callback(int param){
        System.out.println(param);
    }
    static  int getDefaultNum(){
        return 0;
    }
}
