public class Richest_Customer_Wealth_1672 {
    public static void main(String[] args) {
        int [][] accounts = {{1,2,3},{3,2,1}};
        System.out.println(Richest(accounts));
    }

    public static int Richest(int[][] accounts)
    {
        int ans=0;

        for (int i = 0; i < accounts.length; i++) {
            int sum=0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j]; 
            }
            if(sum>ans)
            {
                ans=sum;
            }
        }
        return ans;
    }
}
