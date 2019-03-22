// You've intercepted an encrypted message, and you are really curious about its contents. You were able to find out that the message initially contained only lowercase English letters, and was encrypted with the following cipher:

// Let all letters from 'a' to 'z' correspond to the numbers from 0 to 25, respectively.
// The number corresponding to the ith letter of the encrypted message is then equal to the sum of numbers corresponding to the first i letters of the initial unencrypted message modulo 26.
// Now that you know how the message was encrypted, implement the algorithm to decipher it.

class Cipher26{
    public static String cipher26(String message){
        int length = message.length();
        int total = 0;
        String answer = "";
        answer += message.charAt(0);
        total += message.charAt(0)-'a';
        for(int i=1; i<length; i++){
            char current = (char)((((((message.charAt(i)-total)-'a')%26)+26)%26)+'a');
            answer += current;
            total += current-'a';
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(cipher26("taiaiaertkixquxjnfxxdh"));
    }
}