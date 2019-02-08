public class ComfortableNumbers
{
    public static void main(String[] args)
    {
        comfortableNumbers(10,12);
    }
    
    public static int comfortableNumbers(int L, int R) {
        int count = 0;
        for(int i=L; i<=R; i++)
        {
            int comfortRange = s(i);
            System.out.println("i:"+i);
            for(int j=i-comfortRange; j<=i+comfortRange; j++)
            {
                if(j<=i || j>R)
                {
                    continue;
                }
                else
                {
                    count++;
                    System.out.println("("+i+","+j+"), ");
                }
            }
        }
        System.out.println("For L="+L+" and R="+R+", there are "+count+" comfortable pairs.");
        return count;
    }
    
    public static int s(int x)
    {
        String number = Integer.toString(x);
        int sum = 0;
        for(int i=0; i<number.length(); i++)
        {
            sum += Character.getNumericValue(number.charAt(i));
        }
        return sum;
    }
}
