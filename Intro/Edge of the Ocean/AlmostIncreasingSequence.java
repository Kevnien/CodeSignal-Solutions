// Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing sequence by removing no more than one element from the array.

// // Note: sequence a0, a1, ..., an is considered to be a strictly increasing if a0 < a1 < ... < an. Sequence containing only one element is also considered to be strictly increasing.

class AlmostIncreasingSequence{
    boolean almostIncreasingSequence(int[] sequence) {
        return checkSequence(sequence, false);
    }
    
    boolean checkSequence(int[] sequence, boolean foundABogey){
        boolean foundOneBogey = foundABogey;
        if(sequence.length==1){
            return true;
        }
        int[] array = new int[sequence.length-1];
        int index = 0;
        array[index++] = sequence[0];
        if(sequence[1]<=sequence[0]){
            if(foundOneBogey){
                return false;
            }
            array[0] = sequence[1];
            foundOneBogey = true;
        }else{
            if(sequence.length==2){
                return true;
            }
            array[index++] = sequence[1];
        }
        for(int i=2; i<sequence.length; i++){
            if(sequence[i] > array[index-1]){
                if(index == array.length){
                    return true;
                }
                array[index++] = sequence[i];
                continue;
            }
            if(foundOneBogey){
                return false;
            }else{
                foundOneBogey = true;
            }
            int[] array2 = new int[array.length];
            for(int j=0; j<index-1; j++){
                array2[j] = array[j];
            }
            array2[index-1] = sequence[i];
            for(int j=i+1; j<sequence.length; j++){
                array[index] = sequence[j];
                array2[index++] = sequence[j];
            }
            boolean checkOne = checkSequence(array, foundOneBogey);
            boolean checkTwo = checkSequence(array2, foundOneBogey);
            return checkOne || checkTwo;
        }
        return true;
    }
}