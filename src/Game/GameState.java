public abstract class GameState{
    Board board;
    int movesRemaining;
    
    public GameState(Board b){
        this.board = b;
    }

}