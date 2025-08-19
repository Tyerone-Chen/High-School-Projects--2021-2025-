import java.util.*;

/**
 * Defines the strategy interface for evaluating a virus's fitness.
 */
public interface FitnessStrategy {
    /**
     * Calculates the fitness score for a given virus.
     * @param virus the virus to evaluate
     * @return fitness score between 0.0 and 1.0
     */
    double evaluateFitness(Virus virus);
}
