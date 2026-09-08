public class Main {
    public static void main(String[] args) {
        logger loggr = logger.getInstance();
        loggr.setFileName("new_log.txt"); // Change file name
        loggr.write("Simulation started");
        loggr.write("Processing data...");
        loggr.write("Simulation finished");
        loggr.close(); // Remember to close the logger
    }
}