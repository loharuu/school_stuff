import javafx.scene.image.Image;

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
    public Image getTileImage(int row, int col) {
        tile tile = mapMap[row][col];
        return tile.getTileImage().getImage();
    }

    public tile[][] getMapMap() {
        return mapMap;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
