package string;

class FindTheDifference {
    static public char findTheDifference(String s, String t) {
        
        int [] freq = new int[26];
        
        int sLen=0;
        int tLen=0;
        
        while(sLen < s.length() && tLen < t.length())
        {
            ++freq[s.charAt(sLen++)-'a'];
            --freq[t.charAt(tLen++)-'a'];
        }
        
        while(tLen < t.length())
        {
            --freq[t.charAt(tLen++)-'a'];
        }
        
        
        for(int i=0;i<t.length();i++)
        {
            if(freq[t.charAt(i)-'a'] !=0)
                return t.charAt(i);
        }
        
        return 'a';
    }

    public static void main(String[] args) {
       String  s = "";
       String t = "e";
        System.out.println(findTheDifference(s,t));
    }
}