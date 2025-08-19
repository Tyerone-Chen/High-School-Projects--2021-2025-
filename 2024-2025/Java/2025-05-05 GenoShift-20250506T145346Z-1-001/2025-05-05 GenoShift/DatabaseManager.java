import java.util.*;
import java.sql.*;

// ================================
// DatabaseManager.java
// ================================
/**
 * Manages all JDBC database interactions for the simulation.
 */
public class DatabaseManager {
    private static DatabaseManager instance;

    /**
     * Private constructor to enforce singleton pattern.
     */
    private DatabaseManager() {
        // TODO: initialize connection
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
     * @param offspring number of children created
     * @param generations generations survived
     */
    public void updateLeaderboard(String studentId, double peakFitness, int offspring, int generations) {
        // TODO: insert or update leaderboard
    }

    /**
     * Retrieves the current leaderboard.
     * @return leaderboard entries as strings or summary objects
     */
    public List<String> getLeaderboard() {
        // TODO: select and return leaderboard entries
        return new ArrayList<>();
    }
}
