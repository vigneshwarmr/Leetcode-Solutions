class Pair<K,V>{
    K key;
    V value;

    public Pair(K key,V value){
        this.key = key;
        this.value = value;
    }

    public K getkey(){
        return key;
    }

    public V getvalue(){
        return value;
    }

}
    
class Solution {
    public int openLock(String[] deadends, String target) {
        
        Set<String> deadend = new HashSet<>(Arrays.asList(deadends));

        Queue<Pair<String,Integer>> q = new LinkedList<>();

        Set<String> visited= new HashSet<>();

        if(deadend.contains("0000"))return -1;
        q.offer(new Pair<>("0000",0));
        visited.add("0000");
        if(target.equals("0000"))return 0;

        while(!q.isEmpty()){
            String word = q.peek().getkey();
            int steps = q.peek().getvalue();
            q.poll();

            if(word.equals(target))return steps;

            for(int i=0;i<word.length();i++){
                char[]arr = word.toCharArray();
                char original = arr[i];

                arr[i]= (original=='9')?'0': (char)(original+1);

                String up = new String(arr);
                if(!deadend.contains(up) && !visited.contains(up)){
                    visited.add(up);
                    q.offer(new Pair<>(up,steps+1));
                }

                arr[i]=original;

                arr[i]= (original=='0')?'9': (char)(original-1);
                String down = new String(arr);
                if(!deadend.contains(down) && !visited.contains(down)){
                    visited.add(down);
                    q.offer(new Pair<>(down,steps+1));
                }
            }
        }
        return -1;
    }
}