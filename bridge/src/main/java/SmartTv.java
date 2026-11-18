public class SmartTv extends Tv {
    private static int addShown = 0;
    public void browseInternet(){
        showAdds();
        System.out.println("Tv: Browsing internet rn");
    }
    public void showAdds(){
        System.out.println("Tv: Showing Adds");
        addShown += 1;
    }
    @Override
    public void enable() {
        showAdds();
        super.enable();
    }

    @Override
    public void disable() {
        showAdds();
        super.disable();
    }
    @Override
    public void printStatus() {
        System.out.println("------------------------------------");
        System.out.println("| I'm Smart TV set.");
        System.out.println("| I'm " + (super.isEnabled() ? "enabled" : "disabled"));
        System.out.println("| Current volume is " + super.getVolume() + "%");
        System.out.println("| Current channel is " + super.getChannel());
        System.out.println("| Adds seen: "+addShown);
        System.out.println("------------------------------------\n");
    }

}
x