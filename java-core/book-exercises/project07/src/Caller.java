public class Caller implements Runnable{
    String msg;
    final Callme target;
    Thread t;

    Caller(Callme targ , String s){
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        synchronized (target){
            target.call(msg);
        }
    }
}
