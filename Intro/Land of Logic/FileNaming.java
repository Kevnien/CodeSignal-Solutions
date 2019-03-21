// You are given an array of desired filenames in the order of their creation. Since two files cannot have equal names, the one which comes later will have an addition to its name in a form of (k), where k is the smallest positive integer such that the obtained name is not used yet.

// Return an array of names that will be given to the files.

import java.util.Arrays;
import java.util.HashMap;
class FileNaming{
    public static String[] fileNaming(String[] names){
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String[] answer = new String[names.length];
        for(int i=0; i<names.length; i++){
            Integer value = map.get(names[i]);
            if(value == null){
                map.put(names[i], 0);
                answer[i] = names[i];
            }else{
                // System.out.println("names["+i+"]: "+names[i]+"\tvalue: "+value);
                value++;
                String uniquedName = names[i]+"("+value+")";
                while(map.get(uniquedName)!=null){
                    value++;
                    map.put(names[i], value);
                    uniquedName = names[i]+"("+value+")";
                }
                map.put(uniquedName, 0);
                answer[i] = uniquedName;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        String[][][] inputOutputs = {
            {
                {"doc", "doc",      "image", "doc(1)",      "doc"},
                {"doc", "doc(1)",   "image", "doc(1)(1)",   "doc(2)"}
            },
            {
                {"a(1)", "a(6)", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a"},
                {"a(1)", "a(6)", "a", "a(2)", "a(3)", "a(4)", "a(5)", "a(7)", "a(8)", "a(9)", "a(10)", "a(11)"}
            },
            {
                {"dd", "dd(1)", "dd(2)", "dd", "dd(1)", "dd(1)(2)", "dd(1)(1)", "dd", "dd(1)"},
                {"dd", "dd(1)", "dd(2)", "dd(3)", "dd(1)(1)", "dd(1)(2)", "dd(1)(1)(1)", "dd(4)", "dd(1)(3)"}
            },
            {
                {"a", "b", "cd", "b ", "a(3)"},
                {"a", "b", "cd", "b ", "a(3)"}
            },
            {
                {"name", "name", "name(1)", "name(3)", "name(2)", "name(2)"},
                {"name", "name(1)", "name(1)(1)", "name(3)", "name(2)", "name(2)(1)"}
            },
            {
                {},
                {}
            }
        };
        for(String[][] pair:inputOutputs){
            String[] answer = fileNaming(pair[0]);
            System.out.print(
                "fileNaming("+Arrays.toString(pair[0])+"):\n"+
                Arrays.toString(answer)+"\n"+
                Arrays.toString(pair[1])+" <-- expected output"
            );
            String end = "";
            // if(compare(pair[1], answer)){
            //     end = " PASSED";
            // }else{
            //     end = " FAILED";
            // }
            System.out.println(end);
        }
    }

    public static boolean compare(String[] array1, String[] array2){
        if(array1.length != array2.length){
            System.out.println("lengths different");
            return false;
        }
        for(int i=0; i<array1.length; i++){
            if(array1[i] != array2[i]){
                // System.out.println("\n"+array1[i]+" and "+array2[i]+" different");
                return false;
            }
        }
        return true;
    }
}