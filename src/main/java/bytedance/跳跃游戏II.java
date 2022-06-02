package bytedance;

public class 跳跃游戏II {
    public int jump(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return 0;
        }

        // 能够到达的最远距离
        int k = 0;

        // 步数
        int step = 0;

        // 记录上一步step跳的最远距离

        int end = 0;

        /**
         比如第一步从 0 最远能够跳到 3, step = 1
         那么我们在遍历过程中发现在 1 2 3 中如果是 2 它的最远距离 k 能够跳到终点或终点后面，那么我们只需要 再加 1 步从 2 起跳就能到达终点
         因为我们是按照到 end 才进行步数 + 1，但是对于 2 位置来说，它的终点的 len - 1 之后的
         因此如果要提前返回的话，那么我们需要将 2 起跳的这一步加上，因此是 step + 1
         */
        for (int i = 0; i < length - 1; i++) {
            k = Math.max(i + nums[i], k);

            if (k >= length -1) {
                return step + 1;
            }
            /**
             我们什么时候需要步数 + 1？
             当到达上一步的最远距离的时候，那么意味着我们需要进行一次新的起跳，那么步数 + 1
             并且更新最远距离
             */
            if (end == i) {
                step++;
                end = k;
            }
        }
        return step;
    }
}
