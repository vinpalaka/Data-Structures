package com.practice.trees;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This can be used for auto complete
 */
public class Trie {
    TrieNode root = new TrieNode();

    protected class TrieNode {
        Map<Character, TrieNode> map;
        private boolean isEnd = false;
        LinkedList<Integer> list; //Used for anagram
        String word;

        TrieNode() {
            map = new HashMap<>();
        }
        void addIndex(int index) {
            isEnd = true;
            if(list==null) {
                list = new LinkedList<>();
            }
            list.add(index);
        }
        public Map<Character, TrieNode> getChildren() {
            return map;
        }

    }

    public Trie(List<String> words) {
        TrieNode temp = root;
        for(String word : words) {
            insert(word, temp);
        }
    }

    public Trie(List<String> words, String w) {
        TrieNode temp = root;
        for(String word : words) {
            insertSaveWord(word, temp);
        }
    }

    public Trie(List<String> words, boolean sort) {
        if(sort) {
            TrieNode temp = root;
            for(int i = 0; i < words.size(); i++) {
                String sortedWord = Stream.of(words.get(i).split("")).sorted().collect(Collectors.joining());
                insertAnagram(sortedWord, temp, i);
            }
        }

    }

    private void insertAnagram(String sortedWord, TrieNode temp, int index) {
        for(int i = 0; i < sortedWord.length(); i++) {
            temp = temp.getChildren().computeIfAbsent(sortedWord.charAt(i), x->new TrieNode());
        }
        temp.addIndex(index);
    }

    private void insertSaveWord(String word, TrieNode temp) {
        for(int i = 0; i < word.length(); i++) {
            temp = temp.getChildren().computeIfAbsent(word.charAt(i), x->new TrieNode());
        }
        temp.isEnd = true;
        temp.word = word;
    }

    public void insert(String word, TrieNode temp) {
        for(int i = 0; i < word.length(); i++) {
            temp = temp.getChildren().computeIfAbsent(word.charAt(i), x->new TrieNode());
        }
        temp.isEnd = true;
    }

    public boolean isPrefix(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            Map<Character, TrieNode> children= temp.getChildren();
            TrieNode curr =  children.get(word.charAt(i));
            if(curr == null) {
                return false;
            }
            temp = curr;
        }
        return !temp.isEnd;
    }

    public void checkIfStringHasWOrds(String word) {
        TrieNode temp = root;
        List<TrieNode> nodes = new ArrayList<>();
        for(char c : word.toCharArray()) {
            printIfWord(c, nodes, temp);
        }
    }

    private void printIfWord(char c, List<TrieNode> list, TrieNode node) {
        TrieNode current = node.getChildren().get(c);
        int i = 0;
        while(i < list.size()) {
            TrieNode next = list.remove(i);
            next = next.getChildren().get(c);
            if(next != null) {
                if(next.isEnd)
                    System.out.println(next.word);
                list.add(next);
                i++;
            }

        }
        if(current != null)
            list.add(current);
    }

    public boolean contains(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            Map<Character, TrieNode> children= temp.getChildren();
            TrieNode curr =  children.get(word.charAt(i));
            if(curr == null) {
                return false;
            }
            temp = curr;
        }
        return temp.isEnd;
    }

    public String getAutoComplete(String word) {
        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            Map<Character, TrieNode> children= temp.getChildren();
            TrieNode curr =  children.get(word.charAt(i));
            if(curr == null) {
                return null;
            }
            temp = curr;
        }
        word = word + findRest(temp.getChildren());

        return word;
    }

    private String findRest(Map<Character,TrieNode> children) {
        if(children != null && children.size() > 0) {
            Iterator<Character> child = children.keySet().iterator();
            while(child.hasNext()) {
                Character curr = child.next();
                if(children.get(curr).isEnd) {
                    return "" + curr;
                } else {
                    return curr + findRest(children.get(curr).getChildren());
                }
            }

        }
        return null;
    }

    public void printAnagrams(List<String> words) {
        printAnagrams(root, words);

    }

    /**
     * Prints group of words based on anagram and partiions them.
     * @param root
     * @param words
     */
    private void printAnagrams(TrieNode root, List<String> words) {
        for(TrieNode node : root.getChildren().values()) {
            if(node.isEnd) {
                for(Integer i : node.list) {
                    System.out.println(words.get(i));
                }
                System.out.println("===================");
            } else {
                printAnagrams(node, words);
            }
        }
    }

}
