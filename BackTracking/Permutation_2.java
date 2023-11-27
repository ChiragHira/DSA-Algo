import java.util.ArrayList;
import java.util.List;

public class Permutation_2 {

    public static void permute (int [] nums, List<List<Integer>> result, List<Integer> temp){
        //Base Case
        if(temp.size()== nums.length){
                result.add(new ArrayList<>(temp));
                return;
        }

        else {
            for (int num : nums) {
                if (temp.contains(num)) continue;

                temp.add(num);
                permute(nums, result, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        int nums [] = {1,2,3,3};
        List<List<Integer>>result = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();

        permute(nums,result,temp);

        System.out.println(result);

    }
}
