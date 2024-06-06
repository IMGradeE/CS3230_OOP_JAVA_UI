interface Eatable {
    void eat();
}

class Fruit implements Eatable {
    private String name;
    public Fruit(String name) {
        this.name = name;
    }
    public Fruit(){
        name = "peach";
    }
    public void eat() {
        System.out.printf("Eating a %s%n", name);
    }

}

class myRunnable implements Runnable{
    @Override
    public void run() { try {
        System.out.println(1);
        Thread.sleep(1000);
        System.out.println(2);
    }catch (InterruptedException e){
        System.out.println(3);
    }
    System.out.println(4);
    }
}



public class playground {
    public static void main(String[] args) {
        Thread t = new Thread(new myRunnable());
        t.start();t.interrupt();
        try {
           Thread.sleep(1000);
        }catch (Exception e){}

    }
}

