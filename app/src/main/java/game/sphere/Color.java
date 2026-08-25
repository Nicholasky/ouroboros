package game.sphere;

public enum Color {
    PURPLE(0),
    BLUE(1),
    TEAL(2),
    GREEN(3),
    YELLOW(4),
    ORANGE(5),
    RED(6),
    RAINBOW(7),
    WHITE(8),
    BLACK(9);

    private final int index;

    Color(int index){
        this.index = index;
    }
    
    public int index(){
        return index;
    }
    
}
