public class Final_Value_of_Variable_After_Performing_Operations_2011 {
    public static void main(String[] args) {
        int x=0;
        String operation [] = {"--x","x++","x++"};
        System.out.println(Operation(operation,x));
    }

    public static int Operation(String Operation[], int x)
    {
        for (int i = 0; i < Operation.length; i++) {
            if(Operation[i].charAt(1)=='+')
            {
                x++;
            }else{
                x--;
            }
        }
        return x;
    }
}
