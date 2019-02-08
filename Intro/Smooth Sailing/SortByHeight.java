// Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to rearrange the people by their heights in a non-descending order without moving the trees. People can be very tall!
class SortByHeight{
    int[] sortByHeight(int[] a) {
        int[] copy = Arrays.copyOf(a, a.length);
        Arrays.sort(copy);
        int index;
        for(index=0; index<copy.length; index++){
            if(copy[index] != -1){
                break;
            }
        }
        for(int i=0; i<a.length; i++){
            if(a[i] == -1){
                continue;
            }
            a[i] = copy[index++];
        }
        return a;
    }
    
    
}