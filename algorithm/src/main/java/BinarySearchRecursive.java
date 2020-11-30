public class BinarySearchRecursive {
    public int search(int[] arr, int target) {
        int mid = (arr.length - 1) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            if (mid <= 0) return -1;
            int index = mid - 1;
            int[] tmp = subArray(arr, 0, index);
            return search(tmp, target);
        } else {
            if (mid >= (arr.length - 1)) return -1;
            int index = mid + 1;
            int[] tmp = subArray(arr, index, arr.length - 1);
            int result = search(tmp, target);
            if (result < 0) return result;
            return result + mid + 1;
        }
    }

    private int[] subArray(int[] arr, int left, int right) {
        int len = right - left + 1;
        int[] tmp = new int[len];
        for (int i = left, m = 0; i <=  right; i++, m++) {
            tmp[m] = arr[i];
        }
        return tmp;
    }
}
