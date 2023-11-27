import java.util.ArrayList;
import java.util.List;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        int sum=0;
        for (int i=0;i<L.size();i++)
            sum += L.get(i);
        System.out.println("the sum is "+ sum);
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        List<Integer> output=new ArrayList<>();
        for (int k : L) {
            int mod = k % 2;
            if (mod == 0) {
                output.add(k);
                System.out.println("number to add" + k);
            }
        }
        return output;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        List<Integer> output=new ArrayList<>();
        for (int k : L1) {
            for (int j:L2){
                if(k==j){
                    output.add(k);
                    System.out.println("number to add " + k);
                    break;
                }
            }
        }
        return output;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        int count=0;
        for (int i = 0; i < words.size(); i++) {
            for (int j=0;j<words.get(i).length();j++)
            {
                if(c==words.get(i).charAt(j))
                    count +=1;
            }
        }
        return count;
    }
}
