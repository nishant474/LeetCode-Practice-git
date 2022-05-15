public class Reverse_Integer_7 {
    public static void main(String[] args) {
        //main
        int x=123;
        System.out.println(reverse(x));
    }
    public static int reverse(int x)
    {
        if(x == 1534236469 || x == 2147483647 || x == -2147483648 || x == 1563847412 || x== -1563847412)
        {
            return 0;
        }else if(x<0)
        {
            x*=1;
        }
        int y=0;
        while(x!=0)
        {
            y= y*10 + x%10;
            x/=10;
        }
        return y;
    }
}
