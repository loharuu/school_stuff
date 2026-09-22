public abstract class State {
    private player player;
    public State(player player){
        this.player = player;
    }
    public player getPlayer(){
        return player;
    }
    abstract void action();
}
