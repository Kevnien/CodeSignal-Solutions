// Write a function that reverses characters in (possibly nested) parentheses in the input string.

// Input strings will always be well-formed with matching ()s.
class ReverseInParenthesis{
    String reverseInParentheses(String inputString) {
        int length = inputString.length();
        char[] array = new char[length];
        int[] arrayIndex = {0};
        int[] i = new int[1];
        for(i[0]=0; i[0]<length; i[0]++){
            char current = inputString.charAt(i[0]);
            if(current == '('){
                addTheReverse(inputString, i, array, arrayIndex);
                i[0]--;
                continue;
            }
            array[arrayIndex[0]++] = current;
        }
        char[] newArray = new char[arrayIndex[0]];
        copy(newArray, array);
        String string = new String(newArray);
        return string;
    }
    
    void copy(char[] newArray, char[] array){
        for(int i=0; i<newArray.length; i++){
            newArray[i] = array[i];
        }
    }
    
    void addTheReverse(String inputString, int[] i, char[] array, int[] index){
        int length = inputString.length();
        char[] reverseArray = new char[length];
        int[] raIndex = {0};
        i[0]++;
        char current = inputString.charAt(i[0]++);
        while(current != ')'){
            if(current == '('){
                i[0]--;
                addTheReverse(inputString, i, reverseArray, raIndex);
                current = inputString.charAt(i[0]++);
                continue;
            }
            reverseArray[raIndex[0]++] = current;
            current = inputString.charAt(i[0]++);
        }
        for(int j=raIndex[0]-1; j>-1; j--){
            array[index[0]++] = reverseArray[j];
        }
    }
}