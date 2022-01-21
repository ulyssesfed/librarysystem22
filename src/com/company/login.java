package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class login {
    private static File myPass = new File("passwords.txt");
    private static File myUser = new File("users.txt");
    private static ArrayList usernames = new ArrayList();
    private static ArrayList Passwords = new ArrayList();
    private static ArrayList PasswordsCheck = new ArrayList();
    private static ArrayList usernamesCheck = new ArrayList();
    private static String [] usersplit;
    private static String [] passsplit;


    public static void main() throws Exception {
        String registerQ = getInput("do you have an account?");
        if (registerQ.equals("no")) {

            register();
            writeUser();
            writePass();
            split();

        }
    }

    public static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static void register() {
        String username = getInput("enter a username");
        usernames.add(username);
        String pass = getInput("enter a password");
        Passwords.add(pass);
    }

    public static void writeUser() throws IOException {
        try {
            FileWriter myWriter = new FileWriter(myUser.getName(), true);
            myWriter.write(String.valueOf(usernames) + '%');
            myWriter.close();
            System.out.println("username stored");

        } catch (IOException e) {
            System.out.println("did not work");
            e.printStackTrace();
        }
    }

    public static void writePass() throws IOException {
        try {
            FileWriter myWriter = new FileWriter(myPass.getName(), true);
            myWriter.write(String.valueOf(Passwords) + '%');
            myWriter.close();
            System.out.println("Password  stored");

        } catch (IOException e) {
            System.out.println("did not work");
            e.printStackTrace();
        }
    }

    public static void CheckAccount() {
        String UserCheck = getInput("what is your username?");

        String passCheck = getInput("what is your username?");
    }

    public static void split() throws IOException {

        String passsplit = new String(Files.readAllBytes(Paths.get("passwords.txt")), StandardCharsets.UTF_8);
        System.out.println(passsplit);
        String[] splitstring = passsplit.split("%");
        System.out.println(splitstring[3]);

        String usersplit = new String(Files.readAllBytes(Paths.get("users.txt")), StandardCharsets.UTF_8);
        System.out.println(usersplit);
        String[] splituser = usersplit.split("%");
        System.out.println(splituser[3]);

    }
}

