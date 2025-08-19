package builder;

import core.Virus;
import java.util.*;

/**
 * Interface for students to build custom virus entries in the simulation.
 * This interface provides a flexible way for students to create their own
 * virus designs, specifying genomes, mutation rates, and fitness strategies.
 */
public interface VirusBuilder {

    /**
     * Builds a student-designed virus.
     * Students must define the genome, mutation rate, and assign a fitness strategy.
     *
     * Preconditions:
     * - The genome should contain at least one valid segment.
     * - The mutation rate should be between 0.0 and 1.0.
     * - A fitness strategy must be assigned to the virus.
     *
     * Postconditions:
     * - Returns a fully initialized Virus object with generation 0.
     * - The Virus object will be ready for use in the simulation, with all required attributes set.
     *
     * @return an initialized Virus object with generation 0 and a fitness strategy
     */
    Virus buildInitialVirus();
}