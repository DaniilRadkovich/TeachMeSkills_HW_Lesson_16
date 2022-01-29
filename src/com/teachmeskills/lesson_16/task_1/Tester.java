package com.teachmeskills.lesson_16.task_1;

import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the way to your directory: ");
        String directoryPath = sc.nextLine();
        System.out.println("Enter the number of documents to read:");
        int numberOfDocsToRead = sc.nextInt();
        sc.close();

        DirectoryParser directoryParser = new DirectoryParser();
        directoryParser.workWithDirectory(directoryPath, numberOfDocsToRead);

        System.out.println(directoryParser);
        System.out.println("Count of files in the directory: " + directoryParser.getProcessedDocs());
        System.out.println("Count of processed valid documents: " + directoryParser.getValidDocsNum());
        System.out.println("Count of invalid (or unprocessed) documents: " + directoryParser.getInValidDocsNum());
    }
}
