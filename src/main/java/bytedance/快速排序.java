package bytedance;

import java.util.Random;

public class 快速排序 {


    private static final Random random = new Random();

    private static final int INSERTION_SORT_THRESHOLD = 7;

    public int[] sortArray(int[] nums) {
        int lenth = nums.length;
        quickSort(nums, 0, lenth-1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        // 插入排序
        if (right - left < INSERTION_SORT_THRESHOLD) {
            insertionSort(nums, left, right);
            return;
        }

        // 快速排序



    }

    public static void main(String[] args) {
        System.out.println(random.nextInt(10));
    }

    public int partition(int[] nums, int left, int right) {
        int randonIndex = random.nextInt(right - left + 1) + left;
        swap(nums, left, randonIndex);
        return randonIndex;
    }

    public void insertionSort(int[] nums, int left, int right) {

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int j = i;
            while (j > 0 && nums[j] > temp) {
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
    }

    public void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


}
