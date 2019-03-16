// Define a word as a sequence of consecutive English letters. Find the longest word from the given string.

class LongestWord{
    public static String longestWord(String text){
        boolean foundLetter = false;
        int length = text.length();
        String answer = "";
        String temp = "";
        for(int i=0; i<length; i++){
            char current = text.charAt(i);
            if((current>='a'&&current<='z') || (current>='A'&&current<='Z')){
                if(foundLetter){
                    temp += current;
                }else{
                    foundLetter = true;
                    temp = "" + current;
                    continue;
                }
            }else{
                if(foundLetter){
                    foundLetter = false;
                    if(temp.length() > answer.length()){
                        answer = temp;
                    }
                }
            }
        }
        if(temp.length() > answer.length()){
            answer = temp;
        }
        return answer;
    }

    public static void main(String[] args){
        String[][] inputOutputs = {
            {
                "Ready, steady, go!",
                "steady"
            },
            {
                "Ready[[[, steady, go!",
                "steady"
            },
            {
                "ABCd",
                "ABCd"
            },
            {
                "To be or not to be",
                "not"
            },
            {
                "You are the best!!!!!!!!!!!! CodeFighter ever!",
                "CodeFighter"
            }
        };
        for(String[] inputOutput: inputOutputs){
            System.out.println(
                "longestWord("+
                inputOutput[0]+"):\n"+
                longestWord(inputOutput[0])+"\n"+
                inputOutput[1]+
                " <-- expected output"
            );
        }
    }
}