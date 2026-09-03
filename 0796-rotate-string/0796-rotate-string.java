class Solution {
    public boolean rotateString(String s, String goal) {
        
        if(s.length()!=goal.length())return false;

        String concat = s+s;

        if(concat.contains(goal))return true;
        else return false;
    }
}