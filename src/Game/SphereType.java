public class SphereType {
    final Color color;
    final int baseValue;
    int timesPressed;
    int value;
    
    public static final SphereType purple = new SphereType(Color.PURPLE, 5);
    public static final SphereType blue = new SphereType(Color.BLUE, 10);
    public static final SphereType teal = new SphereType(Color.TEAL, 20);
    public static final SphereType green = new SphereType(Color.GREEN, 35);
    public static final SphereType yellow = new SphereType(Color.YELLOW, 55);
    public static final SphereType orange = new SphereType(Color.ORANGE, 90);
    public static final SphereType red = new SphereType(Color.RED, 150);
    public static final SphereType rainbow = new SphereType(Color.RAINBOW, 500);
    // public static final SphereType white = new SphereType(Color.WHITE, ???);
    // public static final SphereType black = new SphereType(Color.BLACK, ???);

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


}
