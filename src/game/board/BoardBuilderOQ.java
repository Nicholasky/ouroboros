package game.board;

import game.sphere.Sphere;
import game.sphere.SphereType;

// Intended to build a board based on pre-defined locations of 4 tiles with purple spheres
// So, take an argument that says "Which arrangement of purple spheres is this?"
// and then build a board based on that

// ASSUMES That number of purples WILL ALWAYS be 4 (for the purpose of this minigame)
public class BoardBuilderOQ implements BoardBuilder {

    // randomly make a board by default
    public Board build(){
        int rand = (int)Math.floor(12650.0 * Math.random());
        return build(rand);
    }

    // supply an arrangement (0 to 12649)
    public Board build(int arrangement){
        int[] purples = _decodeArrangement(arrangement);
    
        return build(purples);
    }

    // takes 4 different purple positions, build the other tiles around them
    // rules:   color defined by number of adjacent purples  (in the 8 tiles around this tile)
    //          0: blue
    //          1: teal
    //          2: green
    //          3: yellow
    //          4: orange
    
    public Board build(int[] purples){
        Board board = new Board();
        Tile[][] tiles = board.getTiles();

        for (int pos : purples) {
            int row = pos / 5;
            int col = pos % 5;

            tiles[row][col] = new Tile(new Sphere(SphereType.PURPLE));
        }

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {

                if (tiles[row][col] != null) {
                    continue;
                }

                int adjacentPurples =
                    countAdjacentPurples(board, row, col);

                SphereType type; 

                switch (adjacentPurples) {
                    case 0: 
                        type = SphereType.BLUE;
                        break;
                    case 1:
                        type = SphereType.TEAL;
                        break;
                    case 2:
                        type = SphereType.GREEN;
                        break;
                    case 3:
                        type = SphereType.YELLOW;
                        break;
                    case 4:
                        type = SphereType.ORANGE;
                        break;
                    default:
                        throw new IllegalStateException();
                };

                tiles[row][col] = new Tile(new Sphere(type));
            }

        }

        return board;
    }


    private int countAdjacentPurples(Board board, int row, int col) {
        int count = 0;

        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {

                if (dr == 0 && dc == 0) {
                    continue;
                }

                int r = row + dr;
                int c = col + dc;

                // avoid outofbounds checking
                if (r < 0 || r >= 5 || c < 0 || c >= 5) {
                    continue;
                }

                Tile tile = board.getTiles()[r][c];

                if (tile != null &&
                    tile.getSphere().getType() == SphereType.PURPLE) {
                    count++;
                }
            }
        }

        return count;
    }

    // Decode an arrangement-id in [0, 12649] to a unique arrangement of 4 purple spheres in a 5x5 grid 
    private static int[] _decodeArrangement(int arrangement){
        int[] values = new int[4];
        int remainder = arrangement;

        for(int i = 0; i < 4; i++){
            int k = 4 - i;  // k: index of array
            int j = k - 1;  // j: highest value that fulfills nCr(j, k) <= rem
            
            while(nCr(j+1, k) <= remainder){
                j++;
            }

            values[i] = j;
            remainder -= nCr(j, k);
        }


        return values;
    }

    // calc number of combinations; n choose k
    private static int nCr(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;

        if (k > n / 2) k = n - k;

        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return (int) result;
    }

}
