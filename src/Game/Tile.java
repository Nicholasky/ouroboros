public class Tile {
    Sphere sp;
    boolean revealed = false;

    public Tile(Sphere sphere){
        sp = sphere;
    }

    public Sphere getSphere(){
        return sp;
    }
}
