package com.practice.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    class TrieNode {
        boolean isEnd;
        Map<Character, TrieNode> children = new HashMap<>();
        int endIndex;
        public TrieNode(boolean isEnd, int endIndex) {
            this.isEnd = isEnd;
            this.endIndex = endIndex;
        }
    }
    public int[][] indexPairs(String text, String[] words) {
        //Define A trie, gets it from list
        Map<Character, TrieNode> trie = getDictionary(words);
        List<int[]> pairs = new ArrayList<>();
        for(int i = 0; i < text.length(); i++) {
            Map<Character, TrieNode> trieDict = trie;
            addPairsToList(pairs, i, trieDict, text);
        }

        int[][] ans = new int[pairs.size()][2];
        for(int i = 0; i< pairs.size(); i++) {
            ans[i] = pairs.get(i);
        }
        //Figure out how to convert to array
        return ans;
    }

    public void addPairsToList(List<int[]> pairs, int startIndex, Map<Character, TrieNode> trie, String text) {
        for(int i = startIndex; i < text.length(); i++) {
            if(trie.containsKey(text.charAt(i))) {
                TrieNode curr = trie.get(text.charAt(i));
                if(curr.isEnd) {
                    pairs.add(new int[] {startIndex, i});
                }
                trie = curr.children;
            } else {
                break;
            }
        }
    }

    public Map<Character, TrieNode> getDictionary(String[] words) {
        Map<Character, TrieNode> trie = new HashMap<Character, TrieNode>();
        for(String word : words) {
            Map<Character, TrieNode> trieTemp = trie;
            for(int i = 0; i < word.length(); i++) {
                TrieNode t = null;
                if(trieTemp.containsKey(word.charAt(i))) {
                    t = trieTemp.get(word.charAt(i));
                } else {
                    t = new TrieNode(i == (word.length() -1), i);
                    trieTemp.put(word.charAt(i), t);
                }
                trieTemp = t.children;
            }
        }
        return trie;
    }
}
