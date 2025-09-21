package logicproblems;

public class NewClass {

    public static void countchar(String str){
        int[] count = new int[256];

        for (int i = 0; i< str.length();i++){
            count[str.charAt(i)]++;
        }
        for (int i =0; i<count.length;i++){
            if (count[i]>0){
                System.out.println((char)i +" "+count[i]);
            }
        }
    }

    public static void main(String[] args) {

         String name = "shamdhan";

         countchar(name);

    }

}