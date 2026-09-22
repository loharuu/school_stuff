public class noviceState extends State{
    public noviceState(player player){
        super(player);
    }

    public void action() {
        this.getPlayer().print();
        this.getPlayer().train();
        if(this.getPlayer().getExp() == 10){
            this.getPlayer().setState(new intermediateState(this.getPlayer()));
        }

    }

}
