// Yesterday you found some shoes in the back of your closet. Each shoe is described by two values:

// type indicates if it's a left or a right shoe;
// size is the size of the shoe.
// Your task is to check whether it is possible to pair the shoes you found in such a way that each pair consists of a right and a left shoe of an equal size.

import java.util.HashMap;
class PairOfShoes{
    public static boolean pairOfShoes(int[][] shoes){
        if(shoes.length%2 == 1){
            return false;
        }
        int count = 0;
        HashMap<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
        for(int i=0; i<shoes.length; i++){
            Integer[] value = map.get(shoes[i][1]);
            if(value == null){
                Integer[] newValue = {shoes[i][0], 1};
                map.put(shoes[i][1], newValue);
                continue;
            }
            if(shoes[i][0] != value[0]){
                count += 2;
                value[1]--;
                if(value[1] == 0){
                    map.remove(shoes[i][1]);
                }else{
                    map.put(shoes[i][1], value);
                }
            }else{
                value[1]++;
                map.put(shoes[i][1], value);
            }
        }
        if(count == shoes.length){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int[][] shoes = {
            {0,21},
            {1,23},
            {1,21},
            {1,23}
        };
        System.out.println(pairOfShoes(shoes));
    }
}