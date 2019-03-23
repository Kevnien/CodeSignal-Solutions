// Consider the following ciphering algorithm:

// For each character replace it with its code.
// Concatenate all of the obtained numbers.
// Given a ciphered string, return the initial one if it is known that it consists only of lowercase letters.

class Decipher{
    public static String decipher(String cipher){
        String number = "";
        int length = cipher.length();
        String answer = "";
        for(int i=0; i<length; i++){
            number += cipher.charAt(i);
            int integer = Integer.valueOf(number);
            if(integer >= 'a'){
                number = "";
                char character = (char)integer;
                answer += character;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(decipher("10197115121"));
    }
}