class VariableName{
    public static boolean variableName(String name){
        char first = name.charAt(0);
        if(first>='0' && first<='9'){
            return false;
        }
        for(int i=0; i<name.length(); i++){
            char current = name.charAt(i);
            if(
                (current>='a' && current<='z')
                || (current>='A' && current<='Z')
                || (current>='0' && current<='9')
                || current == '_'
            ){
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        String[] inputs = {
            "var_1__Int",
            "qq-q",
            "2w2",
            " variable",
            "va[riable0",
            "variable0",
            "a",
            "_Aas_23",
            "a a_2",
            "0ss"
        };
        boolean[] expectedOutputs = {
            true,
            false,
            false,
            false,
            false,
            true,
            true,
            true,
            false,
            false
        };
        for(int i=0; i<inputs.length; i++){
            System.out.println(
                "variableName("+
                inputs[i]+
                "): "+variableName(inputs[i])+
                "\nexpected output: "+
                expectedOutputs[i]
            );
        }
    }
}