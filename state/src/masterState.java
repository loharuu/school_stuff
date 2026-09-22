public class masterState extends State{
    public masterState(player player){
        super(player);
    }
    @Override
    void action() {
        this.getPlayer().print();
        System.out.println("YOU WON!!!");
        this.getPlayer().setRun(false);
    }
}
