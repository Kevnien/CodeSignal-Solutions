// Caring for a plant can be hard work, but since you tend to it regularly, you have a plant that grows consistently. Each day, its height increases by a fixed amount represented by the integer upSpeed. But due to lack of sunlight, the plant decreases in height every night, by an amount represented by downSpeed.

// Since you grew the plant from a seed, it started at height 0 initially. Given an integer desiredHeight, your task is to find how many days it'll take for the plant to reach this height.

class GrowingPlant{
    public static int growingPlant(int upSpeed, int downSpeed, int desiredHeight){
        int amountOfDays = 1;
        int currentHeight = upSpeed;
        while(currentHeight < desiredHeight){
            currentHeight -= downSpeed;
            currentHeight += upSpeed;
            amountOfDays++;
        }
        return amountOfDays;
    }

    public static void main(String[] args){
        int[][] inputs = {
            {100, 10, 910},
            {10,9,4},
            {5,2,7},
            {7,3,443},
            {6,5,10}
        };
        int[] expectedOutputs = {
            10,
            1,
            2,
            110,
            5
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "growingPlant("+
                inputs[i][0]+", "+
                inputs[i][1]+", "+
                inputs[i][2]+"):\n"+
                growingPlant(inputs[i][0], inputs[i][1], inputs[i][2])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}