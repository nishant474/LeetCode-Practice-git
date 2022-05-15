public class Find_Numbers_with_Even_Number_of_Digits_1295 {
    public static void main(String[] args) {
        int arr[] = {22,1,444,5555};
        int count=0;
        for(int i : arr)
        {
            int count1=0;
            while(i!=0)
            {
                count1++;
                i/=10;
            }
            if(count1%2==0)
            {
                count++;
            }
        }
        System.out.println(count);
    }
}
