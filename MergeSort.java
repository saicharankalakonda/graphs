public class MergeSort {

    public static int[] doLinearMerging(int arr1[], int arr2[]) {
        int len1 = arr1.length;
        int len2 = arr2.length;
        int first = 0;
        int second = 0;
        int index = 0;

        int resultArr[] = new int[len1 + len2];

        while (first < len1 && second < len2) {
            if (arr1[first] <= arr2[second]) {
                resultArr[index++] = arr1[first++];
            } else {
                resultArr[index++] = arr2[second++];
            }
        }

        while (first < len1) {
            resultArr[index++] = arr1[first++];
        }
        while (second < len2) {
            resultArr[index++] = arr2[second++];
        }

        return resultArr;
    }

    public static int[] doMergeSort(int arr[], int start, int end) {
        if (start >= end) {
            return new int[]{arr[start]};
        }

        int mid = (start + end) / 2;
        int[] firstPart = doMergeSort(arr, start, mid);
        int[] secondPart = doMergeSort(arr, mid + 1, end);

        return doLinearMerging(firstPart, secondPart);
    }

    public static void main(String args[]) {
        int arr[] = {8, 2, 1, 3, 57, 6};
        int res[] = doMergeSort(arr, 0, arr.length - 1);
        for (int a : res) {
            System.out.print(a + " ");
        }
    }
}
