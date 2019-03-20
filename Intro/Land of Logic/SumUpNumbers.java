// CodeMaster has just returned from shopping. He scanned the check of the items he bought and gave the resulting string to Ratiorg to figure out the total number of purchased items. Since Ratiorg is a bot he is definitely going to automate it, so he needs a program that sums up all the numbers which appear in the given input.

// Help Ratiorg by writing a function that returns the sum of numbers that appear in the given inputString.

class SumUpNumbers{
    public static int sumUpNumbers(String inputString){
        int length = inputString.length();
        boolean intFlag = false;
        String number = "";
        int total = 0;
        for(int i=0; i<length; i++){
            char currentChar = inputString.charAt(i);
            if(currentChar>='0' && currentChar<='9'){
                intFlag = true;
                number += currentChar;
                continue;
            }
            if(intFlag){
                total += Integer.valueOf(number);
                number = "";
            }
            intFlag = false;
        }
        if(intFlag){
            total += Integer.valueOf(number);
            number = "";
        }
        return total;
    }

    public static void main(String[] args){
        String[] inputs = {
            "2 apples, 12 oranges",
            "123450",
            "Your payment method is invalid",
            "no digits at all",
            "there are some (12) digits 5566 in this 770 string 239",
            "42+781",
            "abc abc 4 abc 0 abc",
            "abcdefghijklmnopqrstuvwxyz1AbCdEfGhIjKlMnOpqrstuvwxyz23,74 -"
        };
        int[] expectedOutputs = {
            14,
            123450,
            0,
            0,
            6587,
            823,
            4,
            98
        };
        int index = 0;
        for(String input: inputs){
            int answer = sumUpNumbers(input);
            System.out.print(
                "sumUpNumbers("+
                input+"):\n"+
                answer+"\n"+
                expectedOutputs[index]+
                " <-- expected output"
            );
            String end = "";
            if(answer != expectedOutputs[index++]){
                end = " FAILED";
            }else{
                end = " PASSED";
            }
            System.out.println(end);
        }
    }
}