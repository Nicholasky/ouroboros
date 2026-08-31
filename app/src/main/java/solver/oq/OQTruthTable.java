package solver.oq;

import java.util.BitSet;

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

}

// An expensive operation
private static void constructTruthTable(){
    if(populatedTT) 
        return;

    // add heatmap = bla bla bla

    for(int i = 0; i < POSSIBLE_SLOTS; i++){
        for(int j = 0; j < POSSIBLE_HEATS; j++){
            TRUTH_TABLE[i][j] = new BitSet(12650);
        }
    }


    populatedTT = true;
}


private OQTruthTable(){}





}
