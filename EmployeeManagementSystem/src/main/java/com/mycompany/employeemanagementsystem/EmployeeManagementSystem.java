/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeemanagementsystem;

/**
 *
 * @author Michiko
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */



import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // ===== LOGIN FRAME =====
        String correctUser = "admin";
        String correctPass = "1234";
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Username: ");
            String user = scan.nextLine();
            System.out.print("Password: ");
            String pass = scan.nextLine();

            if (user.equals(correctUser) && pass.equals(correctPass)) {
                System.out.println("Logged In Successfully!\n");
                loggedIn = true;
            } else {
                System.out.println("Invalid username or password. Please try again.\n");
            }
        }

        // ===== EMPLOYEE SYSTEM =====
        ArrayList<String[]> employees = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Remove Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            String choice = scan.nextLine();

            if (choice.equals("1")) {
                // Add
                System.out.print("Enter ID: ");
                String id = scan.nextLine();
                System.out.print("Enter Name: ");
                String name = scan.nextLine();
                System.out.print("Enter Position: ");
                String position = scan.nextLine();
                employees.add(new String[]{id, name, position});
                System.out.println("Employee added.\n");

            } else if (choice.equals("2")) {
                // View
                if (employees.isEmpty()) {
                    System.out.println("No employees yet.\n");
                } else {
                    System.out.println("Employee List:");
                    for (String[] e : employees) {
                        System.out.println("ID: " + e[0] + " | Name: " + e[1] + " | Position: " + e[2]);
                    }
                    System.out.println();
                }

            } else if (choice.equals("3")) {
                // Remove
                System.out.print("Enter ID to remove: ");
                String removeId = scan.nextLine();
                boolean found = false;
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i)[0].equals(removeId)) {
                        employees.remove(i);
                        found = true;
                        break;
                    }
                }
                System.out.println(found ? "Employee has been removed.\n" : "Employee not found!.\n");

            } else if (choice.equals("4")) {
                // Update
                System.out.print("Enter ID to update: ");
                String updateId = scan.nextLine();
                boolean found = false;
                for (String[] e : employees) {
                    if (e[0].equals(updateId)) {
                        System.out.print("Enter new name: ");
                        e[1] = scan.nextLine();
                        System.out.print("Enter new position: ");
                        e[2] = scan.nextLine();
                        found = true;
                        break;
                    }
                }
                System.out.println(found ? "Employee has been updated successfully!\n" : "Employee not found.\n");

            } else if (choice.equals("5")) {
                // Exit
                running = false;
                System.out.println("Logging Out. Goodbye!");
            } else {
                System.out.println("Invalid choice.\n");
            }
        }

        scan.close();
    }
}