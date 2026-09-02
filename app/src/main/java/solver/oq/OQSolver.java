package solver.oq;

import java.util.BitSet;

// intends to solve OQ boards / show optimal moves given a board state
// as the hidden state of the board is unveiled, different pre-solved recommendations are made

// Needs to be able to track all 12650 board-states, to know which are still valid, recommendable, and CALCULABLE states

// Needs conditions to "disqualify" board states quickly, so that after a choice is made,
// it is known that board b1, board b2, board b3... are no longer eligible or calculable

// Needs a basis / "value" for applying actions on a board. Expected value of spheres ? 

public class OQSolver {
    private static final int NUM_MOVES = 7;
    
    public int solve(){
        BitSet bits = new BitSet(12650);
        bits.set(0, 12650);
        return solveRecur(bits, NUM_MOVES);
        
    }


    // Problem:
    // it is unknown which board is being played;
    // the "board" makes a choice in reveal information every turn.

    // idea to solve:
    // recurse on "expected value" of boards
    // so that the unknown "board choice" is accounted for,
    // together with teh probability that choice occurs

    // BitSet b = OQTruthTable.getMatchingBoards(d, h) 
    // P(tile d has heat h) = b.cardinality / remainingBoards.cardinality  

    // Recursive call would be: (For all tile-heat combinations, get maximum of): 
    //      (b.cardinality / remainingBoards.cardinality) * solveRecur(state, b, movesLeft
    private int solveRecur(BitSet remainingBoards, int movesLeft){
        int val = 0;

        // cardinality = 0 should only be possible if an invalid move occurs
        if(remainingBoards.cardinality() == 0)
            return 0;
        
        if(movesLeft == 0){
            return 0;
        }




        return val; // TEMP 

    }

    

}
