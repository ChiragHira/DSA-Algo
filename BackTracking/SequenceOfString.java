import java.util.ArrayList;

public class SequenceOfString {
    public static void PrintSequence(int [] arr, int index, ArrayList<Integer>result){

        //base condition
        if (index==arr.length){
            if (result.size()>0){
                System.out.println(result);
            }
            return;
        }

        //Recursive Call

       //include
        PrintSequence(arr,index+1,result);
        result.add(arr[index]);

        //Not include
        PrintSequence(arr, index+1, result);
        result.remove(result.size()-1);

    }

    public static void main(String[] args) {

        int [] array = {1,2,3};
        SequenceOfString.PrintSequence(array,0,new ArrayList<Integer>());
    }
}




