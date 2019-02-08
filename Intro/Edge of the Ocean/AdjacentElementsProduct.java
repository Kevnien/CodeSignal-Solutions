// Given an array of integers, find the pair of adjacent elements that has the largest product and return that product.
class AdjacentElementsProduct{
    int adjacentElementsProduct(int[] inputArray) {
        int largest = -1000000;
        for(int i=0; i<inputArray.length-1; i++){
            int product = inputArray[i]*inputArray[i+1];
            if(product > largest){
                largest = product;
            }
        }
        return largest;
    }    
}