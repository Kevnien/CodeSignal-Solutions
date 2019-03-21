// You are taking part in an Escape Room challenge designed specifically for programmers. In your efforts to find a clue, you've found a binary code written on the wall behind a vase, and realized that it must be an encrypted message. After some thought, your first guess is that each consecutive 8 bits of the code stand for the character with the corresponding extended ASCII code.

// Assuming that your hunch is correct, decode the message.

class MessageFromBinaryCode{
    public static String messageFromBinaryCode(String code){
        String answer = "";
        String character = "";
        int length = code.length();
        for(int i=0; i<length; i++){
            character += code.charAt(i);
            if((i+1)%8 == 0){
                answer += (char)Integer.parseInt(character, 2);
                character = "";
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String[][] inputOutputs = {
            {"010010000110010101101100011011000110111100100001","Hello!"}
        };
        for(String[] pair: inputOutputs){
            String answer = messageFromBinaryCode(pair[0]);
            System.out.print(
                "messageFromBinaryCode("+pair[0]+"):\n"+
                answer+"\n"+
                pair[1]+" <-- expected output "
            );
            String end = "";
            System.out.println(end);
        }
    }
}