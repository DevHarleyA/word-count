package com.tlglearning.wordcount;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class WordCounter {

  // keys are strings and values are integers
  // final keyword promises a value during initialization or in a constructor, counts needs to be defined
  private final Map<String, Integer> counts = new HashMap<>();

  // defaults to 0. fields have default values, variables do not.
  private int totalWords;

  public Set<String> words() {
    return counts.keySet();
  }

  public int get(String word) {
    return counts.getOrDefault(word, 0);
  }

  public Map<String, Integer> getCounts() {
    return Collections.unmodifiableMap(counts);
  }

  public void add(String text) {
    String trimmedLine = text.trim();
    if (!trimmedLine.isEmpty()) {
      countWords(splitWords(trimmedLine));
    }
    //    String[] words = splitWords(text);
    //    countWords(words);
  }

  public int size() {
    return counts.size();
  }

  public int total() {
    return totalWords;
  }

  @Override
  public String toString() {
    return counts.toString();
  }

  String[] splitWords(String text) {
    return text
        // return a new string with lowercase letters
        .toLowerCase()
        // split words to put into array (create an array of words)
        .split("[\\W_]+");
  }

  void countWords(String[] words) {
    for (String word : words) {
      // DONE Check if word is already present as a key in counts
      //  if it's not present, add it to counts with a value of 1
      //  otherwise, get the current value, add 1 to it, and update the map with the new value.
      counts.put(word, get(word) + 1);
      totalWords++;
    }
  }
}
