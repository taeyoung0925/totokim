//실습예제 : 76,45,34,89,100,50,90,92  8개의 값을 1차원 배열로 초기화 하고 값에 합계와  평균 그리고 최대값과 최소값을 구하는 프로그램을 작성 하시요. 

package com.lec.java;

public class Day04_array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {76,45,34,89,100,50,90,92};
		int sum = 0;
		double avg = 0;
		int max = array[0]; //최대값을 배열의 첫번째값으로 초기화한다.
		int min = array[0]; //최소값을 배열의 첫번째값으로 초기화한다.

		
		for(int i = 1; i < array.length; i++) { //배열의 두번째값부터 읽기위해서 변수 i의 값을 1로 초기화한다. 
			sum = sum + array[i];
			if (array[i] > max) {
				max = array[i];
			} else if (array[i] < min) {
				min = array[i];
			}
		}
		avg = sum/array.length;
		System.out.printf("합계 : %d\n평균 : %.1f\n최대값 : %d\n최소값 : %d\n",sum,avg,max,min);
	
	
	}

}
