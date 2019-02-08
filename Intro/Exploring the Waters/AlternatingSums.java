// Several people are standing in a row and need to be divided into two teams. The first person goes into team 1, the second goes into team 2, the third goes into team 1 again, the fourth into team 2, and so on.

// You are given an array of positive integers - the weights of the people. Return an array of two integers, where the first element is the total weight of team 1, and the second element is the total weight of team 2 after the division is complete.
class AlternatingSums{
    int[] alternatingSums(int[] a) {
        boolean switchy = true;
        int[] totals = {0, 0};
        for(int i=0; i<a.length; i++){
            if(switchy){
                totals[0] += a[i];
                switchy = false;
            }else{
                totals[1] += a[i];
                switchy = true;
            }
        }
        return totals;
    }
    
    
}