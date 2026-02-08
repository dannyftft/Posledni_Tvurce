//TODO Memory leak -> pravděpodobně kvůli tomu že nezavírám scannery
import hra.Hra;

public class Main {
    public static void main(String[] args) {
        Hra hra = new Hra();
        hra.start();
    }
}