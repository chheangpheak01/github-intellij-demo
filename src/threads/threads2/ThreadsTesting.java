package threads.threads2;

public class ThreadsTesting implements Runnable{
    public static void main(String[] args){
        ThreadsTesting obj = new ThreadsTesting();
        Thread thread = new Thread(obj);
        thread.start();
        System.out.println("This is the outside code");
    }
    public void run(){
        System.out.println("This code is inside the run method");
    }
}
