// Two arrays are called similar if one can be obtained from another by swapping at most one pair of elements in one of the arrays.

// Given two arrays a and b, check whether they are similar.
class AreSimilar{
    boolean areSimilar(int[] a, int[] b) {
        if(Arrays.equals(a, b)){
            return true;
        }
        boolean foundOne = false;
        boolean switchable = false;
        int[] differences = new int[2];
        for(int i=0; i<a.length; i++){
            if(a[i] != b[i]){
                if(!foundOne){
                    foundOne = true;
                    differences[0] = a[i];
                    differences[1] = b[i];
                }else{
                    if(switchable){
                        return false;
                    }
                    if(a[i]==differences[1] && b[i]==differences[0]){
                        switchable = true;
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    
}