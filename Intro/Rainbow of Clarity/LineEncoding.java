// Given a string, return its encoding defined as follows:

// First, the string is divided into the least possible number of disjoint substrings consisting of identical characters
// for example, "aabbbc" is divided into ["aa", "bbb", "c"]
// Next, each substring with length greater than one is replaced with a concatenation of its length and the repeating character
// for example, substring "bbb" is replaced by "3b"
// Finally, all the new strings are concatenated together in the same order and a new string is returned.

class LineEncoding{
    public static String lineEncoding(String s){
        char setCharacter = s.charAt(0);
        int count = 1;
        int length = s.length();
        String answer = "";
        char currentCharacter = '0';
        for(int i=1; i<length; i++){
            currentCharacter = s.charAt(i);
            if(setCharacter == currentCharacter){
                count++;
            }else{
                if(count>1){
                    answer += count;
                }
                answer += setCharacter;
                setCharacter = currentCharacter;
                count = 1;
            }
        }
        if(count>1){
            answer += count;
        }
        answer += setCharacter;
        setCharacter = currentCharacter;
        count = 1;
        return answer;
    }

    public static void main(String[] args){
        String[] inputs = {
            "aabbbc",
            "abbcabb",
            "abcd",
            "zzzz",
            "wwwwwwwawwwwwww",
            "ccccccccccccccc",
            "qwertyuioplkjhg",
            "ssiiggkooo",
            "adfaaa",
            "bbjaadlkjdl"
        };
        String[] expectedOutputs = {
            "2a3bc",
            "a2bca2b",
            "abcd",
            "4z",
            "7wa7w",
            "15c",
            "qwertyuioplkjhg",
            "2s2i2gk3o",
            "adf3a",
            "2bj2adlkjdl"
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "lineEncoding("+
                inputs[i]+"):\n"+
                lineEncoding(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}