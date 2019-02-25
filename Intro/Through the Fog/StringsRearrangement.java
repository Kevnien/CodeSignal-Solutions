// Given an array of equal-length strings, you'd like to know if it's possible to rearrange the order of the elements in such a way that each consecutive pair of strings differ by exactly one character. Return true if it's possible, and false if not.

import java.util.Arrays;
class StringsRearrangement{
    public static boolean stringsRearrangement(String[] inputArray){
        String[][] possibleInputs = getPossibleInputs(inputArray);
        for(int j=0; j<possibleInputs.length; j++){
            boolean allGood = true;
            for(int i=0; i<inputArray.length-1; i++){
                if(!oneDifference(possibleInputs[j], i)){
                    allGood = false;
                    break;
                }
            }
            if(allGood){
                return true;
            }
        }
        return false;
    }

    public static String[][] getPossibleInputs(String[] inputArray){
        String[][] possibleInputs = new String[factorial(inputArray.length)][inputArray.length];
        int[] indices = new int[inputArray.length];
        for(int i=0; i<inputArray.length; i++){
            indices[i] = i;
        }
        int[] index = {0};
        TreeNode head = new TreeNode(0, null, null, inputArray.length);
        populateChildren(head, possibleInputs, inputArray, index);
        return possibleInputs;
    }
    
    public static void populateChildren(TreeNode parent, String[][] possibleInputs, String[] inputArray, int[] index){
        if(parent.children.length == 0){
            addToPossibleInputs(possibleInputs, getLineage(parent), inputArray, index);
            return;
        }
        if(parent.value == null){
            for(int i=0; i<parent.children.length; i++){
                parent.addChild(i);
            }
        }else{
            for(int i=0; i<inputArray.length; i++){
                // System.out.println("Seeing if we can add "+i+" to "+parent+"\t");
                if(inLineage(i, parent)){
                    continue;
                }
                parent.addChild(i);
            }
        }
        for(TreeNode child: parent.children){
            populateChildren(child, possibleInputs, inputArray, index);
        }
    }

    public static void addToPossibleInputs(String[][] possibleInputs, int[] lineage, String[] inputArray, int[] index){
        String[] addition = new String[inputArray.length];
        for(int i=0; i<addition.length; i++){
            addition[i] = inputArray[lineage[i]];
        }
        possibleInputs[index[0]++] = addition;
    }

    public static int[] getLineage(TreeNode parent){
        TreeNode node = parent;
        int[] lineage = new int[parent.level];
        int index = parent.level-1;
        while(node.value != null){
            lineage[index--] = node.value;
            node = node.parent;
        }
        return lineage;
    }

    public static boolean inLineage(int value, TreeNode parent){
        // System.out.print("\tinLineage("+value+", "+parent+")");
        TreeNode node = parent;
        while(node.value != null){
            // System.out.println(node);
            if(node.value == value){
                // System.out.print("\tFinished inLineage() with true\n");
                return true;
            }
            node = node.parent;
        }
        // System.out.print("\tFinished inLineage() with false\n");
        return false;
    }
    
    public static class TreeNode{
        public int level;
        public TreeNode parent;
        public TreeNode[] children;
        public Integer value;
        public int index;
        public TreeNode(int level, TreeNode parent, Integer value, int length){
            this.level = level;
            this.parent = parent;
            this.children = new TreeNode[length];
            this.value = value;
            this.index = 0;
            // System.out.print("creating TreeNode at address "+this+" , level "+this.level+", "+this.children.length+" children");
            if(value!=null){
                // System.out.println(" , value "+this.value+" , parent "+this.parent);
            }else{
                // System.out.println();
            }
        }
        public TreeNode addChild(int value){
            if(index == this.children.length){
                return null;
            }
            TreeNode child = new TreeNode(this.level+1, this, value, this.children.length-1);
            this.children[index++] = child;
            return child;
        }
    }
    public static int factorial(int num){
        int total = 1;
        for(int i=2; i<=num; i++){
            total *= i;
        }
        return total;
    }
    
    public static boolean oneDifference(String[] inputArray, int index){
        boolean aChange = false;
        for(int i=0; i<inputArray[index].length(); i++){
            if(inputArray[index].charAt(i) != inputArray[index+1].charAt(i)){
                if(!aChange){
                    aChange = true;
                }else{
                    aChange = false;
                    break;
                }
            }
        }
        return aChange;
    }

    public static void main(String[] args){
        String[][] inputs = {
            {"aa","ab"},
            {"aba", "bbb", "bab"},
            {"ab", "bb", "aa"},
            {"q", 
            "q"},
            {"zzzzab", 
            "zzzzbb", 
            "zzzzaa"},
            {"ab", 
            "ad", 
            "ef", 
            "eg"},
            {"abc", 
            "bef", 
            "bcc", 
            "bec", 
            "bbc", 
            "bdc"},
            {"abc", 
            "abx", 
            "axx", 
            "abc"},
            {"abc", 
            "abx", 
            "axx", 
            "abx", 
            "abc"},
            {"f",
            "g", 
            "a", 
            "h"},
            {"ff", 
            "gf", 
            "af", 
            "ar", 
            "hf"},
            {"a", 
            "b", 
            "c"},
            {"abc", "bef", "bcc", "bew", "zew", "zyw", "bec", "bbc", "bdc"}
        };
        boolean[] expectedOutputs = {
            true,
            false,
            true,
            false,
            true,
            false,
            true,
            false,
            true,
            true,
            true,
            true,
            true
        };
        int index = 0;
        for(String[] input:inputs){
            System.out.println(
                "stringsRearrangement("+
                Arrays.toString(input)+"): "+
                stringsRearrangement(input)+"\n"+
                "expected output: "+
                expectedOutputs[index++]
            );
        }
    }
}