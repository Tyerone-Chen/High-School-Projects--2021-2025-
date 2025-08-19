package core;

/**
 * Singleton class for generating unique serial numbers for objects in the simulation.
 * This class ensures that each generated ID is unique within the runtime of the application.
 */
public class SerialNumberGenerator {

    /**
     * The single instance of the SerialNumberGenerator.
     * This instance is lazily loaded and provides global access to the generator.
     */
    private static final SerialNumberGenerator INSTANCE = new SerialNumberGenerator();
    
    /**
     * The current serial number. Incremented with each call to {@link #getNextID()}.
     */
    private long currentId = 1;

    /**
     * Private constructor to prevent external instantiation, enforcing the singleton pattern.
     */
    private SerialNumberGenerator() {
        // Prevent instantiation outside this class.
    }

    /**
     * Returns the next unique serial number for use in object identification.
     * 
     * Preconditions:
     * - The serial number counter has not exceeded the maximum value for a long (approx. 9.2 quintillion).
     *
     * Postconditions:
     * - Returns a positive long value that is unique for each call.
     * - Increments the internal counter for future ID generation.
     *
     * @return the next unique serial number as a positive long value
     */
    public static long getNextID() {
        return INSTANCE.currentId++;
    }
}
