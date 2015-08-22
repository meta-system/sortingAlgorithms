package sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

public class Bubblesort {

	public static int[] toBeSorted = new int[20];

	public static void main(String[] args) {
		genNumbs();
		print();
		System.out.println();
		//bSort();
		//iSort();
		mSort(toBeSorted);
		System.out.println();
		System.out.println(Arrays.toString(toBeSorted));

	}

	public static void genNumbs(){
		Random rand = new Random();
		for(int i = 0; i < toBeSorted.length; i++){
			toBeSorted[i] = rand.nextInt(20) + 1;
		}

	}
	public static void mSort(int [] array){
		int N = array.length;


		if (N<=1){
			return;
		}
		int middle = N/2;
		int [] lArray = new int [middle];
		int [] rArray = new int [N-middle];

		System.arraycopy(array, 0, lArray, 0, middle);
		System.arraycopy(array, middle, rArray, 0, (N-middle));
		
		//System.out.println("main" + Arrays.toString(array));
		//System.out.println("left" + Arrays.toString(lArray));
		//System.out.println("right" + Arrays.toString(rArray));

		mSort(lArray);
		mSort(rArray);
		merge(array, lArray, rArray);

	}

	public static void merge(int[] array, int [] lArray, int [] rArray) {
		int lIndex = 0;
		int rIndex = 0;
		for (int i = 0; i < array.length; i++){
			if((lIndex < lArray.length)&&(rIndex < rArray.length)){
				if (lArray[lIndex] < rArray[rIndex]){
					array[i] = lArray[lIndex];
					lIndex++;
				}
				else {
					array[i] = rArray[rIndex];
					rIndex++;
				}
			}
			else {
				if (lIndex < lArray.length){
					array[i] = lArray[lIndex];
					lIndex++;
				}
				else {
					array[i] = rArray[rIndex];
					rIndex++;
					
				}
				
			}
			
			
		}
	}

	public static void bSort() {
		int temp = 0;
		boolean swap = false;
		do {
			swap = false;
			for (int i = 0; i < (toBeSorted.length-1); i++){
				if (toBeSorted[i]>toBeSorted[i+1]){
					temp = toBeSorted[i+1];
					toBeSorted[i+1]=toBeSorted[i];
					toBeSorted[i]= temp;
					swap = true;
				}
			}
		} while (swap == true);
	}

	public static int iSort(){
		int trys = 0;
		int temp = 0;
		for (int i = 0; i < toBeSorted.length; i++){
			trys++;
			temp = toBeSorted[i];
			for (int j = (i-1); 0 <= j; j--){
				trys++;
				if (toBeSorted[j] > temp){
					trys++;
					toBeSorted[j+1] = toBeSorted[j];
					if (j == 0){
						toBeSorted[j]=temp;
					}
				} else {
					toBeSorted[j+1] = temp;
					//j = 0;
					break;
				}

			}
		}
		return trys;
	}
	public static void print() {
		for (int i= 0; i < toBeSorted.length; i++){
			System.out.print(toBeSorted[i] + ", ");
		}
	}
}
