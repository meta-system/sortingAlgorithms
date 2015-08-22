package sorting_algorithms;

import java.util.Random;

public class Bubblesort {

	public static int[] toBeSorted = new int[20];

	public static void main(String[] args) {
		genNumbs();
		print();
		System.out.println();
		bSort();
		//iSort();
		System.out.println();
		print();

	}

	public static void genNumbs(){
		Random rand = new Random();
		for(int i = 0; i < toBeSorted.length; i++){
			toBeSorted[i] = rand.nextInt(20) + 1;
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
		} while (swap = false);
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