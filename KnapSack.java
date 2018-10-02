import java.util.Scanner;

/**
 * Created by Pranay on 11/20/2016.
 */
public class KnapSack {  
    public static void main(String[] args) {
        System.out.println(" enter the max weight !");
        Scanner sc=new Scanner(System.in);
        int max=sc.nextInt();
        System.out.println(" enter nos of object ");
        int t=sc.nextInt();
        System.out.println("and their weight after that its values");
        KnapNode arr[]=new KnapNode[t];
        for(int i=0; i<t;i++){
            arr[i]=new KnapNode(sc.nextInt(),sc.nextInt());
        }

        int[]dp=new int[max+1];
        System.out.println(cal(dp,arr,max,0));
    }
    public static int cal(int[] dp,KnapNode[]arr,int w,int k){
        int as=0;
        if(dp[w]==0) {
            if (w > 0 && k < arr.length) {
                if (w >= arr[k].weight)
                    as = Math.max(cal(dp, arr, w, k + 1), arr[k].value + cal(dp, arr, w - arr[k].weight, k + 1));
                else
                    as = cal(dp, arr, w, k + 1);
            }
            dp[w]=as;
        }
        return dp[w];
    }
}
class KnapNode{
    int value;
    int weight;

    public KnapNode(int weight, int value) {
        this.value = value;
        this.weight = weight;
    }
}
