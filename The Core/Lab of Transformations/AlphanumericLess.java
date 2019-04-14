// An alphanumeric ordering of strings is defined as follows: each string is considered as a sequence of tokens, where each token is a letter or a number (as opposed to an isolated digit, as is the case of lexicographic ordering). For example, the tokens of a string "ab01c004" are [a, b, 01, c, 004]. In order to compare two strings, you break them down into tokens and compare corresponding pairs of tokens with each other (i.e. first token of the first string, with the first token of the second string etc).

// Here is how tokens are compared:

// If a letter is compared with another letter, the usual order applies.
// A number is always less than a letter.
// When two numbers are compared, their values are compared. Leading zeros, if any, are ignored.
// If at some point one string has no more tokens left while the other one still does, the one with fewer tokens is considered smaller.

// If the two strings s1 and s2 appear to be equal, consider the smallest index i such that tokens(s1)[i] and tokens(s2)[i] (where tokens(s)[i] is the ith token of string s) differ only by the number of leading zeros. If no such i exists, the strings are indeed equal. Otherwise, the string whose ith token has more leading zeros is considered less.

// Here are some examples of comparing strings using alphanumeric ordering.

// "a" < "a1" < "ab" < "ab42" < "ab000144" < "ab00144" < "ab144" < "ab000144x" < "x11y012" < "x011y13"

class AlphanumericLess{
    public static boolean alphanumericLess(String s1, String s2){
        String[] strings = {s1, s2};
        String tokenS1 = getToken(strings, 0);
        String tokenS2 = getToken(strings, 1);
        boolean hasZero = false;
        while(tokenS1!=null || tokenS2!=null){
            if(tokenS1 != null && tokenS2 == null){
                return false;
            }
            if(tokenS1==null){
                return true;
            }
            boolean isChar1 = isChar(tokenS1);
            boolean isChar2 = isChar(tokenS2);
            if(isChar1){
                if(isChar2){
                    if(tokenS1.compareTo(tokenS2) > 0){
                        return false;
                    }
                }else{
                    return false;
                }
            }
            if(!isChar1 && !isChar2){
                int[] num1 = getNum(tokenS1);
                int[] num2 = getNum(tokenS2);
                // System.out.println("num1: "+num1[1]+"\tnum2: "+num2[1]);
                if(num1[1] > num2[1]){
                    return false;
                }
                if(num1[1] < num2[1]){
                    return true;
                }
                if(num1[1] == num2[1]){
                    if(num1[0] < num2[0]){
                        hasZero = true;
                    }
                }
            }
            tokenS1 = getToken(strings, 0);
            tokenS2 = getToken(strings, 1);
            // System.out.println("token1: "+tokenS1+"\ttoken2: "+tokenS2);
        }
        if(s1.compareTo(s2)==0){
            if(hasZero){
                return true;
            }
            return false;
        }
        if(hasZero){
            return false;
        }
        return true;
    }

    public static int[] getNum(String token){
        int zeroCount = 0;
        int index;
        boolean broke = false;
        // System.out.println("getNum token: "+token);
        for(index=0; index<token.length(); index++){
            if(token.charAt(index) != '0'){
                broke = true;
                break;
            }
            zeroCount++;
        }
        int[] answer = new int[2];
        answer[0] = zeroCount;
        if(broke){
            String number = "";
            for(; index<token.length(); index++){
                char character = token.charAt(index);
                if(character<'0' || character>'9'){
                    break;
                }
                number += character;
            }
            // System.out.println("number: "+number);
            answer[1] = Integer.valueOf(number);
        }else{
            answer[1] = 0;
        }
        return answer;
    }

    public static boolean isChar(String string){
        if(string.length() > 1){
            return false;
        }
        char character = string.charAt(0);
        if(character>='0' && character<='9'){
            return false;
        }
        return true;
    }

    public static String getToken(String[] strings, int stringsIndex){
        if(strings[stringsIndex].length() == 0){
            return null;
        }
        int index = 0;
        char token = strings[stringsIndex].charAt(index++);
        String answer = "";
        answer += token;
        if(token>='a' && token<='z'){
            strings[stringsIndex] = strings[stringsIndex].substring(index);
            return answer;
        }
        for(; index<strings[stringsIndex].length(); index++){
            token = strings[stringsIndex].charAt(index);
            if(token<'0' || token>'9'){
                break;
            }
            answer += token;
        }
        strings[stringsIndex] = strings[stringsIndex].substring(index);
        return answer;
    }

    public static void main(String[] args){
        System.out.println(alphanumericLess("a", "a1")); //true
        System.out.println(alphanumericLess("ab", "a1")); //false
        System.out.println(alphanumericLess("b", "a1")); //false
        System.out.println(alphanumericLess("x11y012", "x011y13")); //true
        System.out.println(alphanumericLess("ab123", "ab34z")); //false
        System.out.println(alphanumericLess("0000", "000")); //true
        System.out.println(alphanumericLess("10", "01")); //false
        System.out.println(alphanumericLess("ab000144", "ab144")); //true
        System.out.println(alphanumericLess("ab", "a")); //false
        System.out.println(alphanumericLess("000", "0000")); //false
        System.out.println(alphanumericLess("abc123", "abc123")); //false
        System.out.println(alphanumericLess("zza1233", "zza1234")); //true
        System.out.println(alphanumericLess("zzz1", "zzz1")); //false
        System.out.println(alphanumericLess("00", "a2")); //true
    }
}