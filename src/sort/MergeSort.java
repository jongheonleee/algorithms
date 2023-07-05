package sort;

public class MergeSort {

    // given a and b must be sorted
    // it merge a and b in order
    private static int[] merge(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] merged = new int[a.length+b.length];

        // compare which one is smaller, and add it first
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                merged[k++] = a[i++];
            }
            else {
                merged[k++] = a[j++];
            }
        }

        // if a is not empty
        // in this case b is empty
        while (i < a.length) merged[k++] = a[i++];

        // otherwise b is mot empty
        // in this case a is empty
        while (j < b.length) merged[k++] = b[j++];

        return merged;

    }

    // divide and conquer
    public static int[] merge_sort(int[] a, int start, int end) {
        // if given array has one element, stop recursive
        if (start == end) {
            int[] tmp = {a[start]};
            return tmp;
        }
        // divide given array half
        int mid = (start+end)/2;
        // sort left of given array
        int[] left = merge_sort(a, start, mid);
        // sort right of given array
        int[] right = merge_sort(a, mid+1, end);

        // merge them
        return merge(left, right);
    }
}
