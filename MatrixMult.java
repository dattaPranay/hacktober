import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Pranay on 11/20/2016.
 */
public class MatrixMult {

    public static void main(String[] args) {
        System.out.println(" no. of matrix :");
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        List<Integer> arr=new ArrayList<>();
        for(int i=0; i<t;i++){
            arr.add(sc.nextInt());
            arr.add(sc.nextInt());
        }
        int [][]dp=new int[t][t];
        for(int i=0; i<t;i++){
            for(int j=0; j<t;j++){
                dp[i][j]=-1;
                if (i==j) dp[i][i]=0;
            }
        }
        dp[0][t-1]=mult(dp,arr,0,t-1);
        System.out.println(dp[0][t-1]);
        backTrack(dp,arr,0,t-1);
    }
    public static void backTrack(int[][]dp,List<Integer>arr,int s ,int t){
        int temp;int k;
        if(s==t){}else {
            for (k = s + 1; k <= t; k++) {
                temp = dp[s][k - 1] + dp[k][t] + arr.get(s * 2) * arr.get(k * 2) * arr.get(t * 2 + 1);
                if (temp == dp[s][t]){
                   // System.out.println("asdh");
                    break;
                }
            }
            System.out.println(arr.get(s*2) + "X" + arr.get(k * 2) + " " +
                    arr.get(k * 2) + "X" +
                    arr.get(t * 2 + 1));
            backTrack(dp, arr, s, k-1);
            backTrack(dp, arr, k, t);
        }
    }

    public static int mult(int[][]dp,List<Integer>arr,int s,int t){
        if (s==t) return 0;
        int min=Integer.MAX_VALUE;int temp;
        for(int k=s+1; k<=t;k++){
            if(dp[s][k-1]==-1) dp[s][k-1]=mult(dp,arr,s,k-1);
            if(dp[k][t]==-1) dp[k][t]=mult(dp,arr,k,t);
            temp= dp[s][k-1] + dp[k][t] + arr.get(s*2)*arr.get(k*2)*arr.get(t*2+1);
            if(min>temp) min =temp;
        }

        return min;
    }

}
