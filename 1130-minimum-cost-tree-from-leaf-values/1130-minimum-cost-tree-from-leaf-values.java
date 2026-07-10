class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(Integer.MAX_VALUE);

        int cost =0;
        for(int num:arr){
            while(st.peek()<=num){
                int mid = st.pop();
                cost+=mid*Math.min(st.peek(),num);
            }
            st.push(num);
        }
    
    while(st.size()>2){
        cost+= st.pop()*st.peek();
    }
    return cost;
}
}