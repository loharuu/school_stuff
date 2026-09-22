public class player {
    private String name;
    private int exp = 0;
    private int hp = 1;
    private State state;
    private boolean isRun = true;

    public player(){
        state = new ReadyState(this);
    }
    public void play(String name){
        this.name = name;
        while(isRun){
            if (state == null){return;}
            state.action();
        }
    }
    public void setState(State state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public int getHp() {
        return hp;
    }

    public void train(){
        this.exp += 1;
    }
    public void meditate(){
        this.hp += 1;
    }
    public void fight(){
        this.exp += 1;
        this.hp -= 1;
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }

    public void print(){
        System.out.println(name+ ", exp: "+exp+ ", hp: "+hp);
    }
}
