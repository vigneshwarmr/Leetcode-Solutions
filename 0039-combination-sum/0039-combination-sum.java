class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>res=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();

        solve(res,temp,0,candidates,target);
        return res;
    }
    private void solve(List<List<Integer>>res,List<Integer>temp,int index,int[]candidates,int target){

        if(target==0){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(index==candidates.length || target< 0)return ;

        temp.add(candidates[index]);
        solve(res,temp,index,candidates,target-candidates[index]);
        temp.remove(temp.size()-1);
        solve(res,temp,index+1,candidates,target);
    }
}