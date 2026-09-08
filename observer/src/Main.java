public class Main {
    public static void main(String[] args) throws InterruptedException {
        weatherStation wStation = new weatherStation(-40,50);
        observingThing obs1 = new observingThing("This is OBSERVER 1");
        observingThing obs2 = new observingThing("This is OBSERVER 2");
        observingThing obs3 = new observingThing("This is OBSERVER 3");
        observingThing obs4 = new observingThing("This is OBSERVER 4");

        wStation.start();

        wStation.addObserver(obs1);
        wStation.addObserver(obs2);
        wStation.addObserver(obs3);
        wStation.addObserver(obs4);
        Thread.sleep(10000);
        wStation.removeObserver(obs2);



    }
}
