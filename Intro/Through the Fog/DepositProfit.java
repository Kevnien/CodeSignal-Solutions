// You have deposited a specific amount of money into your bank account. Each year your balance increases at the same growth rate. With the assumption that you don't make any additional deposits, find out how long it would take for your balance to pass a specific threshold.

class DepositProfit{
    public static int depositProfit(int deposit, int rate, int threshold){
        float money = (float)deposit;
        int count = 0;
        while(money < threshold){
            count++;
            money += (money*rate)/100;
        }
        return count;
    }

    public static void main(String[] args){
        int[][] inputs = {
            {100,20,170},
            {100,1,101},
            {1,100,64},
            {20,20,50},
            {50,25,100}
        };
        int[] expectedOutputs = {
            3,
            1,
            6,
            6,
            4
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "depositProfit("+
                inputs[i][0]+", "+
                inputs[i][1]+", "+
                inputs[i][2]+"): "+
                depositProfit(inputs[i][0], inputs[i][1], inputs[i][2])+"\n"+
                "expected output: "+
                expectedOutputs[i]
            );
        }
    }
}