public abstract class map{
    tile[][] mapMap;
    int x;
    int y;
    public map(int x, int y) {
        this.x = x;
        this.y = y;
        this.mapMap = new tile[x][y];
    }

    abstract tile createTile();
        public void create(){
            for(int i = 0; i < x; i++){
                for(int ii = 0; ii < y; ii++){
                    mapMap[i][ii] = createTile();
                }
            }
        }
    void display(){
            create();
            for(int i = 0; i < x; i++){
                for(int ii = 0; ii < y; ii++){
                    System.out.print(mapMap[i][ii].getChar() + " ");
                }
                System.out.println();
            }
    }
}
