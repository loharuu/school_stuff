public class gamingComputerBuilder implements computerBuilder {
    private computer pc;

    public gamingComputerBuilder(){
        this.pc = new computer();
    }

    //using my main pc stats.
    @Override
    public void buildProcessor() {
        pc.setCpu("AMD Ryzen 5 5600g");
    }

    @Override
    public void buildRam() {
        pc.setRam(32);
    }

    @Override
    public void buildHardDrive() {
        pc.setHd("256 GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        pc.setGpu("AMD Radeon RX 9060 XT");
    }

    @Override
    public void buildOperatingSystem() {
        pc.setOs("Manjaro Linux");
    }

    @Override
    public computer getPC() {
        return pc;
    }
}
