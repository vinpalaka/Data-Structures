package com.practice.file_structure;

import org.junit.Test;

import static org.junit.Assert.*;

public class FileSystemTest {

    @Test
    public void createPath() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.createPath("/leet", 1);
        fileSystem.createPath("/leet/code", 2);
        assertEquals(2, fileSystem.get("/leet/code"));
    }

    @Test
    public void get() {
    }
}