package strategy;

import core.Virus;
import java.util.*;

/**
 * Strategy interface for evaluating the fitness of a Virus object.
 * Implementing classes should define specific criteria for scoring a virus's fitness.
 * This pattern allows for flexible fitness evaluation based on different evolutionary pressures.
 */
public interface FitnessStrategy {
    /**
     * Calculates the fitness score for a given virus.
     *
     * Preconditions:
     * - The Virus object should be fully initialized with genome data.
     *
     * Postconditions:
     * - Returns a fitness score between 0.0 and 1.0, where 1.0 represents the highest possible fitness.
     *
     * @param virus the virus to evaluate
     * @return fitness score between 0.0 and 1.0
     */
    double evaluateFitness(Virus virus);
}
