class Solution {
    public int calPoints(String[] operations) {
        
        List<Integer>scores = new ArrayList<>();

        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("D")){
                scores.add(2* scores.get(scores.size()-1));
            }else if(operations[i].equals("C")){
                scores.remove(scores.size()-1);
            }else if(operations[i].equals("+")){
                int size = scores.size();
                scores.add(scores.get(size-1)+scores.get(size-2));
            }else{
                scores.add(Integer.parseInt(operations[i]));
            }
        }
        
        int total =0;
        for(int score:scores){
            total+=score;
        }
        return total;
    }
}