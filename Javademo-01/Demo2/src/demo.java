import java.util.*;

public class demo {

	public static void main(String[] args){
		/*jiOu(5);
		int max=getMaxValue(new int[] {1,2,3,4,5});
		int min =getMinValue(new int[] {1,2,3,4,5,-1});
		System.out.println(max);
		System.out.println(min);*/
		
		/*printArr(new int[] {1,2,3,4,5});*/
		/*changeArr(new int[] {1,2,3,4,5},0,2);*/
		
	}
	
	public static void swapNum(int a,int b) {
		a=a^b;
		b=a^b;
		a=a^b;
		System.out.println("交换后的值为a="+a+"；b的值为:b="+b);
	}
	
	public static void operationTest() {
		System.out.println(2<<3);
	}
	
	public static void jiOu(int  n) {
		if(n%2==0) {
			System.out.println("偶数");
		}else {
			System.out.println("奇数");
		}
	}
    public static int getMaxValue(int[] arr) {
    	int max=arr[0];
    	for(int i=1;i<arr.length;i++) {
    		if(max<arr[i]) max=arr[i];
    	}
    	return max;
    }
    
    public static int getMinValue(int[] arr) {
    	int min=arr[0];
    	for(int i=1;i<arr.length;i++) {
    		if(arr[i]<min) min=arr[i];
    	}
    	return min;
    }
    
    public static void printArr(int[] arr) {
    	if(arr.length>0) {
    	  System.out.print(arr[0]);
    	for(int i=1;i<arr.length;i++) {
    		System.out.print(","+arr[i]);
    	}
     }
    }
    public static void changeArr(int[] arr,int m,int n) {
    	int temp=0;
    	temp=arr[m];
    	arr[m]=arr[n];
    	arr[n]=temp;
    	for(int i=0;i<arr.length;i++) {
    		System.out.println(arr[i]);
    	}
    }
}
