class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        
        HashMap<String,List<String>>adj = new HashMap<>();

        HashMap<String,Integer> indegree= new HashMap<>();

        for(int i=0;i<recipes.length;i++){
            indegree.put(recipes[i],ingredients.get(i).size());
            for(String ingredient:ingredients.get(i)){
                adj.putIfAbsent(ingredient,new ArrayList<>());
                adj.get(ingredient).add(recipes[i]);
            }
        }


        Queue<String> q = new LinkedList<>();
        List<String> ans = new ArrayList<>();
        for(String supply : supplies){
    q.offer(supply);
}


        while(!q.isEmpty()){
            String item = q.poll();

            if(!adj.containsKey(item)) continue;

            for(String recipe:adj.get(item)){
                indegree.put(recipe,indegree.get(recipe)-1);

                if(indegree.get(recipe)==0){
                    ans.add(recipe);
                    q.offer(recipe);
                }
            }
        }
        return ans;

    }
}