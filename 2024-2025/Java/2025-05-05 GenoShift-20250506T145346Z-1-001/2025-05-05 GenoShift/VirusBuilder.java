import java.util.*;

/**
 * Interface for students to build custom virus entries.
 */
public interface VirusBuilder {

    /**
     * Builds a student-designed virus.
     * Students must define the genome, mutation rate, and assign a fitness strategy.
     *
     * @return an initialized Virus object with generation 0 and a fitness strategy
     */
    Virus buildInitialVirus();
}
