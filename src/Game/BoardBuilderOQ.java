// Intended to build a board based on pre-defined locations of 4 tiles with purple spheres
// So, take an argument that says "Which arrangement of purple spheres is this?"
// and then build a board based on that

public class BoardBuilderOQ implements BoardBuilder {

    // by default for now
    public Board build(){
        return build(0, 1, 2, 3);
    }

    // takes 4 different purple positions, build the other tiles around them
    public Board build(int p1, int p2, int p3, int p4){
        Board board = new Board();

        return board;
    }

}
