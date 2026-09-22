public class expertState extends State{
    public expertState(player player){
        super(player);
    }
    @Override
    void action() {
        this.getPlayer().print();
        this.getPlayer().fight();
        if(this.getPlayer().getExp() == 20){
            this.getPlayer().setState(new masterState(this.getPlayer()));
        }
    }
}
