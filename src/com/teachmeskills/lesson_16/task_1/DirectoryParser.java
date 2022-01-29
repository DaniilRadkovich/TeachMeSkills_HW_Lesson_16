package com.teachmeskills.lesson_16.task_1;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class DirectoryParser {

    static Map<String, String> infoFromFiles = new HashMap<>();
    private int processedDocs = 0;
    private int validDocsNum = 0;
    private int inValidDocsNum = 0;

    public void workWithDirectory(String directoryPath, int numberOfDocsToRead) {
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {

            List<File> files = Arrays.stream(Objects.requireNonNull(directory.listFiles((dir, name) -> name.endsWith("txt")))).limit(numberOfDocsToRead).collect(Collectors.toList());

            if (files.size() == 0) {
                System.out.println("In this directory there is no documents!");
                return;
            }
            for (File file : files) {
                Document.fileParse(file);
            }
            setProcessedDocs(Objects.requireNonNull(directory.listFiles()).length);
            setValidDocsNum(infoFromFiles.size());
            setInValidDocsNum((Objects.requireNonNull(directory.listFiles())).length - (infoFromFiles.size()));
        }
    }

    @Override
    public String toString() {
        return "Info from docs: " +
                 infoFromFiles;
    }

    public int getProcessedDocs() {
        return processedDocs;
    }

    public void setProcessedDocs(int processedDocs) {
        this.processedDocs = processedDocs;
    }

    public int getValidDocsNum() {
        return validDocsNum;
    }

    public void setValidDocsNum(int validDocsNum) {
        this.validDocsNum = validDocsNum;
    }

    public int getInValidDocsNum() {
        return inValidDocsNum;
    }

    public void setInValidDocsNum(int inValidDocsNum) {
        this.inValidDocsNum = inValidDocsNum;
    }
}
