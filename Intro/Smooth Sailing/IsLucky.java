// Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the first half of the digits is equal to the sum of the second half.

// Given a ticket number n, determine if it's lucky or not.
class IsLucky{
    boolean isLucky(int n) {
        int sum1 = 0; 
        int sum2 = 0;
        Integer integerForm = new Integer(n);
        String stringForm = integerForm.toString();
        int halfwayPoint = stringForm.length()/2;
        for(int i=0; i<halfwayPoint; i++){
            Character character1 = new Character(stringForm.charAt(i));
            sum1 += Integer.valueOf(character1.toString());
            Character character2 = new Character(stringForm.charAt(i+halfwayPoint));
            sum2 += Integer.valueOf(character2.toString());
        }
        if(sum1 == sum2){
            return true;
        }else{
            return false;
        }
    }    
}