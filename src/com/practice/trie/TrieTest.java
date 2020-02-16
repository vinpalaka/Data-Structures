package com.practice.trie;


import com.practice.trie.Trie;
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
        Assert.assertFalse(trie.isPrefix("worki"));
        Assert.assertFalse(trie.isPrefix("ap"));
        Assert.assertFalse(trie.isPrefix("work"));
        Assert.assertFalse(trie.isPrefix("tim"));
        Assert.assertFalse(trie.isPrefix("workspaces"));
        Assert.assertTrue(trie.isPrefix("bon"));
    }
    @Test
    public void contains() {
        List<String> words = new ArrayList<>(Arrays.asList("work", "wait", "bone", "bait", "cat", "bat", "workspace"));
        Trie trie = new Trie(words);
        Assert.assertTrue(trie.contains("bat"));
        Assert.assertFalse(trie.contains("wor"));
        Assert.assertFalse(trie.contains("trem"));
        Assert.assertTrue(trie.contains("workspace"));
        Assert.assertFalse(trie.contains("boneyard"));
        Assert.assertFalse(trie.contains("space"));
    }

    @Test
    public void suggest() {
        List<String> words = new ArrayList<>(Arrays.asList("work", "wait", "bone", "bait", "cat", "bat", "workspace", "woke", "tomorrow"));
        Trie trie = new Trie(words);
        System.out.println(trie.getAutoComplete("wo"));
        System.out.println(trie.getAutoComplete("to"));
        System.out.println(trie.getAutoComplete("as"));

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