public class QuickSort {
    public static void main(String[] args){
        int[] arr = {2, 1};
        quickSort(arr, 0, arr.length-1);
        for (int el: arr)
            System.out.print(el + " ");
    }
    public static void quickSort (int[] arr, int start, int end){

        if (start >= end) // 재귀 탈출 조건
            return;

        int pivot = arr[start]; //pivot: 정렬 기준이 되는 값
        int left = start+1, right = end;
        while (left <= right){ //arr = {2, 1}인 경우를 위해 등호 필요
            while (left <= end && arr[left] <= pivot)
                /* low <= end가 앞에 와야 arr[end+1] 접근으로 인한 오류를 막을 수 있음
                   pivot과 같은 값도 지나가야 모두 같은 수로 이루어진 배열도 무한 루프 도는 일 없이 정렬 가능*/
                left++;

            while (right > start && arr[right] >= pivot)
                right--;
            if (left < right){
                swap(arr, left, right);
            }
        }
        swap (arr, start, right); //arr[right] = pivot, 즉 high가 pivot의 index
        quickSort (arr, start, right -1);
        quickSort (arr, right + 1, end);
    }
    public static void swap (int[] arr, int idx1, int idx2){
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
