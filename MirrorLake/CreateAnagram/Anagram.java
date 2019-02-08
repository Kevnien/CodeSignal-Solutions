public class Anagram
{
    public String s, t;

    public Anagram(String a, String b)
    {
        s = a;
        t = b;
    }

    public int createAnagram()
    {
        letterBlock[] letters = new letterBlock[26];
        addWords(letters, s, t);
        return computeNumberOfExchanges(letters);
    }

    public int computeNumberOfExchanges(letterBlock[] letters)
    {
        int sumOfDifferences = 0;
        for(int i=0; i<26; i++)
        {
            if(letters[i]!=null)
            {
                char c = (char) (i+65);
                //System.out.println("Current letter: " + c);
                //System.out.println("sCount: " + letters[i].sCount);
                //System.out.println("tCount: " + letters[i].tCount);
                int difference = letters[i].tCount - letters[i].sCount;
                if(difference < 0)
                {
                    difference *= -1;
                }
                sumOfDifferences += difference;
            }
        }
        return sumOfDifferences/2;
    }

    public void addWords(letterBlock[] letters, String s, String t)
    {
        for(int i=0; i<s.length(); i++)
        {
            letterBlock current = letters[Character.getNumericValue(s.charAt(i))-10];
            if(current==null)
            {
                //System.out.println("numeric val:"+Character.getNumericValue(s.charAt(i)));
                letters[Character.getNumericValue(s.charAt(i))-10] = new letterBlock();
            }
            letters[Character.getNumericValue(s.charAt(i))-10].sCount++;
        }
        for(int i=0; i<t.length(); i++)
        {
            letterBlock current = letters[Character.getNumericValue(t.charAt(i))-10];
            if(current==null)
            {
                letters[Character.getNumericValue(t.charAt(i))-10] = new letterBlock();
            }
            letters[Character.getNumericValue(t.charAt(i))-10].tCount++;
        }
    }

    public class letterBlock
    {
        public int sCount, tCount;

        public letterBlock()
        {
            sCount = 0;
            tCount = 0;
        }
        
    }
}
