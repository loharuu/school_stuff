import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class weatherStation extends Thread{
    volatile boolean isLaunched;
    int temp;
    int maxTemp;
    int minTemp;
    Random r = new Random();
    private List<observer> observers = new ArrayList<>();

    public weatherStation(int maxTemp, int minTemp) {
        this.temp = r.nextInt(maxTemp,minTemp);
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.isLaunched = false;
    }
    public void addObserver(observer observer) {
        System.out.println("Added observer");
        observers.add(observer);

    }
    public void removeObserver(observer observer) {
        System.out.println("Removed observer");
        observers.remove(observer);
    }
    public void notifyObservers(int temp) {
        for (observer observer : observers) {
            observer.update(temp);
        }
    }
    @Override
    public void run() {
        isLaunched = true;
        while (isLaunched) {
            if (temp == maxTemp) {
                temp--;
            } else if (temp == minTemp) {
                temp++;
            } else {
                int coinFlip = r.nextInt(0, 2);
                if (coinFlip == 0) {
                    temp--;
                } else {
                    temp++;
                }
            }
            notifyObservers(temp);
            System.out.println();
            try {
                TimeUnit.SECONDS.sleep(r.nextInt(0, 6));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void stopThis(){
        isLaunched = false;
    }
}
