package builder;
import core.Virus;
import strategy.GCContentFitness;

import java.util.*;

/**
 * Example implementation of a custom virus submitted by a student.
 */
public class Student42Virus implements VirusBuilder {

    @Override
    public Virus buildInitialVirus() {
        // TODO: define genome
        List<String> genome = Arrays.asList("AGTCTT", "GCTATA", "TCAGTG", "AACGTT");

        // TODO: define mutation rate
        double mutationRate = 0.03;

        // TODO: create virus
        Virus v = new Virus(UUID.randomUUID().toString(), "Student42", genome, mutationRate, 0);

        // TODO: assign fitness strategy
        v.setFitnessStrategy(new GCContentFitness()); // Replace with your own strategy class

        return v;
    }
}
