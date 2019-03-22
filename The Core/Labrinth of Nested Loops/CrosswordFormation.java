public class CrosswordFormation
{
    public static void main(String[] args)
    {
        String[] words = {"crossword","square","formation","something"};
        crosswordFormation(words);
    }
    
    public static int crosswordFormation(String[] words) {
        int answer = 0;
        //try every word as 1st
        for(int i=0; i<4; i++)
        {
            //with every other word as 2nd
            for(int j=0; j<3; j++)
            {
                //try every letter of 1st word
                for(int k=0; k<words[i].length()-2; k++)
                {
                    //with every letter of 2nd word
                    for(int l=0; l<words[getOtherWord(i,j)].length()-2; l++)
                    {
                        //if a letter from 1st word is same as letter from 2nd word
                        if(words[i].charAt(k)==words[getOtherWord(i,j)].charAt(l))
                        {
                            //try every other unused word as 3rd word
                            for(int m=0; m<2; m++)
                            {
                                //with every unused letter of 1st word
                                for(int n=k+2; n<words[i].length(); n++)
                                {
                                    //with every letter of 3rd word
                                    for(int o=0; o<words[getOtherWord(getOtherWord(i,j),m)].length()-2; o++)
                                    {
                                        //if a letter from 3rd word is same as unused letter from 1st word
                                        if(words[i].charAt(n)==words[getOtherWord(getOtherWord(i,j),m)].charAt(o))
                                        {
                                            //try every letter of 4th word
                                            for(int p=0; p<words[getOtherWord(getOtherWord(getOtherWord(i,j),m),0)].length()-(n-k); p++)
                                            {
                                                //with every unused letter of 2nd word
                                                for(int q=l+2; q<words[getOtherWord(i,j)].length(); q++)
                                                {
                                                    //if letter from 4th word is same as letter from 2nd word
                                                    if(words[getOtherWord(i,j)].charAt(q)==words[getOtherWord(getOtherWord(getOtherWord(i,j),m),0)].charAt(p))
                                                    {
                                                        //try corresponding letter from 4th word with corresponding letter from 3rd word
                                                        System.out.println(getOtherWord(getOtherWord(i,j),m));
                                                        if(words[getOtherWord(getOtherWord(i,j),m)].charAt(o+(q-l))==words[getOtherWord(getOtherWord(getOtherWord(i,j),m),0)].charAt(p+(n-k)))
                                                        {
                                                            answer++;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
    
    public static int getOtherWord(int i, int j)
    {
        if(i+j>=3)
        {
            return i+j-3;
        }
        return i+j+1;
    }
}
