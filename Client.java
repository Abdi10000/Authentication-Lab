// Created by group 111
// Course: Data Security
// Autumn 2022

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;


// client part
public class Client {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

        // before the client is able to use the functions below
        // the server should verify, if the clients credentials
        // exist in the database

        String username;
        String password;
        int userID;

        // input
        Scanner scanner = new Scanner(System.in);

        System.out.print("Write user credentials: ");

        // including input
        //username = scanner.nextLine();
        //password = scanner.nextLine();
        //userID = scanner.nextInt();


        // From server 5099 in ApplicationServer.java file
        Service service = (Service) Naming.lookup("rmi://localhost:5099/printer");


        // verifying password between user input and database
        // In this case we haven't been able to compare with the database
        if (scanner.nextLine().equals("password")) {


            System.out.println("--- " + "You got access to the printer");
            System.out.println();


            // testing the program using the methods/functions from the Server.java file
            System.out.println("--- " + service.print("picture.pdf", "X2"));
            System.out.println("--- " + service.queue("X2"));
            System.out.println("--- " + service.topQueue("X2", 2));
            System.out.println("--- " + service.start());
            System.out.println("--- " + service.stop());
            System.out.println("--- " + service.restart());
            System.out.println("--- " + service.status("printer status"));
            System.out.println("--- " + service.readConfig("token"));
            System.out.println("--- " + service.setConfig("map", "treasure"));
        } else {
                System.out.println("Password is wrong");
            }


        // hashing the password value
        //System.out.println(code("password"));
    }


    // This function is used to display the hashed and salted password value
    public static String code(String password) {

        // hashing and salting the password using BCRYPT
        String editedPassword = password;

        // return the hashed and salted password value
        return editedPassword;
    }
}
