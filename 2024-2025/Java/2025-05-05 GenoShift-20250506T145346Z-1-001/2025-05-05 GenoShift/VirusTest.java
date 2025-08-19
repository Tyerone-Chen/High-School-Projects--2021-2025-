public class VirusTest {
    public static void main(String[] args) {
        // Step 1: Build initial virus using RandomGenomeBuilder
        VirusBuilder builder = new RandomVirusBuilder();
        Virus parent = builder.buildInitialVirus();
        parent.setMutationStrategy(new SimpleMutationStrategy());
        parent.setFitnessStrategy(new GCContentFitness());
        
        // Step 2: Print the original (generation 0) virus
        System.out.println("Original Virus:");
        System.out.println(parent);

        // Step 3: Mutate the virus to produce a child (generation 1)
        Virus child = parent.mutate();

        // Step 4: Print the mutated virus
        System.out.println("\nMutated Virus:");
        System.out.println(child);
    }
}