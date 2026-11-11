public class officeComputerBuilder implements computerBuilder{
    private computer pc;

    public officeComputerBuilder(){
        this.pc = new computer();
    }

    //using components that I own.
    @Override
    public void buildProcessor() {
        pc.setCpu("AMD Ryzen 3 1200"); //this now magically supports ddr2
    }

    @Override
    public void buildRam() {
        pc.setRam(1); // Hynix PC2-5300U-555-12
    }

    @Override
    public void buildHardDrive() {
        pc.setHd("160 GB HDD"); // Seagate Barracuda ST3160812AS
    }

    @Override
    public void buildGraphicsCard() {
        pc.setGpu("MSI Geforce NX6600-TD128E"); //I got this by pure change
    }

    @Override
    public void buildOperatingSystem() {
        pc.setOs("Windows Vista");
    }

    @Override
    public computer getPC() {
        return pc;
    }
}
