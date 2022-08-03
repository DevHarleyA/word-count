package com.tlglearning.wordcount;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class WordCounter {

  private static final String[] BORING_WORDS = {"and", "of", "the", "in", "on", "i", "then", "than",
      "out", "to", "a", "that", "it", "he", "you", "was", "his", "is", "have", "had", "my", "we", "with",
      "for", "which", "as", "but", "not", "at"};
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
    Arrays
        .stream(words)
        .map(String::trim)
        .filter((s) -> !s.isEmpty())
        .filter((s) -> s.length() > 5) // try filtering by length to get rid of common modern-day words
        .filter((s) -> !Set.of(BORING_WORDS).contains(s)) // will filter out these common words
        // .filter(Predicate.not(String::isEmpty))
        .forEach((word) -> counts.put(word, 1 + counts.getOrDefault(word, 0))); // void return type, stream HAS TO finish
  }
}
