import java.util.*;

public class QuickSort {
	
	void sort(int A[], int l, int h) {
		int j;
		if(l < h) {
			j = partition(A, l, h);
			sort(A, l, j);
			sort(A, j+1, h);
		}
	}
	
	void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
	
	int partition(int A[], int l, int h) {
		int pivot = A[l];
		int i = l, j = h;
		
		while(i < j) {
			
			do {
				i++;
			} while(A[i] <= pivot);
			
			do {
				j--;
			} while(A[j] > pivot);
			
			if(i < j)
				swap(A, i, j);
		}
		
		swap(A, l, j);
		
		return j;
	}
	
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i = 0; i < n-1; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements");
		int n = sc.nextInt();

		int arr[] = new int[n+1];
		for(int i=0;i<n;i++)
		{
			double p = Math.random() * 100;
			arr[i] = (int)p;
		}
		arr[n] = Integer.MAX_VALUE;
		System.out.println("Random array :-");
		printArray(arr);

		QuickSort qs = new QuickSort();

		long startTime = System.nanoTime();
			qs.sort(arr, 0, arr.length - 1);
		long endTime   = System.nanoTime();

		System.out.println("Sorted array :-");
		printArray(arr);
		

		double totalTime = (endTime - startTime)/1000000.0;

		System.out.println("Execution time = "+totalTime +" ms");

	}

}
