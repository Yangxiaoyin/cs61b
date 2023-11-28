package aoa.guessers;

import aoa.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class PatternAwareLetterFreqGuesser implements Guesser {
    private final List<String> words;

    public PatternAwareLetterFreqGuesser(String dictionaryFile) {
        words = FileUtils.readWords(dictionaryFile);
    }

    @Override
    /** Returns the most common letter in the set of valid words based on the current
     *  PATTERN. */
    public char getGuess(String pattern, List<Character> guesses) {
        System.out.println("get Guess"+ pattern);
        List<String> matchedWords=keepOnlyWordsThatMatchPattern(words,pattern);
        Map<Character,Integer>FreqMap= getFreqMapThatMatchesPattern(matchedWords);
        // TODO: Fill in this method.
        for (int i = 0; i < guesses.size(); i++) {
            char c = guesses.get(i);
            if (FreqMap.containsKey(c)) {
                FreqMap.remove(c);
            }
        }
        int max = 0;
        Map<Character, Integer> MaxValueOutput = new TreeMap<>();
        for (Map.Entry<Character, Integer> entry : FreqMap.entrySet()) {
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

    public Map<Character,Integer>getFreqMapThatMatchesPattern(List<String> matchedWords){
        Map<Character, Integer> output = new TreeMap<>();
        for (int i = 0; i < matchedWords.size(); i++) {
            for (int j = 0; j < matchedWords.get(i).length(); j++) {
                char k = matchedWords.get(i).charAt(j);
                if (output.containsKey(k)) {
                    output.put(k, output.get(k) + 1);
                } else {
                    output.put(k, 1);
                }
            }
        }
        return output;
    }

    public List<String> keepOnlyWordsThatMatchPattern(List<String> words,String pattern){
        int patternLength=pattern.length();
        List<String> output= new ArrayList<String>();
        for (int i = 0; i < words.size(); i++) {
            boolean match=false;
            if(patternLength==words.get(i).length()){
                String compare=words.get(i);
                for(int j=0;j<pattern.length();j++){
                    if(pattern.charAt(j)!='-'){
                        if(pattern.charAt(j)!=compare.charAt(j)){
                            match=false;
                            System.out.println("un match words: "+ compare);
                            break;
                        }
                        else {
                            match=true;
                            System.out.println("match words: "+ compare);
                        }
                    }else match=true;
                }
            }
            if(match){
                output.add(words.get(i));
            }

        }
        return output;
    }

    public static void main(String[] args) {
        PatternAwareLetterFreqGuesser palfg = new PatternAwareLetterFreqGuesser("data/example.txt");
        System.out.println(palfg.getGuess("-e--", List.of('e')));
    }
}