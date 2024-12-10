public class MergeSort {

    public static void mergeSort(Comparable[] list, int start, int end) {
        if (start == end) {
            return;
        } else if (start == end-1) {
            if (list[start].compareTo(list[end]) <= 0) {
    
                return;
            } else { // swap
                Comparable temp = list[start];
                list[start] = list[end];
                list[end] = temp;
            }
        }
    
        int mid = (end-start)/2;
        mergeSort(list, start, start + mid);
        mergeSort(list, start + mid + 1, end);
        merge(list, start, start + mid, end);
    
    }
    
}

