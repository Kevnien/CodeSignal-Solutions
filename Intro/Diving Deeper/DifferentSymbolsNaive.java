// Given a string, find the number of different characters in it.

import java.util.Hashtable;
class DifferentSymbolsNaive{
    public static int differentSymbolsNaive(String s){
        Hashtable<Character, Boolean> ht = new Hashtable<Character, Boolean>();
        int length = s.length();
        int total = 0;
        for(int i=0; i<length; i++){
            char currentChar = s.charAt(i);
            if(ht.get(currentChar) == null){
                ht.put(currentChar, true);
                total++;
            }
        }
        return total;
    }

    public static void main(String[] args){
        String[] inputs = {
            "cabca",
            "aba",
            "ccccccccccc",
            "bcaba",
            "codesignal"
        };
        int[] expectedOutputs = {
            3,
            2,
            1,
            3,
            10
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "differentSymbolsNaive("+
                inputs[i]+"):\n"+
                differentSymbolsNaive(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected Output"
            );
        }
    }
}