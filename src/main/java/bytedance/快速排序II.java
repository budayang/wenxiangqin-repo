package bytedance;

public class 快速排序II {

    public void quickSort(int[] arr, int left, int right) {
        int poisition = 0;
        if (left < right) {
            poisition = partition(arr, left, right);
            quickSort(arr, left, poisition-1);
            quickSort(arr, poisition+1, right);
        }
    }


    public int partition(int[] arr, int left, int right) {

        int key = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {65, 58, 95, 10, 57, 62, 13, 106, 78, 23, 85};
        快速排序II c = new 快速排序II();
        c.quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
