package util;

import java.util.BitSet;

public class ChoiceTracker{
    private final BitSet choices;
    private final int numChoices;

    public ChoiceTracker(BitSet choices, int numChoices){
        this.choices = choices;
        this.numChoices = numChoices;
    }

    public ChoiceTracker(int numChoices){
        this.choices = new BitSet(numChoices);
        this.numChoices = numChoices;
    }

    public ChoiceTracker eliminate(int[] indices){
        BitSet next = (BitSet)choices.clone();

        // the alternative was to create BitSets outside of this class with indices false and AND them together...
        // but it was not my desire to add BitSet everywhere around the code
        for(int i : indices){
            next.clear(i);
        }
        
        return new ChoiceTracker(next, numChoices);
    }

}