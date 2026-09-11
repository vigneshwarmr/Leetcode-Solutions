class Solution {
    public int totalNumbers(int[] digits) {
        
        int []frequency = new int[10];
        int count=0;

        for(int digit:digits){
            frequency[digit]++;
        }

        for(int h=1;h<=9;h++){
            if(frequency[h]==0)continue;
            frequency[h]--;

            for(int t=0;t<=9;t++){
                if(frequency[t]==0)continue;
                frequency[t]--;

                for(int u=0;u<=9;u+=2){
                    if(frequency[u]>0)count++;
                }

                frequency[t]++;
            }

            frequency[h]++;
        }

        return count;
    }
}