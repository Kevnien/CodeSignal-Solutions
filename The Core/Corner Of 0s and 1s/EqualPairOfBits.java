public class EqualPairOfBits
{
    public static void main(String[] args)
    {
        int n = 0;
        int m = 0;
        System.out.println("12345678901234567890123456789012");
        System.out.println(Integer.toBinaryString(~n));
        System.out.println(Integer.toBinaryString(~m));
        System.out.println(Integer.toBinaryString(~n&~m));
        System.out.println(Integer.lowestOneBit(~n&~m));
    }
}
