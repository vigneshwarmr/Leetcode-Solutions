class Solution {
    public int totalNumbers(int[] digits) {
        int[] frequency= new int[10];
        int count =0;

        for(int d:digits){
            frequency[d]++;
        }

        for(int i= 1;i<=9;i++){
            if(frequency[i]==0)continue;
            frequency[i]--;

            for(int t=0;t<=9;t++){
                if(frequency[t]==0)continue;
                frequency[t]--;

                for(int u=0;u<=9;u+=2){
                    if(frequency[u]>0)count++;
                }

                frequency[t]++;
            }

            frequency[i]++;
        }

        return count;
    }
}