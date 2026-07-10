class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        solve(0,ans,temp,nums);
        return ans;

    }

    public void solve(int index,List<List<Integer>> ans,List<Integer> temp,int []nums) {

        if(index==nums.length){
            ans.add(new ArrayList<>(temp));
            return ;
        }

        temp.add(nums[index]);
        solve(index+1,ans,temp,nums);
        temp.remove(temp.size()-1);
        solve(index+1,ans,temp,nums);
}
}