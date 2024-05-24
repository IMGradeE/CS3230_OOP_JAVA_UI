interface Eatable {
    void eat();
}

class Fruit implements Eatable {
    public void eat() {
        System.out.println("Eating a fruit");
    }

}

public class playground {
    public static void main(String[] args) {
        try{
            Fruit myFruit = new Fruit();
            myFruit.eat();

        }finally {
            System.out.println("finally");
        }
    }
}