public class CreateAnagram
{
    public static void main(String[] args)
    {
        String s = "AABAA";
        String t = "BBAAA";
        Anagram anagram = new Anagram(s, t);
        System.out.println("Need to replace " + anagram.createAnagram() + " letters.");
        s = "OVGHK";
        t = "RPGUC";
        anagram = new Anagram(s, t);
        System.out.println("s:"+s+"\nt:"+t+"\nNeed to replace "+anagram.createAnagram()+" letters.");
    }
}
