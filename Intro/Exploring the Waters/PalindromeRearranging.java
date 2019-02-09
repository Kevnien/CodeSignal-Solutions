// Given a string, find out if its characters can be rearranged to form a palindrome.
import java.util.*;

class PalindromeRearranging{
    public static boolean palindromeRearranging(String inputString) {
        Hashtable<Character, Integer> letters = new Hashtable<Character, Integer>();
        for(int i=0; i<inputString.length(); i++){
            Character current = inputString.charAt(i);
            Integer amount = letters.get(current);
            if(amount == null){
                letters.put(current, 1);
            }else{
                letters.put(current, (Integer)(amount+1));
            }
        }
        boolean foundAnOdd = false;
        for(Enumeration<Integer> e = letters.elements(); e.hasMoreElements();){
            Integer current = e.nextElement();
            if(current%2 == 1){
                if(foundAnOdd){
                    return false;
                }else{
                    foundAnOdd = true;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args){
        String[] inputString = {"aabb",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc",
            "abbcabb",
            "zyyzzzzz",
            "z",
            "zaa",
            "abca",
            "abcad",
            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbccccaaaaaaaaaaaaa",
            "abdhuierf"
        };
        for(int i=0; i<inputString.length; i++){
            System.out.println("palindromeRearranging("
                +inputString[i]
                +"): "
                +palindromeRearranging(inputString[i])
            );
        }
    }    
}