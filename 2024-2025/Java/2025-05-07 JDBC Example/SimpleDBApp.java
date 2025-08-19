import java.sql.*;
import java.util.Scanner;

/**
 * SimpleDBApp - A basic SQLite database demo application for Java 2 students.
 * 
 * This program demonstrates how to use JDBC to connect to an SQLite database, create tables, and perform basic
 * CRUD (Create, Read, Update, Delete) operations. It includes a simple console menu for interacting with the database.
 * 
 * Database Schema:
 * - Table Name: students
 * - Columns: id (INTEGER, PK), name (TEXT), age (INTEGER), major (TEXT)
 * 
 * Usage:
 * - Run the program to initialize the database and table.
 * - Use the menu options to add, view, update, or delete student records.
 * 
 * Author: Mr. Overocker
 * Version: 1.0
 */
public class SimpleDBApp {
    /** Database URL for the SQLite connection */
    private static final String DB_URL = "jdbc:sqlite:SimpleDemo.db";

    /**
     * Main entry point of the application.
     * 
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            setupDatabase();
            runMenu();
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }

    /**
     * Initializes the SQLite database and creates the 'students' table if it doesn't exist.
     * 
     * @throws SQLException if there is an error establishing the database connection or executing the table creation
     */
    private static void setupDatabase() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            // SQL command to create the students table
            String createTableSQL = """
                CREATE TABLE IF NOT EXISTS students (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    age INTEGER,
                    major TEXT
                );
            """;
            stmt.execute(createTableSQL);
            System.out.println("Database and 'students' table are ready.");
        }
    }

    /**
     * Runs the main menu for user interaction with the database.
     */
    private static void runMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Display the main menu options
            System.out.println("\n=== Student Database Menu ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the input buffer
            
            // Handle the user's menu selection
            switch (choice) {
                case 1 -> addStudent(scanner);
                case 2 -> viewAllStudents();
                case 3 -> updateStudent(scanner);
                case 4 -> deleteStudent(scanner);
                case 5 -> {
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    /**
     * Adds a new student to the database.
     * 
     * @param scanner Scanner object for reading user input
     */
    private static void addStudent(Scanner scanner) {
        // Prompt for student details
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer
        
        System.out.print("Enter student major: ");
        String major = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO students (name, age, major) VALUES (?, ?, ?)");) {
            // Set parameters for the prepared statement
            pstmt.setString(1, name);
            pstmt.setInt(2, age);
            pstmt.setString(3, major);
            pstmt.executeUpdate();
            System.out.println("Student added successfully!");
        } catch (SQLException e) {
            System.err.println("Error adding student: " + e.getMessage());
        }
    }

    /**
     * Displays all students in the database.
     */
    private static void viewAllStudents() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {
            // Print all student records
            System.out.println("\nAll Students:");
            while (rs.next()) {
                System.out.printf("ID: %d, Name: %s, Age: %d, Major: %s%n",
                        rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("major"));
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving students: " + e.getMessage());
        }
    }

    /**
     * Updates a student's major based on their ID.
     * 
     * @param scanner Scanner object for reading user input
     */
    private static void updateStudent(Scanner scanner) {
        // Prompt for student ID and new major
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer
        
        System.out.print("Enter new major: ");
        String newMajor = scanner.nextLine();

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("UPDATE students SET major = ? WHERE id = ?")) {
            // Set parameters for the prepared statement
            pstmt.setString(1, newMajor);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("No student found with ID " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error updating student: " + e.getMessage());
        }
    }

    /**
     * Deletes a student from the database based on their ID.
     * 
     * @param scanner Scanner object for reading user input
     */
    private static void deleteStudent(Scanner scanner) {
        // Prompt for student ID to delete
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear the input buffer

        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM students WHERE id = ?")) {
            // Set parameter for the prepared statement
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("No student found with ID " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error deleting student: " + e.getMessage());
        }
    }
}
