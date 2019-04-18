// Miss X has only two combs in her possession, both of which are old and miss a tooth or two. She also has many purses of different length, in which she carries the combs. The only way they fit is horizontally and without overlapping. Given teeth' positions on both combs, find the minimum length of the purse she needs to take them with her.

// It is guaranteed that there is at least one tooth at each end of the comb.
// It is also guaranteed that the total length of two strings is smaller than 32.
// Note, that the combs can not be rotated/reversed.

class Combs{
    public static int combs(String comb1, String comb2){
        int least = comb1.length() + comb2.length();
        int oneIndex=1, twoIndex=1;
        int oneLength=-1, twoLength=-1;
        for(;;){
            oneLength = checkCombs(comb1, comb2, oneIndex);
            twoLength = checkCombs(comb2, comb1, twoIndex);
            if(oneLength != -1){
                if(twoLength == -1){
                    return oneLength;
                }
                if(twoLength >= oneLength){
                    return oneLength;
                }else{
                    return twoLength;
                }
            }
            if(twoLength != -1){
                return twoLength;
            }
            oneIndex++;
            twoIndex++;
            if(oneIndex == least){
                break;
            }
        }
        return least;
    }

    public static int checkCombs(String comb1, String comb2, int index){
        int length = index;
        for(int i=0; i<comb2.length(); i++){
            if(index < comb1.length()){
                if(comb1.charAt(index++)=='*' && comb2.charAt(i)=='*'){
                    return -1;
                }
            }
            length++;
        }
        while(length < comb1.length()){
            length++;
        }
        return length;
    }

    public static void main(String[] args){
        String comb1 = "*..*";
        String comb2 =   "*.*";
        System.out.println(combs(comb1, comb2));
        comb1 = "*...*";
        System.out.println(combs(comb1, comb2));
        comb1 = "*..*.*";
        comb2 = "*.***";
        System.out.println(combs(comb1, comb2));
    }
}