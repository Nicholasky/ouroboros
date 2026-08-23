public class SphereType {
    final Color color;
    final int baseValue;
    int timesPressed;
    int value;
    
    public static final SphereType PURPLE = new SphereType(Color.PURPLE, 5);
    public static final SphereType BLUE = new SphereType(Color.BLUE, 10);
    public static final SphereType TEAL = new SphereType(Color.TEAL, 20);
    public static final SphereType GREEN = new SphereType(Color.GREEN, 35);
    public static final SphereType YELLOW = new SphereType(Color.YELLOW, 55);
    public static final SphereType ORANGE = new SphereType(Color.ORANGE, 90);
    public static final SphereType RED = new SphereType(Color.RED, 150);
    public static final SphereType RAINBOW = new SphereType(Color.RAINBOW, 500);
    // public static final SphereType WHITE = new SphereType(Color.WHITE, ???);
    // public static final SphereType BLACK = new SphereType(Color.BLACK, ???);

    private SphereType(Color color, int baseValue){
        this.color = color;
        value = this.baseValue = baseValue;
        timesPressed = 0;
    }

    public Color getColor(){
        return color;
    }

    public int getValue(){
        return baseValue;
    }

    public void setValue(int newValue){
        this.value = newValue;
    }

    void click(){
        ++timesPressed;
    }

}
