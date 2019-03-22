// Your Informatics teacher at school likes coming up with new ways to help you understand the material. When you started studying numeral systems, he introduced his own numeral system, which he's convinced will help clarify things. His numeral system has base 26, and its digits are represented by English capital letters - A for 0, B for 1, and so on.

// The teacher assigned you the following numeral system exercise: given a one-digit number, you should find all unordered pairs of one-digit numbers whose values add up to the number.

import java.util.Arrays;
class NewNumeralSystem{
    public static String[] newNumeralSystem(char number){
        String[] answer = new String[((number-'A')/2)+1];
        for(int i=0; i<answer.length; i++){
            String string = "";
            string += (char)('A'+i);
            string += " + ";
            string += (char)(number-i);
            answer[i] = string;
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(newNumeralSystem('G')));
    }
}