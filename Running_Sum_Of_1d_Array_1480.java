import java.util.Arrays;

public class Running_Sum_Of_1d_Array_1480 {
    public static void main(String[] args) {
        int num[] = {1,2,3,4};
        System.out.println(Arrays.toString(Sum(num)));    
    }

    public static int[] Sum(int num[])
    {
        int num1 []= new int[num.length];
        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j <=i; j++) {
                num1[i] += num[j];
            }
        }
        return num1;
    }
}
