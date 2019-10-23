package com.yao.demo;

public class MergeSort implements ISort{


	public void sort(int[] valueList) {
		
		System.out.println("MergeSort");
		
		mergeSort(valueList, 0, valueList.length - 1);

        for (int num: valueList)
            System.out.print(num + " ");
 
	}
	
	private static void mergeSort(int[] arr, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
 
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
 
    private static void merge(int[] arr, int low, int mid, int high) {
        int leftIndex = low;
        int rightIndex = mid + 1;
        int[] tempArr = new int[high - low + 1];
        int tempIndex = 0;
 
        while (leftIndex <= mid && rightIndex <= high) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                tempArr[tempIndex] = arr[leftIndex];
                leftIndex++;
            }
            else {
                tempArr[tempIndex] = arr[rightIndex];
                rightIndex++;
            }
            tempIndex++;
        }
        if (leftIndex > mid) {
            while (rightIndex <= high) {
                tempArr[tempIndex] = arr[rightIndex];
                rightIndex++;
                tempIndex++;
            }
        }
        else {
            while (leftIndex <= mid) {
                tempArr[tempIndex] = arr[leftIndex];
                leftIndex++;
                tempIndex++;
            }
        }
        leftIndex = low;
        for (int temp: tempArr) {
            arr[leftIndex] = temp;
            leftIndex++;
        }
    }
	

}
