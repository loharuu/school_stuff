public class intermediateState extends State{
    public intermediateState(player player){
        super(player);
    }

    @Override
    void action() {
        this.getPlayer().print();
        this.getPlayer().meditate();
        if(this.getPlayer().getHp() == 20){
            this.getPlayer().setState(new expertState(this.getPlayer()));
        }
    }

}
