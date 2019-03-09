// A string is said to be beautiful if each letter of the alphabet appears at most as many times as than the previous letter; ie: b occurs no more times than a; c occurs no more times than b; etc.

// Given a string, check whether it is beautiful.

import java.util.Hashtable;
class IsBeautifulString{
    public static boolean isBeautifulString(String inputString){
        boolean[] letters = new boolean[26];
        for(int i=0; i<letters.length; i++){
            letters[i] = false;
        }
        Hashtable<Character, Integer> hashtable = new Hashtable<Character, Integer>();
        int length = inputString.length();
        for(int i=0; i<length; i++){
            char current = inputString.charAt(i);
            Integer currentHTVal = hashtable.get(current);
            if(currentHTVal == null){
                letters[current-'a'] = true;
                hashtable.put(current, 1);
            }else{
                hashtable.put(current, currentHTVal+1);
            }
        }
        int current = 0;
        int previous = 0;
        int index = 0;
        for(index=0; index<letters.length; index++){
            if(letters[index]){
                if(index>0){
                    System.out.println("a does not exist");
                    return false;
                }
                current = hashtable.get((char)('a'+index));
                System.out.println(((char)('a'+index))+": "+current);
                break;
            }
        }
        boolean flag = false;
        while(index<letters.length-1){
            index++;
            if(letters[index]){
                if(flag){
                    return false;
                }
                previous = current;
                current = hashtable.get((char)('a'+index));
                System.out.println(((char)('a'+index))+": "+current);
                if(current>previous){
                    return false;
                }
            }else{
                flag = true;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[] inputs = {
            "bbbaacdafe",
            "aabbb",
            "bbc",
            "bbbaa",
            "abcdefghijklmnopqrstuvwxyzz",
            "abcdefghijklmnopqrstuvwxyz",
            "abcdefghijklmnopqrstuvwxyzqwertuiopasdfghjklxcvbnm",
            "fyudhrygiuhdfeis",
            "zaa",
            "zyy"
        };
        boolean[] expectedOutputs = {
            true,
            false,
            false,
            false,
            false,
            true,
            true,
            false,
            false,
            false
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "isBeautifulString("+
                inputs[i]+"):\n"+
                isBeautifulString(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}