import java.util.*;
public class RationalNumber{
    private int num;
    private int den;
    public RationalNumber(int n,int d) {
        num = n;
        den = d;
        if (den == 0)
        {
            throw new RuntimeException("Denominator is zero!");

        }
    }
    public void dr() {
            int g = gcd(num, den);
            if (g == 1){
                System.out.println("NO common divisor");
            }
            num = num/g;
            den = den/g;
        }
    private int gcd(int m, int n)
    {
        while(m % n == 0)
        {
            int q = m % n;
            m =n;
            n = q;
        }
        return n;
    }
    public String toString()
    {
        return num + "/ "+ den ;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the Numerator value:");
        int num = sc.nextInt();
        System.out.print("Enter the value of Denominator:");
        int den =sc.nextInt();
        RationalNumber r = new RationalNumber(num, den);
        r.dr();
        System.out.println("The rational number of given number is : " + r.toString());
    }
}
