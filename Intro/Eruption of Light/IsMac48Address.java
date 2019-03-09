// A media access control address (MAC address) is a unique identifier assigned to network interfaces for communications on the physical network segment.

// The standard (IEEE 802) format for printing MAC-48 addresses in human-friendly form is six groups of two hexadecimal digits (0 to 9 or A to F), separated by hyphens (e.g. 01-23-45-67-89-AB).

// Your task is to check by given string inputString whether it corresponds to MAC-48 address or not.

class IsMac48Address{
    public static boolean isMac48Address(String inputString){
        int length = inputString.length();
        char[] hexadecimal = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int i=0;
        for(i=0; i<length; i++){
            if(i>16){
                return false;
            }
            char currentCharacter = inputString.charAt(i);
            if((i+1)%3 == 0){
                if(currentCharacter != '-'){
                    return false;
                }else{
                    continue;
                }
            }
            boolean isNumeral = true;
            int characterIndex = currentCharacter-'0';
            if(characterIndex<0 || characterIndex>9){
                isNumeral = false;
            }else{
                isNumeral = currentCharacter == hexadecimal[characterIndex];
            }
            boolean isHexLetter = true;
            characterIndex = currentCharacter-'A'+10;
            if(characterIndex<10 || characterIndex>15){
                isHexLetter = false;
            }else{
                isHexLetter = currentCharacter == hexadecimal[characterIndex];
            }
            if(!isNumeral && !isHexLetter){
                return false;
            }
        }
        if(i<17){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        String[] inputs = {
            "00-1B-63-84-45-E6",
            "Z1-1B-63-84-45-E6",
            "not a MAC-48 address",
            "FF-FF-FF-FF-FF-FF",
            "00-00-00-00-00-00",
            "G0-00-00-00-00-00",
            "02-03-04-05-06-07-",
            "12-34-56-78-9A-BC",
            "FF-FF-AB-CD-EA-BC",
            "12-34-56-78-9A-BG"
        };
        boolean[] expectedOutputs = {
            true,
            false,
            false,
            true,
            true,
            false,
            false,
            true,
            true,
            false
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "isMac48Address("+
                inputs[i]+"):\n"+
                isMac48Address(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}