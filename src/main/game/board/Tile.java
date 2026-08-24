package main.game.board;

import main.game.sphere.Sphere;
import main.game.sphere.SphereType;


public class Tile {
    Sphere sp;
    boolean revealed = false;
    boolean clicked = false;

    public Tile(Sphere sphere){
        sp = sphere;
    }

    public Sphere getSphere(){
        return sp;
    }

    public void click(){
        sp.getType().click();
        revealed = true;    // always reveal a tile when clicking on it
        clicked = true;
    }
}
