// Given a string, find the shortest possible string which can be achieved by adding characters to the end of initial string to make it a palindrome.

class BuildPalindrome{
    public static String buildPalindrome(String st){
        String copy = st;
        String appendage = "";
        int reach = 0;
        while(!isPalindrome(copy)){
            appendage = st.charAt(reach++)+appendage;
            copy = st + appendage;
        }
        return copy;
    }

    public static boolean isPalindrome(String string){
        int length = string.length();
        int end = length/2;
        for(int i=0; i<end; i++){
            if(string.charAt(i) != string.charAt(length-(i+1))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String[] inputs = {
            "abcdc",
            "ababab",
            "abba",
            "abaa",
            "aaaaba",
            "abc",
            "kebab",
            "abccba",
            "abcabc",
            "cbdbedffcg",
            "euotmn"
        };
        String[] expectedOutputs = {
            "abcdcba",
            "abababa",
            "abba",
            "abaaba",
            "aaaabaaaa",
            "abcba",
            "kebabek",
            "abccba",
            "abcabcbacba",
            "cbdbedffcgcffdebdbc",
            "euotmnmtoue"
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "buildPalindrome("+
                inputs[i]+"):\n"+
                buildPalindrome(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}