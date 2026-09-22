public class ReadyState extends State{
    public ReadyState(player player){
        super(player);
    }

    @Override
    void action() {
        this.getPlayer().setState(new noviceState(this.getPlayer()));

    }
}
