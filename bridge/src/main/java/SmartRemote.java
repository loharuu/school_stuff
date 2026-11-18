public class SmartRemote extends AdvancedRemote {
    public SmartRemote(Device device) {
        super(device);
    }
    public void voiceControl(){
        System.out.println("Remote: Using voice control");
        System.out.println("Remote: Sending voice file to LLM");
        System.out.println("Remote: Sending all of collected info to Meta");
        System.out.println("Remote: Thinking...");
        System.out.println("Remote: Getting answer");
        System.out.println("Remote: Error: Not enough personal information collected");
    }
    public void browseInternet(){
        System.out.println("Remote: Trying to browse");
        ((SmartTv) device).browseInternet();
    }
}
