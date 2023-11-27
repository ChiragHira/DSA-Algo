import java.util.HashSet;

public class PermutationWithDuplicate {

    public static void permute(String str,int l,int r){
        //Base Case
        if (l==r){
            System.out.println(str);
            return;
        }

        HashSet<Character> set = new HashSet<>();
        for (int i = l; i < str.length(); i++){
            if(set.contains(str.charAt(i))) continue;

            set.add(str.charAt(i));
            str = PermutationOfString.swap(str,l,i);
            permute(str,l+1,r);
            str = PermutationOfString.swap(str,l,i);

        }

    }
    public static void main(String[] args) {
        String s = "ABA";
        permute(s,0,3);
    }
}
