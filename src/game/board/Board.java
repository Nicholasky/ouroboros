package game.board;

public class Board {
    Tile[][] tiles;

    public Board(){
        tiles = new Tile[5][5];
    }


    Tile[][] getTiles(){
        return tiles;
    }


}
