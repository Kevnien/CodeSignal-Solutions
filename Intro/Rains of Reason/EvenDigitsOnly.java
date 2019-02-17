// Check if all digits of the given integer are even.

class EvenDigitsOnly{
    public static boolean evenDigitsOnly(int n){
        while(n>0){
            int r = n%10;
            if(r%2==1){
                return false;
            }
            n = n/10;
        }
        return true;
    }

    public static void main(String[] args){
        int[] inputs = {
            248622,
            642386,
            248842,
            1,
            8,
            2462487,
            468402800,
            2468428,
            5468428,
            7468428
        };
        boolean[] expectedOutputs = {
            true,
            false,
            true,
            false,
            true,
            false,
            true,
            true,
            false,
            false
        };
        for(int i=0; i<expectedOutputs.length; i++){
            System.out.println(
                "evenDigitsOnly("+
                inputs[i]+
                "): "+evenDigitsOnly(inputs[i])+
                "\nexpectedOutput: "+expectedOutputs[i]
            );
        }
    }
}