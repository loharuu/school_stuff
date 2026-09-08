public class game {
    int mapNumbr;
    int x;
    int y;

    public game(int mapNumbr, int x, int y) {
        this.x = x;
        this.y = y;
        this.mapNumbr = mapNumbr;
    }
    public void main(){
        map mapMap;
        mapMap= createMap();
        mapMap.display();
    }

    public map createMap(){
        switch (mapNumbr){
            case 1: return new cityMap(x, y);
            case 2: return new wildMap(x, y);
            default: throw new IllegalArgumentException("Unknown!");
        }
    }
}
