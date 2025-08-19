package builder;

import core.Virus;
import strategy.FitnessStrategy;

import java.util.*;

/**
 * Utility class for constructing Virus objects in various ways.
 */
public class VirusFactory {

    /**
     * Creates a virus with random genome segments and assigns a fitness strategy.
     * @param studentId ID of the student owning this virus
     * @param fitnessStrategy strategy used to calculate fitness
     * @return a new randomly generated Virus
     */
    public static Virus createRandomVirus(String studentId, FitnessStrategy fitnessStrategy) {
        // TODO: implement random genome generation and mutation rate
        return null;
    }

    /**
     * Creates a custom virus from provided genome and mutation rate.
     * @param studentId student ID
     * @param segments genome segments
     * @param rate mutation rate
     * @param fitnessStrategy strategy used to calculate fitness
     * @return custom Virus
     */
    public static Virus createCustomVirus(String studentId, List<String> segments, double rate, FitnessStrategy fitnessStrategy) {
        // TODO: create and return custom Virus with fitness strategy
        return null;
    }

    /**
     * Produces a new virus by combining segments from two parent viruses.
     * @param v1 first parent
     * @param v2 second parent
     * @param fitnessStrategy strategy to assign to offspring
     * @return reassorted Virus
     */
    public static Virus reassort(Virus v1, Virus v2, FitnessStrategy fitnessStrategy) {
        // TODO: implement segment mixing and offspring creation
        return null;
    }
}
