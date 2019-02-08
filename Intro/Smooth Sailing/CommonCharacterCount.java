// Given two strings, find the number of common characters between them.

class CommonCharacterCount{
    int commonCharacterCount(String s1, String s2) {
        Hashtable<Character, Integer> table = new Hashtable<Character, Integer>();
        for(int i=0; i<s1.length(); i++){
            Character current = s1.charAt(i);
            if(table.containsKey(current)){
                Integer integer = new Integer(table.get(current)+1);
                table.put(current, integer);
            }else{
                table.put(current, 1);
            }
        }
        int count = 0;
        for(int i=0; i<s2.length(); i++){
            Character current = s2.charAt(i);
            Integer value = table.get(current);
            if(value == null){
                continue;
            }
            if(value > 0){
                table.put(current, value-1);
                count++;
            }
        }
        return count;
    }
    
    
}