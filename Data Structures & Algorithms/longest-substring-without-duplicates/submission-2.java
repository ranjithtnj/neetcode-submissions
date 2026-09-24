class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left = 0;
        int right = 0;
        int ans = 0;
        HashSet<Character> set = new HashSet<Character>();
        int n = s.length();
        while(left<n && right<n){
            
            if(set.contains(s.charAt(right))){
                            while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }

            }
            set.add(s.charAt(right));            
            ans = Math.max(set.size(), ans);
            right++;
        }

        return ans;
    }
}
