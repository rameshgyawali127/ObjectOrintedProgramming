import java.util.*;
public class Palindrome
{
    public static void main(String[] args) {
        System.out.print("Enter the String: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if(ispalindrome(str)){
           System.out.println(" The given string is palindrome!");
        }
        else
            System.out.println("The given string is not palindrome!");
    }
    public static boolean ispalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left<right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            else{
                left ++;
                right --;
            }
        }
        return true;
    }
}
