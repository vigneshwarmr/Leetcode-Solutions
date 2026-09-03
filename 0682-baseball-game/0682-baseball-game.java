class Solution {
    public int calPoints(String[] operations) {
        
        List<Integer> scores = new ArrayList<>();

        for(String op:operations){

            if(op.equals("+")){
                int size =scores.size();
                scores.add(scores.get(size-1)+scores.get(size-2));
            }else if(op.equals("D")){
                scores.add(2*scores.get(scores.size()-1));
            }else if(op.equals("C")){
                scores.remove(scores.get(scores.size()-1));
            }else{
                scores.add(Integer.parseInt(op));
            }
        }

        int result =0;
        for(int num:scores){
            result+=num;
        }
        return result;
    }
}