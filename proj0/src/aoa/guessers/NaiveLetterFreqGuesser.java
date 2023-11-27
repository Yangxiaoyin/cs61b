package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NaiveLetterFreqGuesser implements Guesser {
    private final List<String> words;

    public NaiveLetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    @Override
    /** Makes a guess which ignores the given pattern. */
    public char getGuess(String pattern, List<Character> guesses) {
        return getGuess(guesses);
    }

    /**
     * Returns a map from a given letter to its frequency across all words.
     * This task is similar to something you did in hw0b!
     */
    public Map<Character, Integer> getFrequencyMap() {
        Map<Character, Integer> output = new TreeMap<>();
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                char k = words.get(i).charAt(j);
                if (output.containsKey(k)) {
                    output.put(k, output.get(k) + 1);
                } else {
                    output.put(k, 1);
                }
            }
        }
        return output;
    }

    /**
     * Returns the most common letter in WORDS that has not yet been guessed
     * (and therefore isn't present in GUESSES).
     */
    public char getGuess(List<Character> guesses) {
        Map<Character, Integer> output = new TreeMap<>();
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                char k = words.get(i).charAt(j);
                if (output.containsKey(k)) {
                    output.put(k, output.get(k) + 1);
                } else {
                    output.put(k, 1);
                }
            }
        }
        for (int i = 0; i < guesses.size(); i++) {
            char c = guesses.get(i);
            if (output.containsKey(c)) {
                output.remove(c);
            }
        }
        int max = 0;
//
        Map<Character, Integer> MaxValueOutput = new TreeMap<>();
        for (Map.Entry<Character, Integer> entry : output.entrySet()) {
            if (max == entry.getValue()) {
                MaxValueOutput.put(entry.getKey(), entry.getValue());

            } else if (max < entry.getValue()) {
                MaxValueOutput.clear();
                MaxValueOutput.put(entry.getKey(), entry.getValue());
                max = entry.getValue();
            }
            System.out.println(entry.getKey() + "/" + entry.getValue());
        }
        if (MaxValueOutput.isEmpty())
            return '?';
        else {
            for (Map.Entry<Character, Integer> entry : MaxValueOutput.entrySet()) {
                return entry.getKey();
            }
        }

        return '?';

    }



    public static void main(String[] args) {
        NaiveLetterFreqGuesser nlfg = new NaiveLetterFreqGuesser("data/example.txt");
        System.out.println("list of words: " + nlfg.words);
        System.out.println("frequency map: " + nlfg.getFrequencyMap());

        List<Character> guesses = List.of('e', 'l');
        System.out.println("guess: " + nlfg.getGuess(guesses));
    }
}
