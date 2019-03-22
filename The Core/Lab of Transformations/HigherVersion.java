// Given two version strings composed of several non-negative decimal fields separated by periods ("."), both strings contain equal number of numeric fields. Return true if the first version is higher than the second version and false otherwise.

// The syntax follows the regular semver ordering rules:

// 1.0.5 < 1.1.0 < 1.1.5 < 1.1.10 < 1.2.0 < 1.2.2
// < 1.2.10 < 1.10.2 < 2.0.0 < 10.0.0
// There are no leading zeros in any of the numeric fields, i.e. you do not have to handle inputs like 100.020.003 (it would instead be given as 100.20.3).

class HigherVersion{
    public static boolean higherVersion(String ver1, String ver2){
        int length = ver1.length();
        int lengthTwo = ver2.length();
        int ver2Index = 0;
        for(int i=0; i<length; i++){
            String numOne = "";
            for(; i<length; i++){
                if(ver1.charAt(i)=='.'){
                    break;
                }
                numOne += ver1.charAt(i);
            }
            // System.out.println("numOne: "+numOne);
            String numTwo = "";
            for(; ver2Index<lengthTwo; ver2Index++){
                // System.out.println("ver2.charAt("+ver2Index+"): "+ver2.charAt(ver2Index));
                if(ver2.charAt(ver2Index)=='.'){
                    break;
                }
                numTwo += ver2.charAt(ver2Index);
            }
            // System.out.println("numTwo: "+numTwo);
            ver2Index++;
            if(Integer.valueOf(numOne) > Integer.valueOf(numTwo)){
                return true;
            }else if(Integer.valueOf(numOne) < Integer.valueOf(numTwo)){
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args){
        System.out.println(higherVersion("1.2.2", "1.2.0"));
        System.out.println(higherVersion("1.0.5", "1.1.0"));
        System.out.println(higherVersion("1.10.2", "1.2.10"));
    }
}