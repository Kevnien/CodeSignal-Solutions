// You found two items in a treasure chest! The first item weighs weight1 and is worth value1, and the second item weighs weight2 and is worth value2. What is the total maximum value of the items you can take with you, assuming that your max weight capacity is maxW and you can't come back for the items later?

// Note that there are only two items and you can't bring more than one item of each type, i.e. you can't take two first items or two second items.

class KnapsackLight{
    public static int knapsackLight(int value1, int weight1, int value2, int weight2, int maxW){
        if(weight1+weight2<=maxW){
            return value1+value2;
        }else if(weight1<=maxW && weight2<=maxW){
            if(value1>value2){
                return value1;
            }else{
                return value2;
            }
        }else if(weight1<=maxW){
            return value1;
        }else if(weight2<=maxW){
            return value2;
        }else{
            return 0;
        }
    }

    public static void main(String[] args){
        int[][] inputs = {
            {10,5,6,4,8},
            {10,5,6,4,9},
            {5,3,7,4,6},
            {10,2,11,3,1},
            {15,2,20,3,2},
            {2,5,3,4,5},
            {4,3,3,4,4},
            {3,5,3,8,10}
        };
        int[] expectedOutputs = {
            10,
            16,
            7,
            0,
            15,
            3,
            4,
            3
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "knapsackLight("+
                inputs[i][0]+", "+
                inputs[i][1]+", "+
                inputs[i][2]+", "+
                inputs[i][3]+", "+
                inputs[i][4]+"):\n"+
                knapsackLight(inputs[i][0], inputs[i][1], inputs[i][2], inputs[i][3], inputs[i][4])+"\n"+
                expectedOutputs[i]+" <-- expected output"
            );
        }
    }
}