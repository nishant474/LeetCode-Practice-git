import java.util.Arrays;

public class Build_Array_From_Permutation_1920 {
    public static void main(String[] args) {
        int [] num = {0,2,1,5,3,4};
        System.out.println(Arrays.toString(Permutation(num)));
    }

    public static int[] Permutation(int num[])
    {
        int n = num.length;
        for (int i = 0; i < n; i++) {
            num[i]= n*(num[num[i]]%n)+num[i];
        }
        for (int i = 0; i < n; i++) {
            num[i]/=n;
        }
        return num;
    }
}
