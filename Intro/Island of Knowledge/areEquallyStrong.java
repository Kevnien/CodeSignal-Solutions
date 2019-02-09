class areEquallyStrong{
    public static boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        //I realize that I can reduce run time by combining comparisons into blocks
        // but I wanted to practice ternary operators and it still runs in O(c)
        int yourStronger = (yourLeft>yourRight) ? yourLeft : yourRight;
        int yourWeaker = (yourLeft>yourRight) ? yourRight : yourLeft;
        int friendsStronger = (friendsLeft>friendsRight) ? friendsLeft : friendsRight;
        int friendsWeaker = (friendsLeft>friendsRight) ? friendsRight : friendsLeft;
        if(yourStronger==friendsStronger && yourWeaker==friendsWeaker){
            return true;
        }
        return false;
    }
    
    public static void main(String[] args){
        System.out.println("areEquallyStrong(10, 15, 15, 10): "+areEquallyStrong(10, 15, 15, 10)+"\nExpected: true");
        System.out.println("areEquallyStrong(15, 10, 15, 9): "+areEquallyStrong(15, 10, 15, 9)+"\nExpected: false");
    }
}