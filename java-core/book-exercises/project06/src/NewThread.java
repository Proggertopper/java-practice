public class NewThread extends Thread{
    private String name;
    Thread t ;

    NewThread(String nameThread){
        name = nameThread;
         t = new Thread(this , name);
        System.out.println("Новый поток: " + t);
        t.start();// поток исполнения запускается с метода run()
    }
    @Override
    public synchronized void run() {
        for (int i = 5; i > 0 ; i--) {
            System.out.println(name + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println( name + " завершен.");
    }
}
