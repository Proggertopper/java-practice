public interface CopyInterface {
    default void callback(int param){
        System.out.println(param);
    }
}
