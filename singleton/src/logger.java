import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class logger {
    private static logger instance;
    private File file;
    private FileWriter writer;
    private logger(){
        setFileName("logger.txt");
    }

    public static synchronized logger getInstance(){
        if(instance == null){
            instance = new logger();
        }
        return instance;
    }

    public synchronized void write(String txt){
        try {
            if(writer == null){
                createWriter();
            }
            writer.write(txt);
            writer.write("\n");
            System.out.println("Text written");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void close(){
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private synchronized void createWriter(){
        try {
            writer = new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    synchronized void setFileName(String url){
        try {
            file = new File(url);
            if(file.createNewFile()){
                System.out.println("Created file: "+file.getName());
                createWriter();
            }else{
                System.out.println("File exist");
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
