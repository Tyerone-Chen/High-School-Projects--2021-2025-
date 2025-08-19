import java.io.File;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;

/**
 * IOMiner is the abstract superclass of any custom mining class such as MyIOMiner.
 *
 * An IOMiner "mines" a 2D int matrix for SHA-256 hashes that are
 * strictly increasing in value. These hashes represent unique data payloads.
 *
 * Mined matrices are written to a text file and can be reloaded later.
 * Internally, only the hashes of the mined matrices are stored in
 * a private ArrayList within the IOMiner.
 *
 * ************************************************************
 ***   STUDENT NOTE:
 ***   You must extend this class and implement the abstract methods
 ***************************************************************/
public abstract class IOMiner {

    // Constants for matrix size and number of hashes to mine
    public static final int ROWS = 100;
    public static final int COLS = 100;
    public static final int MAXHASHES = 10

    // Internal list of stored hashes
    private ArrayList<BigInteger> hashes;

    // Name of this miner instance
    private String myName;

    /**
     * Default Constructor — Disabled.
     * Students must call the custom constructor using `super(name)` from their subclass.
     */
    public IOMiner() throws Exception {
        throw new Exception("You need to call the superclass constructor with a name.");
    }

    /**
     * Custom Constructor
     * Initializes the miner and either loads a saved file or builds a new one.
     * File is named after the subclass (e.g., MyIOMiner.txt).
     */
    public IOMiner(String name) throws Exception {
        this.hashes = new ArrayList<>();
        this.myName = name;

        String className = this.getClass().getSimpleName();
        File f = new File(className + ".txt");

        System.out.println("Looking for " + f.toString());
        if (f.exists()) {
            System.out.println("Found Data File");
            loadDataFile();
        } else {
            System.out.println("No Data File");
            buildDataFile();
        }
    }

    /**
     * Abstract method to build a new data file with MAXHASHES mined matrices.
     * Must be implemented by a subclass.
     * 
     * Precondition: No existing data file.
     * Postcondition: File with 10 matrices written and hashes stored internally.
     */
    public abstract void buildDataFile() throws Exception;

    /**
     * Abstract method to load an existing data file into the miner.
     * Must be implemented by a subclass.
     *
     * Precondition: Properly formatted data file exists.
     * Postcondition: Hashes loaded into memory.
     */
    public abstract void loadDataFile() throws Exception;

    /**
     * Calculates and stores the hash of a payload matrix.
     * Throws if the internal list is already full.
     */
    public final void loadPayload(int[][] payload) throws Exception {
        if (hashes.size() == MAXHASHES)
            throw new Exception("Too many hashes!");
        hashes.add(hashCode(payload));
        System.out.println("Added hash # " + hashes.size());
    }

    /**
     * Returns the most recently stored hash.
     * Throws if list is empty.
     */
    public final BigInteger getLastHash() throws Exception {
        if (hashes.isEmpty())
            throw new Exception("No hashes saved!");
        return hashes.get(hashes.size() - 1);
    }

    /**
     * Returns the number of stored hashes.
     */
    public final int numberOfHashes() {
        return hashes.size();
    }

    /**
     * Returns a readable name and count of stored hashes.
     */
    @Override
    public String toString() {
        return myName + " (" + numberOfHashes() + ")";
    }

    /**
     * Removes and returns the first hash in the list.
     */
    public final BigInteger removeFirstHash() {
        return hashes.remove(0);
    }

    /**
     * Returns (but does not remove) the first hash in the list.
     */
    public final BigInteger getFisrtHash() {
        return hashes.get(0);
    }

    /**
     * Prints all stored hashes to standard output.
     */
    public final void printAllHashes() {
        for (BigInteger hash : hashes) {
            System.out.println(hash);
        }
    }

    /**
     * Computes a SHA-256 hash of a 2D int matrix.
     * Returns it as a BigInteger.
     *
     * Postcondition: The internal state of the miner is unchanged.
     */
    public static final BigInteger hashCode(int[][] payload) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(toString(payload).getBytes(StandardCharsets.UTF_8));
        return new BigInteger(1, hash);
    }

    /**
     * Converts a 2D int array into a string suitable for hashing.
     */
    private static final String toString(int[][] payload) {
        StringBuilder builder = new StringBuilder();
        for (int[] row : payload) {
            for (int val : row) {
                builder.append(val).append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
