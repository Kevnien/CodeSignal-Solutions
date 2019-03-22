public class DifferentRightmostBit
{
    public static void main(String[] args)
    {
        int n = 1023;
        int m = 3071;
        System.out.println("12345678901234567890123456789012");
        System.out.println(Integer.toBinaryString(~n)+"\n"+Integer.toBinaryString(~m));
        System.out.println(Integer.toBinaryString(~n^~m));
        System.out.println(Integer.toBinaryString(~(n&m)));
    }
}
