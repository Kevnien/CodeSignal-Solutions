// Check if the given string is a correct time representation of the 24-hour clock.

class ValidTime{
    public static boolean validTime(String time){
        String hhString = "" + time.charAt(0) + time.charAt(1);
        int hhInt = Integer.valueOf(hhString);
        if(hhInt>23){
            return false;
        }
        String mmString = "" + time.charAt(3) + time.charAt(4);
        int mmInt = Integer.valueOf(mmString);
        if(mmInt>59){
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        String[] inputs = {
            "13:58",
            "25:51",
            "02:76",
            "24:00",
            "02:61",
            "27:00",
            "19:66",
            "12:31",
            "25:73",
            "09:56",
            "03:29"
        };
        boolean[] expectedOutputs = {
            true,
            false,
            false,
            false,
            false,
            false,
            false,
            true,
            false,
            true,
            true
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "validTime("+
                inputs[i]+"):\n"+
                validTime(inputs[i])+"\n"+
                expectedOutputs[i]+
                " <-- expected output"
            );
        }
    }
}