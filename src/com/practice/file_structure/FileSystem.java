package com.practice.file_structure;

import java.util.HashMap;
import java.util.Map;

class FileSystem {

    Map<String, File> folder;
    class File {
        Map<String, File> childFolder;
        int value;
    }
    public FileSystem() {
        folder = new HashMap<String, File>();
    }

    public boolean createPath(String path, int value) {
        if(path == null || path.length() == 0)
            return false;
        String[] names = path.split("/");
        File file = null;
        if(names.length == 0)
            return false;

        Map<String, File> tempFolder = folder;
        for(int i = 1; i < names.length; i++) {
            if(i == names.length-1) {
                if(tempFolder.containsKey(names[i]))
                    return false;
                File newFile = new File();
                newFile.value = value;
                newFile.childFolder = new HashMap<>();
                tempFolder.put(names[i], newFile);
                break;
            }
            if(tempFolder.containsKey(names[i])) {
                file = tempFolder.get(names[i]);
                tempFolder = file.childFolder;
            } else {
                return false;
            }
        }
        return true;
    }

    public int get(String path) {
        File f = getFile(path);
        if(f != null) {
            return f.value;
        } else {
            return -1;
        }
    }

    private File getFile(String path) {
        String[] names = path.split("/");
        File file = null;
        if(names.length == 0)
            return file;
        Map<String, File> tempFolder = folder;
        for(int i = 1; i < names.length; i++) {
            if(tempFolder.containsKey(names[i])) {
                file = tempFolder.get(names[i]);
                tempFolder = file.childFolder;
            } else {
                return null;
            }
        }
        return file;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */