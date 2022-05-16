public class Third_Maximum_Number_414 {
    public static void main(String[] args) {
        int num[] = {2,2,3,1};
        Integer max=null;
        Integer Second=null;
        Integer Third=null;

        System.out.println(maximum(num , max, Second, Third));
    }

    public static int maximum(int []num,Integer max,Integer Second,Integer Third)
    {
        for(Integer nums : num)
        {
            if(nums.equals(max) || nums.equals(Second) ||nums.equals(Third))
            {
                continue;
            }

            if(max==null || nums > max)
            {
                Third = Second;
                Second = max;
                max=nums;
            }else if(Second == null || nums > Second)
            {
                Third = Second;
                Second = nums;
            }else if(Third == null || nums > Third)
            {
                Third = nums;
            }
        }

        if(Third==null)
        {
            return max;
        }
        return Third;
    }
}
