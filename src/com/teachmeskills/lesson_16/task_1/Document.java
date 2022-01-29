package com.teachmeskills.lesson_16.task_1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.teachmeskills.lesson_16.task_1.DirectoryParser.infoFromFiles;

public class Document {

    public static void fileParse(File file) {

        Pattern patternForDocs = Pattern.compile("\\d{4}[-][a-zа-я]{3}[-]\\d{4}[-][a-zа-я]{3}[-]\\d[a-zа-я]\\d[a-zа-я]", Pattern.CASE_INSENSITIVE);
        Pattern patternForPhoneNumber = Pattern.compile("(\\+*)[(]\\d{2}[)]\\d{7}([\\W\\n\\t]|$)");
        Pattern patternForEmail = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}", Pattern.CASE_INSENSITIVE);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcherForDocs = patternForDocs.matcher(line);
                Matcher matcherForPhoneNumber = patternForPhoneNumber.matcher(line);
                Matcher matcherForEmail = patternForEmail.matcher(line);

                write(file, matcherForDocs);
                write(file, matcherForPhoneNumber);
                write(file, matcherForEmail);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Unable to find your file!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(File file, Matcher matcher) {

        if (matcher.find()) {
            if (infoFromFiles.containsKey(String.valueOf(file))) {
                infoFromFiles.put(String.valueOf(file), infoFromFiles.get(String.valueOf(file)) + matcher.group() + "\n");
            } else
                infoFromFiles.put(String.valueOf(file), "\n" + matcher.group() + "\n");
        }
    }
}
