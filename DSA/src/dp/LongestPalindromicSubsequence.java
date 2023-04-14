package dp;

class LongestPalindromicSubsequence {
//     public int longestPalindromeSubseq(String s) {
//         int len=s.length();

//         int [][]dp=new int[len][len];

//         for(int [] arr: dp)
//             Arrays.fill(arr,-1);

//         return recur( s,len-1,new StringBuilder(s).reverse().toString(),len-1,dp);

//     }

//     static int recur(String s,int n, String d,int m,int [][]dp)
//     {
//         if(n <0 || m<0)
//             return 0;
//         if(dp[n][m]!=-1)
//             return dp[n][m];

//         if(s.charAt(n)==d.charAt(m))
//             return dp[n][m]= 1+recur(s,n-1,d,m-1,dp);
//         else
//             return  dp[n][m]=Math.max(recur(s,n-1,d,m,dp),recur(s,n,d,m-1,dp));

//     }

//      public int longestPalindromeSubseq(String s) {

//           int len=s.length();
//           int [][]dp=new int[len+1][len+1];

//          String d=new StringBuilder(s).reverse().toString();

//          for(int n=1;n<=len;n++)
//          {
//              for(int m=1;m<=len;m++)
//              {
//                   if(s.charAt(n-1)==d.charAt(m-1))
//                     dp[n][m]= 1+dp[n-1][m-1];
//                   else
//                     dp[n][m]=Math.max(dp[n-1][m],dp[n][m-1]);
//              }
//          }

//          return dp[len][len];
//      }

    public static int longestPalindromeSubseq(String s) {

        int len = s.length();
        //int [][]dp=new int[len+1][len+1];

        int[] prev = new int[len + 1];
        String d = new StringBuilder(s).reverse().toString();

        for (int n = 1; n <= len; n++) {
            int[] curr = new int[len + 1];
            for (int m = 1; m <= len; m++) {
                if (s.charAt(n - 1) == d.charAt(m - 1))
                    curr[m] = 1 + prev[m - 1];
                else
                    curr[m] = Math.max(prev[m], curr[m - 1]);
            }
            prev = curr;
        }

        return prev[len];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
}