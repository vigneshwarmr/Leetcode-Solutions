class Solution {
    public String removeDuplicates(String s, int k) {
        
        char []chars = s.toCharArray();
        int[]count = new int[s.length()];
        int i=0;

        for(int j=0;j<s.length();j++,i++){
            chars[i]=chars[j];

            if(i>0 && chars[i]==chars[i-1]){
                count[i]=count[i-1]+1;
            }else{
                count[i]=1;
            }

            if(count[i]==k){
                i-=k;
            }
        }
        return new String(chars,0,i);
    }
}