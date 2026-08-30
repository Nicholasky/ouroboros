package solver.oq;

public class OQTruthTable {

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




}
