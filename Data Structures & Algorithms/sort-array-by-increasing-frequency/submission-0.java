class Solution {
    public int[] frequencySort(int[] nums) {
        
        TreeMap<Integer, Integer> map = new TreeMap<>((a,b)-> Integer.compare(b, a));

        for(int i=0; i<nums.length; i++){
             map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length+1];

        for(Map.Entry<Integer, Integer> entry :map.entrySet()){
           int idx = entry.getValue();
           if(bucket[idx] == null){
                bucket[idx] = new ArrayList<>();
           }
           bucket[idx].add(entry.getKey());
        }

        int[] ans = new int[nums.length];
        int c = 0;

        for(int j=1; j<bucket.length && c<ans.length; j++){
            if(bucket[j] != null){
                for(Integer vl:bucket[j]){
                    for(int k=1; k<=j; k++){
                        ans[c++] = vl;
                    }
                }     
            }
        }

        return ans;
    }
}