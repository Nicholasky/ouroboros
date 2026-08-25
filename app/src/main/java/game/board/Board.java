package game.board;

public class Board {
    Tile[][] tiles;

    public Board(){
        tiles = new Tile[5][5];
    }


    public Tile[][] getTiles(){
        return tiles;
    }


    // Note: No difference in tostring for a hidden vs visible tile 
    @Override
    public String toString(){  
        char[] buildStr = new char[25];

        int index;
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                index = 5*i+j;
                buildStr[index] = tiles[i][j].getSphere().getType().getColor();
            }
        }

        String returnStr = new String(buildStr);
        return returnStr;
    }

}
