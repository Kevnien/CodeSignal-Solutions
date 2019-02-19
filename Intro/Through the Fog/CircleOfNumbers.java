// Consider integer numbers from 0 to n - 1 written down along the circle in such a way that the distance between any two neighboring numbers is equal (note that 0 and n - 1 are neighboring, too).

// Given n and firstNumber, find the number which is written in the radially opposite position to firstNumber.

class CircleOfNumbers{
    public static int circleOfNumbers(int n, int firstNumber){
        int answer = firstNumber + (n/2);
        if(answer >= n){
            answer -= n;
        }
        return answer;
    }

    public static void main(String[] args){
        int[][] inputs = {
            {10,2},
            {10,7},
            {4,1},
            {6,3}
        };
        int[] expectedOutputs = {
            7,
            2,
            3,
            0
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "circleOfNumbers("+
                inputs[i][0]+", "+
                inputs[i][1]+"): "+
                circleOfNumbers(inputs[i][0], inputs[i][1])+"\n"+
                "expected output: "+
                expectedOutputs[i]
            );
        }
    }
}