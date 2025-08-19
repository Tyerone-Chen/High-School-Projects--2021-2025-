package db;

import java.util.*;
import java.sql.*;
import core.Virus;

// ================================
// DatabaseManager.java
// ================================
/**
 * Manages all JDBC database interactions for the simulation.
 */
public class DatabaseManager {

    private static DatabaseManager instance;
    
    private static final String DB_URL = "jdbc:sqlite:VirusSim.db";

    /**
     * Private constructor to enforce singleton pattern.
     */
    private DatabaseManager() {
        // TODO: initialize connection
        try {
            setupDatabase();
        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }

    }
    
    /** Unique ID for this virus (auto-generated with each mutation). */
    //private long id;
    /** ID of the student who originally designed this virus. */
    //private long studentId;
    /** ID of the virus that originally created this version. */
    //private long parentId;
    /** The digital "DNA" — multiple short strings that make up this virus. */
    //private List<String> genomeSegments;
    /** Probability that each base will mutate during reproduction. */
    //private double mutationRate;
    /** Score representing how "fit" or strong the virus is. */
    //private double fitness;
    /** How many rounds (generations) this virus has survived. */
    //private int generation;
    
    private static void setupDatabase() throws SQLException {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement stmt = conn.createStatement()) {
            // SQL command to create the students table
            String createTableSQL = """
                CREATE TABLE IF NOT EXISTS virusTbl (
                    id INTEGER PRIMARY KEY,
                    studentId INTEGER,
                    parentId INTEGER,
                    genomeSegments TEXT,
                    mutationRate REAL,
                    fitness REAL,
                    generation INTEGER
                );
            """;
            stmt.execute(createTableSQL);
            System.out.println("Database and 'Virus' table are ready.");
        }
    }


    /**
     * Returns the single shared instance of the database manager.
     * @return singleton instance
     */
    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    /**
     * Inserts the initial student virus into the database.
     * @param v the virus to insert
     */
    public void insertInitialVirus(Virus v) {
        // TODO: implement JDBC insert for generation 0
    }

    /**
     * Inserts a newly generated offspring virus.
     * @param v the offspring virus
     */
    public void insertOffspring(Virus v) {
        // TODO: insert new offspring
    }

    /**
     * Deletes a virus entry by its unique ID.
     * @param id virus ID
     */
    public void deleteVirusById(String id) {
        // TODO: delete virus from main table
    }

    /**
     * Moves a virus to the graveyard table.
     * @param v virus to archive
     * @param cause reason for death
     */
    public void buryVirus(Virus v, String cause) {
        // TODO: move virus to graveyard table
    }

    /**
     * Retrieves all viruses from a specific generation.
     * @param gen generation number
     * @return list of matching viruses
     */
    public List<Virus> selectVirusesByGeneration(int gen) {
        // TODO: query viruses by generation
        return new ArrayList<>();
    }

    /**
     * Updates leaderboard stats for a student.
     * @param studentId student ID
     * @param peakFitness highest fitness value observed
     * @param offspring number of children created // Side note I have no clue where this will be put in the database 
     * @param generations generations survived
     */
    public void updateLeaderboard(String studentId, double peakFitness, int offspring, int generations) {
        // Create basis for sql statement
        String update_sql = """
            UPDATE virusTbl 
            SET fitness = ?, generation = ?
            WHERE studentId = ?;
        """;
        
        try (Connection conn = DriverManager.getConnection(DB_URL); 
             PreparedStatement prep_stmt = conn.prepareStatement(update_sql)) {
             // Set each value for the prepared statement
             prep_stmt.setDouble(1, peakFitness);
             prep_stmt.setInt(2, offspring);
             prep_stmt.setInt(3, Integer.parseInt(studentId));
             
             int update_row = prep_stmt.executeUpdate();
             System.out.println("[ Successfull Updated studentId ]: " + studentId);
        }
        catch (Exception err) {
            System.err.println("[ Error Updating Leaderboard ]: " + err.getMessage());
        }
    }

    /**
     * Retrieves the current leaderboard.
     * @return leaderboard entries as strings or summary objects
     * Should get the top ten viruses, ordered by their fitness
     */
    public List<String> getLeaderboard() {
        // Create a basis for the SQL Statement to run
        String get_sql = """
            SELECT id, studentId, fitness, generation
            FROM virusTbl
            ORDER BY fitness DESC
            LIMIT 10;
        """;
        
        List<String> top_viruses = new ArrayList<>();
        
        try (Connection conn = DriverManager.getConnection(DB_URL);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(get_sql) ) { // Create ResultSet to store the results
            
            while (rs.next()) {
               // Formatting for print out
               String data_entry = String.format(
                  "[ Virus ID: %d ] | [ Student ID: %d ] | [ Fitness: %.2f] | [ Generation: %d ]",
                  rs.getInt("id"),
                  rs.getInt("studentId"),
                  rs.getDouble("fitness"),
                  rs.getInt("generation")
               );
               top_viruses.add(data_entry); // Add to array list
            }
        }
        catch (Exception err) {
            System.err.println("[ Error Retireving the Top 10 Viruses ]: " + err.getMessage());
        }
        
        return top_viruses;
    }
}
