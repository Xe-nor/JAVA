public class SORTING {
    public class MergeSort{//o(nlogn)
        public static void conquer(int[] arr, int start, int mid, int end){
            int[] merged = new int[end-start+1];
            int index1 = start;//track 1st half of the original array
            int index2 = mid+1;//track 2nd half
            int x = 0;//track merged array
//compare both array and add into merged array
            while (index1 <= mid && index2<=end){
                if (arr[index1]<=arr[index2]){
                    merged[x]=arr[index1];
                    x++;
                    index1++;
                }else {
                    merged[x]=arr[index2];
                    x++;
                    index2++;
                }
            }
            //add remaining elements into merged array, items will be remaining in a single half since, comparision has already taken place above
            while (index1<=mid){
                merged[x]=arr[index1];
                x++;
                index1++;
            }
            while (index2<=end){
                merged[x]=arr[index2];
                x++;
                index2++;
            }
            // copy content from merged array into original array
            for (int i=0,j=start;i< merged.length;i++,j++){
                arr[j]=merged[i];
            }
        }
        public static void divide(int[] arr, int start, int end){
            if (start >= end){
                return;
            }
            int mid = start+ (end - start)/2;
            divide(arr,start,mid);
            divide(arr,mid+1 ,end);
            conquer(arr,start,mid,end);
        }
    }

    public class QuickSort{//o(n^2)

        public static int partition(int arr[],int low, int high){
            int pivot = arr[high];
            int i = low-1;//track empty spaces to swap
            for (int j = low;j<high;j++){
                if (arr[j]<pivot){
                    i++;//increase empty space
                    //swap
                    int temp = arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;

                }
            }
            i++;//space for pivot
            //swap for pivot
            int temp = arr[i];
            arr[i]=arr[high];
            arr[high]=temp;
            return i;
        }
        public static void quiksort(int arr[],int low, int high){
            if(low < high){
               int pivot = partition(arr,low,high);
               quiksort(arr,low,pivot-1);
               quiksort(arr,pivot+1,high);
            }
        }

    }

    public class BubbleSort{//o(n^2)
        public static void sort(int arr[],int n){
            for (int i = 0;i<n;i++){
                for (int j = 0 ;j<n-i;j++){
                    if (arr[j]>arr[j+1]){
                        int temp = arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp;
                    }
                }

            }
        }
    }

    public class SelectionSort{//o(n^2)
        public static void sort(int arr[],int n){
            for (int i=0;i<n;i++){
                int smallest = i;
                for (int j=i+1;j<n+1;j++){
                    if (arr[smallest]>arr[j]){
                        smallest=j;
                    }
                }
                int temp = arr[smallest];
                arr[smallest]=arr[i];
                arr[i]=temp;
            }
        }
    }

    public class InsertionSort{
        public static void  sort(int arr[],int n){
            for(int i=1;i<n;i++){
                int current = arr[i];
                int j = i-1;
                while (j>=0 && current<arr[j]){
                    arr[j+1]=arr[j];
                    j--;
                }
                arr[j+1]=current;

            }
        }
    }

    public static void main(String[] args) {
        int arr[]={1,3,2,6,5,4};
        int n = arr.length;
//        MergeSort.divide(arr,0,n-1);
//        QuickSort.quiksort(arr,0,n-1);
//        BubbleSort.sort(arr,n-1);
//        SelectionSort.sort(arr,n-1);
        InsertionSort.sort(arr,n-1);
        for(int i = 0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}
