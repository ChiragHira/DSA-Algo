import java.util.ArrayList;
import java.util.List;

public class powerSet {

    public static void backtrack(List<List<Integer>>result, ArrayList<Integer>temp, int[]nums, int start){
        result.add(new ArrayList<>(temp));
        for (int i = start; i<nums.length;i++){
            temp.add(nums[i]);
            backtrack(result,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }

    public static List<List<Integer>> subSet( int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result,new ArrayList<Integer>(),nums,0);
        return result;
    }

    public static void main(String[] args) {

        int [] nums = {1,2,3};
        System.out.println(subSet(nums));
    }
}
