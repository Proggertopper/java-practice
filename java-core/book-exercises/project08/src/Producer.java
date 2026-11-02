public class Producer implements Runnable{
    Q q;

    Producer(Q q){
        this.q = q;
        new Thread(this).start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            q.put(i++);
        }
    }
}
