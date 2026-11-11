public class computerDirector {
    private computerBuilder cb;
    public computerDirector(computerBuilder cb){
        this.cb = cb;
    }
    public void constructComputer(){
        cb.buildGraphicsCard();
        cb.buildHardDrive();
        cb.buildOperatingSystem();
        cb.buildProcessor();
        cb.buildRam();
    }
    public void printComputer(){
        computer pc = cb.getPC();
        System.out.println("OS: "+pc.getOs()+", CPU: "+pc.getCpu()+", RAM(GB): "+pc.getRam()+", GPU: "+pc.getGpu()+", HARD DRIVE: "+pc.getHd());
    }
}
