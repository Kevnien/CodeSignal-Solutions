// Given an array of strings, return another array containing all of its longest strings.

class AllLongestStrings{
    String[] allLongestStrings(String[] inputArray) {
        int longest = inputArray[0].length();
        Node linkedList = new Node(inputArray[0]);
        int length = 1;
        for(int i=1; i<inputArray.length; i++){
            int stringLength = inputArray[i].length();
            if(stringLength < longest){
                continue;
            }
            if(stringLength > longest){
                longest = stringLength;
                linkedList = new Node(inputArray[i]);
                length = 1;
                continue;
            }
            linkedList.addToEnd(new Node(inputArray[i]));
            length++;
        }
        return linkedList.toArray(length);
    }
    
    public class Node{
        Node next;
        String value;
        
        public Node(String value){
            this.value = value;
            this.next = null;
        }
        
        public void setNext(Node node){
            next = node;
        }
        
        public void addToEnd(Node node){
            if(next == null){
                next = node;
            }else{
                Node current = next;
                while(current.next != null){
                    current = next;
                }
                current.next = node;
            }
        }
        
        public String[] toArray(int amount){
            String[] array = new String[amount];
            int index = 0;
            array[index++] = value;
            Node current = next;
            while(current != null){
                array[index++] = current.value;
                current = current.next;
            }
            return array;
        }
        
        public String getValue(){
            return value;
        }
    }
}