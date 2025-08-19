import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;


/**
 * Your task is to complete this class by extending the abstract IOMiner.
 * You will implement the required methods to mine matrices and save/load them to/from a file.
 *
 * Step 1: Rename this class to YourLastNameIOMiner
 * Step 2: Complete the two required methods
 * Step 3: Implement any helper methods you need (filling payload, writing to file, etc.)
 */
public class ChenIOMiner extends IOMiner {

    // Optional: Declare any helper variables you need
    // Stores a 4D Array, I know its excessive but its kinda funny
    private int[][][][] payload_storage = new int [10][2000][100][100];
    // Array which helps track index of the storage slot
    private int[] payload_index = new int[10];
    // Stores the global highest hash to be mined further beyond
    private BigInteger glob_high_hash = new BigInteger("115792071916421868734897532603214918692871862735565922097692107727548453309282");
    
    // The maximum threads to use
    private final int MAX_THREADS = 12;
    // Object lock to make sure a synchronized access of resourcess
    private final Object LOCK = new Object();
    
    // Timer Trackers
    private long script_start_time = System.nanoTime();
    private final double SECONDS_DIVISION = 1_000_000_000.0;

    /**
     * Constructor — must call the superclass constructor with a name
     */
    public ChenIOMiner() throws Exception {
        super("My Custom Miner");

        // Optional: initialize anything here
        buildDataFile();

        // --- DO NOT EDIT BELOW THIS LINE ---
        System.out.println("Constructor complete!");
        printAllHashes();
    }
    
    // Helper Methods
    /* Generates a 2D array payload of [100][100]
      @return - A Randomly Generate array of [100][100]
    */
    private int[][] generatePayload(){
      int[][] payload = new int[ROWS][COLS]; 
      Random random_int = new Random(); // Rand Num Generatir
      for (int row = 0; row < payload.length; row++){
         for (int col = 0; col < payload[row].length; col++){
            payload[row][col] = random_int.nextInt(); // Fill in each Cell
         }
      }
      return payload;
    }
    
    /* Stores a payload into a massive storage array if it has a higher hash value
      @param int[][] - Inputed Payload to be stored 
      @param BigInteger - Inputed Hash Value
      @return - True if it was stored succesfully, false if it wasn't :[
    */
    
    private boolean storePayload(int[][] in_payload, BigInteger in_hash){
      synchronized (LOCK){ // Sync to prevent a race con 
         // Compares in_hash with the global one if it is higher
         if (glob_high_hash != null && in_hash.compareTo(glob_high_hash) <= 0){
            return false; // Skip if not higher
         }
         
         // Iterate to find a storage cell
         for (int i = 0; i < payload_storage.length; i++){
            if (payload_index[i] < payload_storage[i].length){
               payload_storage[i][payload_index[i]] = in_payload; // Store it
               payload_index[i]++; // Increase the next slot
               glob_high_hash = in_hash; // Update global to be the in_hash
               return true;
            } 
            else {
               System.out.println("[WARNING] | Payload Storage Full - SKIPPING! |"); // theres no space :[
            }
         }
         System.out.println("[NO SPACE] | Payload Storage Full - SKIPPING! | "); // theres no space :[
      }   
      return false;
    }
    
    // Overided Methods

    /**
     * Implements the mining process and writes 2D matrices to a file.
       Also uses multi-threading to make generation happen in parallel
         Also to destroy my laptop
     */
    @Override
    public void buildDataFile() throws Exception {
        System.out.println("[BUILDING] | Building Data File...");
        // Setup txt file
        File write_file = new File(this.getClass().getSimpleName() + ".txt");   
        
        // Setup File to Write
        try (PrintWriter writer = new PrintWriter(new FileWriter(write_file, false))){
            // Create & Setup THreads
            Thread[] threads = new Thread[MAX_THREADS];
            for (int i = 0; i < threads.length; i++){
               threads[i] = new Thread( () -> {
                  try{
                     // Keep mining until MAXHASHES is reached
                     while (numberOfHashes() < MAXHASHES){
                        long elapsed_time = System.nanoTime() - script_start_time; // Generate Elapsed TIme
                        double elapsed_time_sec = elapsed_time / SECONDS_DIVISION; // Generate it in a nicer format, ie seconds
                        // Generate payload & hash
                        int[][] curr_payload = generatePayload(); 
                        BigInteger curr_hash = hashCode(curr_payload);
                        
                        // If the payload qualifies to be stored, ie its a new global
                        if (storePayload(curr_payload, curr_hash)){
                           System.out.println("[WRITE] | Writing Current Hash to Data File | "  + elapsed_time_sec);
                           synchronized(writer){ // Sync the write so nothing bad happens
                              // Write & load the hash file
                              for (int[] row : curr_payload){
                                 for (int col_val : row){
                                    writer.print(col_val + " ");
                                 }
                                 writer.println("");
                              }
                              System.out.println(curr_hash);
                              loadPayload(curr_payload);
                           }
                        }
                        else {
                        //System.out.println("[SKIPPED] | SKIPPED HASH! | " + elapsed_time_sec);
                        }
                     }
                  }
                  catch(Exception err){
                     System.err.println("[ERROR!?!] | " + err.getMessage());
                  }
               
               });
               threads[i].start(); // Start the threads
            }
            for (Thread thread : threads){
               thread.join(); // Wait for all threads to end
            }
            writer.close(); // Close Writer
        }
        System.out.println("[SUCCESS!] | Hash Data File Built Successfully! |");        
    }

    /**
     * Loads previously mined matrices from file and adds their hashes to the miner.
     */
    @Override
    public void loadDataFile() throws Exception {
         System.out.println("[LOAD] | Loading Hash Data File...");

       // File to read
       File read_file = new File(this.getClass().getSimpleName() + ".txt");
   
       if (!readFile.exists()) {
           throw new Exception("[ERROR] | Cannot find hash data file!");
       }
   
       try (Scanner read_scanner = new Scanner(read_file)){
           // Read payloads from the file
           while (read_scanner.hasNextLine()) {
               int[][] payload = new int[ROWS][COLS];
               for (int row = 0; row < ROWS; row++){
                   if (!read_scanner.hasNextLine()) {
                       throw new Exception("[ERROR] | File format is incorrect! Missing rows.");
                   }
                   String[] payload_values = read_scanner.nextLine().trim().split("\\s+");
                   if (payload_values.length != COLS){
                       throw new Exception("[ERROR] | File format is incorrect! Column mismatch.");
                   }
                   for (int col = 0; col < COLS; col++){
                       payload[row][col] = Integer.parseInt(values[col]);
                   }
               }
               // Reconstruct hash and load into memory
               loadPayload(payload);
           }
       }
       System.out.println("[SUCCESS] | Hash Data File Successfully Loaded!");
    }

    // Optional: Write your own helper methods below (e.g., fillPayload, writePayload)

    /**
     * Entry point for testing your miner.
     */
    public static void main(String[] args) throws Exception {
        new ChenIOMiner(); // You can change this to match your renamed class
    }
}