package logicproblems;

public class MyArray {


    public static void reverseArray(int[] arr){
        // two pointer
        int left = arr[0];
        int right =arr.length-1;
        while (left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
       for (int num : arr) System.out.print(num+" ");

    }



    public static void main(String[] args) {


        int[] arr = {10,20,30,40,10,12,15,60,45,78};

        int min = arr[0];
        int max = arr[0];
        for(int num : arr){
            if (num > max) max =num;
            if (num < min) min = num;
        }
        System.out.println("Max value in array "+ max+" min value in array ="+min);


        reverseArray(arr);



    }
}
