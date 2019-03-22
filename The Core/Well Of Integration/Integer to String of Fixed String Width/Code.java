public class Code
{
    static String integerToStringOfFixedWidth(int number, int width)
    {
        Integer copy = (Integer) number;
        String stringNumber = copy.toString();
        int lengthNumber = stringNumber.length();
        if(lengthNumber>width)
        {
            return stringNumber.substring(lengthNumber-width,lengthNumber);
        }
        else
        {
            System.out.println("Do not need to remove digits.");
            stringNumber = addZeroes(stringNumber, width-lengthNumber);
            return stringNumber;
        }
    }

    static String addZeroes(String stringNumber, int amountToAdd)
    {
        for(int i=0; i<amountToAdd; i++)
        {
            stringNumber = "0" + stringNumber;
        }
        return stringNumber;
    }

    static int getLengthInt(int number)
    {
        int length = 1;
        int copy = (Integer) number;
        do
        {
            copy = copy/10;
            length++;
        }while(copy>10);
        return length;
    }


    public static void main(String[] args)
    {
        System.out.println("integerToStringOfFixedWidth(1234, 2):"+integerToStringOfFixedWidth(1234,2)+"\nShould be: 34");
        System.out.println("integerToStringOfFixedWidth(1234, 4):"+integerToStringOfFixedWidth(1234,4)+"\nShould be: 1234");
        System.out.println("integerToStringOfFixedWidth(1234, 5):"+integerToStringOfFixedWidth(1234,5)+"\nShould be: 01234");
    }
}
