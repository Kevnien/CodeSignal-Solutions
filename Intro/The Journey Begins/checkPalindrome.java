// Given the string, check if it is a palindrome.

class checkPalindrome{
    boolean checkPalindrome(String inputString) {
        for(int i=0; i<inputString.length()/2; i++){
            if(inputString.charAt(i) != inputString.charAt(inputString.length()-(i+1))){
                return false;
            }
        }
        return true;
    }
}


