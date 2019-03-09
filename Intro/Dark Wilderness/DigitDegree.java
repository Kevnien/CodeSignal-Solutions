// Let's define digit degree of some positive integer as the number of times we need to replace this number with the sum of its digits until we get to a one digit number.

// Given an integer, find its digit degree.

class DigitDegree{
    public static int digitDegree(int n){
        return recursion(n, 0);
    }

    public static int recursion(int n, int count){
        if(n/10 == 0){
            return count;
        }else{
            int newN = 0;
            while(n>0){
                newN += n%10;
                n /= 10;
            }
            return recursion(newN, ++count);
        }
    }

    public static void main(String[] args){
        int[] inputs = {
            5,
            100,
            91,
            99,
            1000000000,
            9,
            73,
            877,
            777773,
            304
        };
        int[] expectedOutputs = {
            0,
            1,
            2,
            2,
            1,
            0,
            2,
            2,
            3,
            1
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "digitDegree("+
                inputs[i]+"):\n"+
                digitDegree(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}