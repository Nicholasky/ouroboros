package game.board;

import game.sphere.Sphere;
import game.sphere.SphereType;
import math.Combinatorics;

// Intended to build a board based on pre-defined locations of 4 tiles with purple spheres
// So, take an argument that says "Which arrangement of purple spheres is this?"
// and then build a board based on that

// ASSUMES That number of purples WILL ALWAYS be 4 (for the purpose of this minigame)
public class BoardBuilderOQ implements BoardBuilder {

    // randomly make a board by default
    public Board buildBoard(){
        int rand = (int)Math.floor(12650.0 * Math.random());
        return buildBoard(rand);
    }

    // supply an arrangement (0 to 12649)
    public Board buildBoard(int arrangement){
        return heatToBoard(buildHeat(arrangement));
    }

    public int[][] buildHeat(int arrangement){
        int[] purples = Combinatorics.decodeArrangement(arrangement, 4);

        return build(purples);
    }

    

    
    // takes 4 different purple positions, build the other tiles around them
    // rules:   color defined by number of adjacent purples  (in the 8 tiles around this tile)
    //          0: blue
    //          1: teal
    //          2: green
    //          3: yellow
    //          4: orange
    public int[][] build(int[] purples){
        int[][] heatmap = new int[5][5];

        for (int pos : purples) {
            int row = pos / 5;
            int col = pos % 5;
            heatmap[row][col] = -8; // lazy sentinel for purples

            for(int i = row-1; i <= row+1; i++){
                for(int j = col-1; j <= col+1; j++){
                    if(i < 0 || j < 0 || i > 4 || j > 4)
                        continue;
                    heatmap[i][j]++;
                }
            }
        }

        return heatmap;
    }

    Board heatToBoard(int[][] heatmap){
        Board board = new Board();
        Tile[][] tiles = board.getTiles();


        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                SphereType type = null;
                switch(heatmap[i][j]){
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
                        type = SphereType.PURPLE;   // technically fragile but should only occur for negative heat values
                        break;
                }

                tiles[i][j] = new Tile(new Sphere(type));

            }
        }

        return board;
    }

}
