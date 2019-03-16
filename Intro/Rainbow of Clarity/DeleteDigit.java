// Given some integer, find the maximal number you can obtain by deleting exactly one digit of the given number.

import java.util.Arrays;
class DeleteDigit{
    public static int deleteDigit(int n){
        int max = 0;
        String number = ""+n;
        int length = number.length();
        for(int i=0; i<length; i++){
            int modifiedNumber = deleteDigit(number, i);
            if(modifiedNumber > max){
                max = modifiedNumber;
            }
        }
        return max;
    }

    public static int deleteDigit(String number, int index){
        int length = number.length();
        char[] array = new char[length-1];
        int arrayIndex = 0;
        for(int i=0; i<length; i++){
            if(i == index){
                continue;
            }
            array[arrayIndex++] = number.charAt(i);
        }
        String string = String.copyValueOf(array);
        return Integer.valueOf(string);
    }

    public static void main(String[] args){
        int[] inputs = {
            152
        };
        int[] expectedOutputs = {
            52
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "deleteDigit("+
                inputs[i]+"):\n"+
                deleteDigit(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}