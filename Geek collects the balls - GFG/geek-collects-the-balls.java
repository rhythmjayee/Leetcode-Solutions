//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String arr[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);
            String arr1[] = in.readLine().trim().split("\\s+");
            String arr2[] = in.readLine().trim().split("\\s+");
            int a[] = new int[N];
            int b[] = new int[M];
            for(int i = 0;i < N;i++)
                a[i] = Integer.parseInt(arr1[i]);
            for(int i = 0;i < M;i++)
                b[i] = Integer.parseInt(arr2[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxBalls(N, M, a, b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxBalls(int n, int m, int a[], int b[])
    {
        int i = 0, j = 0, s1 = 0, s2 = 0, c1, c2;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                s1 += a[i++];
            } else if (a[i] > b[j]) {
                s2 += b[j++];
            } else {
                int x = a[i], oldS1 = s1, oldS2 = s2;
                for (c1 = 0; i < n && a[i] == x; ++c1, ++i) ;
                for (c2 = 0; j < m && b[j] == x; ++c2, ++j) ;

                s1 = oldS1 + ((c1 > 1 && c2 > 1) ? (c1 + c2 - 2) * x : c1 * x);
                s1 = Math.max(s1, oldS2 + (c1 + c2 - 1) * x);

                s2 = oldS2 + ((c1 > 1 && c2 > 1) ? (c1 + c2 - 2) * x : c2 * x);
                s2 = Math.max(s2, oldS1 + (c1 + c2 - 1) * x);
            }
        }
        for (; i < n; ++i) {
            s1 += a[i];
        }
        for (; j < m; ++j) {
            s2 += b[j];
        }
        return Math.max(s1, s2);
    }
}