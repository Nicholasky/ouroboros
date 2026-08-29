package util;

import java.util.BitSet;

public class ChoiceTracker{
    BitSet choices;

    public ChoiceTracker(int numChoices){
        choices = new BitSet(numChoices);
    }
    

}