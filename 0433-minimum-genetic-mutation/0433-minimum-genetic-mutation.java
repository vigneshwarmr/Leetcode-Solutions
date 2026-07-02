class Pair<K,V>{
    K key;
    V value;

    public Pair(K key,V value){
        this.key= key;
        this.value = value;
    }

    public K getkey (){
        return key;
    }

    public V getValue(){
        return value;
    }
}

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        
        Queue<Pair<String,Integer>> q = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList(bank));

        q.offer(new Pair<>(startGene,0));
        set.remove(startGene);

        char[]genes = {'A','C','G','T'};

        if(bank.length==0)return -1;
        if(!set.contains(endGene))return -1;

        while(!q.isEmpty()){
            int size = q.size();

            for(int j=0;j<size;j++){
                String word = q.peek().getkey();
                int steps = q.peek().getValue();
                q.poll();
                if(word.equals(endGene))return steps;

                for(int i=0;i<word.length();i++){
                    char[]arr= word.toCharArray();
                    char original = arr[i];

                    for(char ch :genes){
                        arr[i]=ch;
                        String newword = new String(arr);

                        if(set.contains(newword)){
                            set.remove(newword);
                            q.offer(new Pair<>(newword,steps+1));
                        }

                    }
                    arr[i]=original;
                }


            }
        }
        return -1;
    }
}