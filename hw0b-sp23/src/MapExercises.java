import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {

        Map<Character,Integer> output = new HashMap<>();
        for(int i=1;i<=26;i++)
        {
            char c= Character.toLowerCase((char)(i+16+'0'));
            output.put(c,i);
            System.out.println("print out " + i + " "+ c);
        }
        return output;

    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        Map<Integer,Integer> output = new HashMap<>();
        for(int i=0;i<nums.size();i++)
        {
            int k= nums.get(i);
            output.put(k,k*k);
            System.out.println("print out " + k + " "+ k*k);
        }
        return output;

    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        Map<String,Integer> output = new HashMap<>();
        for (String word : words) {
            if (output.containsKey(word))
            {
                output.put(word,output.get(word)+1);
            }
            else{
                output.put(word,1);
            }
        }
        return output;
    }
}
