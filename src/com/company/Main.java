package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    private static File myFile = new File("libraryBooks.txt");
    private static ArrayList<String> books = new ArrayList<>();
    private static String authList = new String();
    private static ArrayList<String> bookNum = new ArrayList<>();
    private static String status = new String();


    public static void main(String[] args) throws Exception {
        login.main();

        int a = 0;
        while (a == 0) {
            String checkAdd = getInput("do you want to check the list or overwrite it?");
            if (checkAdd.equals("overwrite")) {
                int howManyBooks = Integer.parseInt(getInput("How many books to add?"));
                int i;
                for (i = 0; i < howManyBooks; i++) {


                    books.add(getBookDetails());
                    try {
                        writeFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(books);

                }
                deleteBook();
                try {
                    writeFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                printLibrary();
                String cont = getInput("do you wnt to continue?");
                if (!cont.equals("yes")) {
                    a++;
                }
            } else {
                printLibrary();
                String cont = getInput("do you wnt to continue?");
                if (!cont.equals("yes")) {
                    a++;
                }
            }
        }
    }

    public static String getBookDetails() {
        String bookTitle = getInput("enter book title");
        String ISBN = getInput("enter book ISBN");
        String author = getInput("enter book author");
        String genre = getInput("enter book genre");
        bookNum.add(bookTitle);
        return (bookTitle + "%" + ISBN + "%" + author + "%" + genre);
    }

    public static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void writeFile() throws IOException {
        try {
            FileWriter myWriter = new FileWriter(myFile.getName(), false);
            myWriter.write(String.valueOf(books));
            myWriter.close();
            System.out.println("added to library file");


        } catch (IOException e) {
            System.out.println("did not print to library file");
            e.printStackTrace();
        }
    }

    public static void deleteBook() {
        String delete = getInput("do you want to delete a book");
        if (delete.equals("yes")) {
            String deleteName = getInput("what is the name of the book you want to delete");
            int deleteIndex = bookNum.indexOf(deleteName);
            books.remove(deleteIndex);


        }
    }

    public static void printLibrary() {
        try {
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}

