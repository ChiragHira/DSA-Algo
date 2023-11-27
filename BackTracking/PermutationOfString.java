
public class PermutationOfString {

    public static String swap(String str,int x,int y){
        char[] arr = str.toCharArray();
        char temp = arr[x];
        arr[x]=arr[y];
        arr [y]=temp;
        return String.valueOf(arr) ;
    }
    public static void permute(String str,int l,int r){
        //Base Case
        if (l==r){
            System.out.println(str);
        }

        else {
            for (int i = l; i < str.length(); i++){
                str = swap(str,l,i);
                permute(str,l+1,r);
                str = swap(str,l,i);
            }
        }
    }

    public static void main(String[] args) {

        String s = "ABC";
        permute(s,0,2);

    }
}
