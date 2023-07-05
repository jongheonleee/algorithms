package search.binary_search;

// given array must be sorted

public class BinarySearch {
    final int NOT_FOUND = -1;

    // if the array has given target, return the index of target in a
    // otherwise return NOT_FOUND
    public int binary_search(int[] a, int target) {
        int left = 0, right = a.length-1;

        while (left <= right) {
            int mid = (left+right)/2;

            if (a[mid] == target) {
                return mid;
            }
            else if (a[mid] > target) {
                right = mid - 1;
            }
            else if (a[mid] < target) {
                left = mid + 1;
            }
        }

        return NOT_FOUND;
    }

    // furthermore i can assume that how many target in the array by using lower_bound and upper_bound
    // -> difference = upper_bound(target) - lower_bound(target)
    // (difference is the number of target in the array)

    // if the array has given target and it's duplicated
    // it returns very left target
    // for instance [a1, a2, a3, t1, t2, t3, a,4,,,]
    // it returns index of t1

    public int lower_bound(int[] a, int target) {
        int left = 0, right = a.length-1, pos = 0;

        while (left <= right) {
            int mid = (left + right)/2;

            if (a[mid] == target) {
                pos = mid;
                right = mid - 1;
            }
            else if (a[mid] > target) {
                right = mid - 1;
            }
            else if (a[mid] < target) {
                left = mid + 1;
            }
        }

        return a[pos] == target ? pos : NOT_FOUND;
    }

    // if the array has given target and it's duplicated
    // it returns very right target
    // for instance [a1, a2, a3, t1, t2, t3, a,4,,,]
    // it returns index of t3
    public int upper_bound(int[] a, int target) {
        int left = 0, right = a.length-1, pos = 0;

        while (left <= right) {
            int mid = (left + right)/2;

            if (a[mid] == target) {
                left = mid + 1;
                pos = left;
            }
            else if (a[mid] > target) {
                right = mid - 1;
            }
            else if (a[mid] < target) {
                left = mid + 1;
            }
        }

        return a[pos] == target ? pos : NOT_FOUND;
    }
}
