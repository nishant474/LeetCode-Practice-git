public class Palindrome_Number_9 {
    public static void main(String[] args) {
        int n=121;
        System.out.println(palindrome(n));
    }

    public static boolean palindrome(int n)
    {
        if (n<0) return false;
        int p=n;
        int y=0;
        while (n!=0) {
            y = y*10 + n%10;
            n/=10;
        }

        return p==y;
    }
}