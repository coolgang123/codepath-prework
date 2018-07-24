public class Solution {
    public int[] nextGreater(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] result  = new int[nums.length];
        
        if(nums.length < 1) {
            return result;
            
        }
        
        for(int i = 0; i < nums.length; i++){
            result[i] = -1;
        }
        
        int i = 0;
        while(i < nums.length){
            if(st.size() == 0 || nums[st.peek()] >= nums[i]){
                st.push(i);
                i++;
            }else{
                int lastTop = st.pop();
                result[lastTop] = nums[i];
            }
        }
        
       
        return result;
    }
}
