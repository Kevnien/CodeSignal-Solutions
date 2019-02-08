/*A little boy is studying arithmetics. He has just learned how to add two integers, written one below another, column by column. But he always forgets about the important part - carrying.*/
 
 Given two integers, find the result which the little boy will get.

public class AdditionWithoutCarrying
{
    public static void main(String[] args)
    {
        System.out.println(additionWithoutCarrying(456,1734));
    }

    public static int additionWithoutCarrying(int param1, int param2)
    {
        int answer = 0;
        for(int place=1;place<=10000;place*=10)
        {
            System.out.println("place:"+place);
            int top = (param1/place)%(10);
            System.out.println("top:"+top);
            int bot = (param2/place)%(10);
            System.out.println("bot:"+bot);
            System.out.println("add:"+(((top+bot)%10)*place));
            answer += ((top+bot)%10)*place;
        }
        return answer;
    }
}
