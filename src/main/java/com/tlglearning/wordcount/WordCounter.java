package com.tlglearning.wordcount;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


// final makes the class so it can't be extended.

public final class WordCounter {

  // keys are strings and values are integers
  // final keyword promises a value during initialization or in a constructor, counts needs to be defined
  private final Map<String, Integer> counts;

  public WordCounter(String text) {
    String[] words = splitWords(text);
    counts = Collections.unmodifiableMap(countWords(words));
  }

  public Set<String> words() {
    return counts.keySet();
  }

  public int getCount(String word) {
    return counts.getOrDefault(word, 0);
  }

  public Map<String, Integer> getCounts() {
    return counts;
  }

  Map<String, Integer> countWords(String[] words) {
    Map<String, Integer> counts = new HashMap<>();
    for (String word : words) {
      // DONE Check if word is already present as a key in counts
      //  if it's not present, add it to counts with a value of 1
      //  otherwise, get the current value, add 1 to it, and update the map with the new value.
      if (!counts.containsKey(word)) {
        counts.put(word, 1);
      } else {
        int previousCount = counts.get(word);
        counts.put(word, previousCount + 1);
      }
    }
    return counts;
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
}