package com.practice.trees;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrieTest {

    public TrieTest() {

    }
    @Test
    public void isPrefix() {
        List<String> words = new ArrayList<>(Arrays.asList("work", "wait", "bone", "bait", "cat", "bat", "workspace"));
        Trie trie = new Trie(words);
        Assert.assertFalse(trie.isPrefix("wi"));
        Assert.assertTrue(trie.isPrefix("wor"));
        Assert.assertFalse(trie.isPrefix("ap"));
        Assert.assertFalse(trie.isPrefix("work"));



    }
    @Test
    public void contains() {
        List<String> words = new ArrayList<>(Arrays.asList("work", "wait", "bone", "bait", "cat", "bat", "workspace"));
        Trie trie = new Trie(words);
        Assert.assertTrue(trie.contains("bat"));
        Assert.assertFalse(trie.contains("wor"));
        Assert.assertFalse(trie.contains("trem"));
        Assert.assertTrue(trie.contains("workspace"));

    }

    @Test
    public void suggest() {
        List<String> words = new ArrayList<>(Arrays.asList("work", "wait", "bone", "bait", "cat", "bat", "workspace", "woke", "tomorrow"));
        Trie trie = new Trie(words);
        System.out.println(trie.getAutoComplete("wo"));
        System.out.println(trie.getAutoComplete("to"));

    }

    @Test
    public void isAnagram() {
        List<String> words = new ArrayList<>(Arrays.asList("cat", "dog", "tac", "god",
                "act", "gdo", "tat"));
        Trie trie = new Trie(words, true);
        trie.printAnagrams(words);


    }

    @Test
    public void consecutiveChars() {
        List<String> words = new ArrayList<>(Arrays.asList("work", "wait", "bone", "bait", "cat"
                , "bat", "workspace", "woke", "tomorrow"));

        Trie trie = new Trie(words, "");
        trie.checkIfStringHasWOrds("absbatevdwcatworkworkspacewokeasdfaewbonebat");




    }

}