// Given an integer product, find the smallest positive (i.e. greater than 0) integer the product of whose digits is equal to product. If there is no such integer, return -1 instead.

class DigitsProduct{
    public static int digitsProduct(int product){
        String answer = "";
        if(product == 0){
            return 10;
        }
        if(product < 10){
            return product;
        }
        for(int i=9; i>1; i--){
            while(product%i == 0){
                answer = i+answer;
                product /= i;
            }
        }
        if(product != 1){
            return -1;
        }
        return Integer.valueOf(answer);
    }

    public static void main(String[] args){
        int[][] inputOutputs = {
            {12,26},
            {19,-1},
            {450,2559},
            {0,10},
            {13,-1},
            {1,1},
            {243,399},
            {576,889},
            {360,589},
            {10,25},
            {11,-1},
            {33,-1}
        };
        for(int[] pair:inputOutputs){
            int answer = digitsProduct(pair[0]);
            System.out.print(
                "differentSquares("+pair[0]+"):\n"+
                answer+"\n"+
                pair[1]+" <-- expected output"
            );
            String end = "";
            if(answer == pair[1]){
                end = " PASSED";
            }else{
                end = " FAILED";
            }
            System.out.println(end);
        }
    }
}