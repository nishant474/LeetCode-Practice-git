import java.util.Arrays;

public class Concatenation_of_Array_1929 {
    public static void main(String[] args) {
        int a[] = {1,2,3};
        System.out.println(Arrays.toString(Concatenation(a)));
    }

    public static int[] Concatenation(int a[])
    {
        int len = a.length;
        int a1[] = new int [2*len];
        for(int i=0;i<len;i++)
        {
            a1[i]=a[i];
            a1[i+len] = a[i];
        }
        return a1;
    }
}
