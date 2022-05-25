package bytedance;

public class 插入排序 {

    public static void main(String[] args) {
        int[] nums = {6, 8, 2, 1, 7, 3};
        nums = insertionSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static int[] insertionSort(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int temp = nums[i];
            while (j > 0 && nums[j-1] > temp) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }

}
