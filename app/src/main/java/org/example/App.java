/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

import org.example.entities.User;
import org.example.services.UserBookingService;
import org.example.utils.UserServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class App {

    public static void main(String[] args) {
        System.out.println("Running Train Booking System");
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        UserBookingService userBookingService;
        try {
            userBookingService = new UserBookingService();
        } catch(IOException ex) {
            System.out.println("Error occurred");
            return;
        }

        while (option!=7) {
            System.out.println("Select options - ");
            option = scanner.nextInt();
            switch(option) {
                case 1:
                    System.out.println("Enter username - ");
                    String newUsername = scanner.next();
                    System.out.println("Enter password - ");
                    String newPassword = scanner.next();
                    User newUser = new User(
                            newUsername,
                            newPassword,
                            UserServiceUtil.hashPassword(newPassword),
                            new ArrayList<>(),
                            UUID.randomUUID().toString()
                    );
                    userBookingService.signUp(newUser);

                case 2:
                    System.out.println("Enter username - ");
                    String existingUsername = scanner.next();
                    System.out.println("Enter password - ");
                    String existingUserPassword = scanner.next();
                    userBookingService.loginUser();
                case 3:
            }
        }
    }
}
