// An IP address is a numerical label assigned to each device (e.g., computer, printer) participating in a computer network that uses the Internet Protocol for communication. There are two versions of the Internet protocol, and thus two versions of addresses. One of them is the IPv4 address.

// IPv4 addresses are represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255 inclusive, separated by dots, e.g., 172.16.254.1.

// Given a string, find out if it satisfies the IPv4 address naming rules.
import java.util.Arrays;

class IsIPv4Address{
    public static boolean isIPv4Address(String inputString) {
        Integer[] numbers = getNumbers(inputString);
        if(numbers == null){
            return false;
        }
        return true;
    }
    
    public static Integer[] getNumbers(String inputString){
        String[] numbersAsStrings = {"","","",""};
        int indexNumbersAsStrings = 0;
        for(int i=0; i<inputString.length(); i++){
            char current = inputString.charAt(i);
            if(current == '.'){
                if(indexNumbersAsStrings == 3){
                    return null;
                }
                indexNumbersAsStrings++;
                continue;
            }
            numbersAsStrings[indexNumbersAsStrings] += current;
        }
        Integer[] numbers = new Integer[4];
        for(int i=0; i<4; i++){
            if(numbersAsStrings[i] == ""){
                return null;
            }
            if(isNotNumber(numbersAsStrings[i])){
                return null;
            }
            numbers[i] = Integer.parseInt(numbersAsStrings[i]);
            if(numbers[i] > 255){
                return null;
            }
        }
        return numbers;
    }
    
    public static boolean isNotNumber(String string){
        if(string.length() > 3){
            return true;
        }
        char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};
        for(int i=0; i<string.length(); i++){
            boolean found = false;
            for(int j=0; j<10; j++){
                if(string.charAt(i) == numbers[j]){
                    found = true;
                }
            }
            if(!found){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        String[] tests = {
            "172.16.254.1",
            "172.316.254.1",
            ".254.255.0",
            "1.1.1.1a",
            "1",
            "0.254.255.0",
            "1.23.256.255.",
            "1.23.256..",
            "0..1.0",
            "1.1.1.1.1",
            "1.256.1.1",
            "a0.1.1.1",
            "0.1.1.256",
            "129380129831213981.255.255.255",
            "255.255.255.255abcdekjhf",
            "7283728"
        };
        boolean[] expecteds = {
            true,
            false,
            false,
            false,
            false,
            true,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false,
            false
        };
        for(int i=0; i<expecteds.length; i++){
            System.out.println(
                "isIPv4Address("
                +tests[i]
                +"): "
                +isIPv4Address(tests[i])
                +"\nExpected: "
                +expecteds[i]
            );
        }
    }
}