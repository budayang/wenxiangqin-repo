package bytedance;

public class 跳跃游戏 {

    // [3,2,1,0,4]
    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (maxIndex >= i && i + nums[i] > maxIndex) {
                maxIndex = i + nums[i];
            }
        }
        return maxIndex >= nums.length - 1;
    }
}
