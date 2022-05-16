public class Maximum_Number_of_Words_Found_in_Sentences_2114 {
    public static void main(String[] args) {
        String Sentences[] = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(Counting(Sentences));
    }

    public static int Counting(String Sentences[])
    {
        int count=0;
        int ans=0;
        for (String s : Sentences) {
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)==' ')
                {
                    count++;
                }
            }
            ans = Math.max(count, ans);
            count=0;
        }
        return ans+1;
    }
}
