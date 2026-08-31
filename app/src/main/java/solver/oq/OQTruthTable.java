package solver.oq;

import java.util.BitSet;
import game.board.BoardBuilderOQ;   // for heatmap


// Need faster comparisons at cost of space

// So Implement OQTruthTable as:

// BitSet[a][b] c
// a: The board slot (0 - 24)
// b: Heat index at that slot (-1 - 4)
// c: 12650 bits. A bit d is true if board with rank d (0 <= d < 12650) contains the slot-heat pair (a, b).

// This costs A Lot of space (~ 25 * 6 * 12650/8 B ~ 420KB)
// but provides O(1) lookup and possibility to O(1) 'AND' out solutions that dont work
// with a possibility of L2 cache misses****

// but reducing the time complexity of "reducing the problem size" in the recursive step to O(1) <with Bitwise AND> is worth it.

public final class OQTruthTable {
    // should this problem ever be expanded for non-standard OQ board sizes, this constants setup will need revisiting.
    private static final int POSSIBLE_SLOTS = 25;
    private static final int POSSIBLE_HEATS = 6;
    private static final int MIN_HEAT = -1;
    private static final int MAX_HEAT = 4;
    private static final int POSSIBLE_BOARDS = 12650;

    private static final BitSet[][] TRUTH_TABLE = new BitSet[POSSIBLE_SLOTS][POSSIBLE_HEATS];
    private static boolean populatedTT = false;

    static{
        constructTruthTable();
    }

    // An expensive operation
    private static void constructTruthTable(){
        if(populatedTT) 
            return;

        // data received as int[board-id][row 0.4][col 0-4] Not ideal for us here but we can make do 
        // --> transform to int[board-id][slot 0-24] as we go  (taking 2x as long to make later population easier) -- prolly not worth it
        int[][] allHeatmaps = new int[POSSIBLE_BOARDS][POSSIBLE_SLOTS];
        BoardBuilderOQ bbOQ = new BoardBuilderOQ();

        for(int i = 0; i < POSSIBLE_BOARDS; i++){
            // arr[5 slots][5 slots]
            int[][] heatmap = bbOQ.buildHeat(i);

            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    int combinedIndex = j * 5 + k;
                    allHeatmaps[i][combinedIndex] = heatmap[j][k];
                }
            }
        }

        for(int i = 0; i < POSSIBLE_SLOTS; i++){
            for(int j = 0; j < POSSIBLE_HEATS; j++){
                TRUTH_TABLE[i][j] = new BitSet(12650);  // initial values FALSE
            }

            for(int k = 0; k < POSSIBLE_BOARDS; k++){
                int heat = allHeatmaps[k][i]; // i fear this may cause cache misses
                int heatIndex = heat - MIN_HEAT;
                TRUTH_TABLE[i][heatIndex].set(k);
            }
        }


        populatedTT = true;
    }


    private OQTruthTable(){}


    // returns a BitSet with <number of unique boards> bits
    // bit-value of 1 at position n represents that board with id n has the same heat at that tile.  
    public static BitSet getBoardsMatching(int slot, int heat){
        if(!populatedTT)
            return null;    // not populated, get null ... maybe error throw is better

        BitSet bits = (BitSet)TRUTH_TABLE[slot][heat].clone();  // clone; want guaranteed immutability of truth table   <though this isnt the ideal solution>
        return bits;
    }




}
