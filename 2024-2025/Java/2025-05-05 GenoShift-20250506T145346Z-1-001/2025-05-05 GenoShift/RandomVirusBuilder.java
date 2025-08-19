import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RandomVirusBuilder implements VirusBuilder{

   // Configurable defaults (can be made dynamic later)
   private static final int DEFAULT_SEGMENTS = 7;
   private static final int SEGMENT_LENGTH = 10;
   private static final double DEFAULT_MUTATION_RATE = 0.5;
   private static final String DEFAULT_STUDENT_ID = "random-gen";
   
    @Override
    public Virus buildInitialVirus() {
        List<String> genome = new ArrayList<>();

        for (int i = 0; i < DEFAULT_SEGMENTS; i++) {
            StringBuilder segment = new StringBuilder();
            for (int j = 0; j < SEGMENT_LENGTH; j++) {
                segment.append(GenomeUtils.randomNucleotide());
            }
            genome.add(segment.toString());
        }

        Virus virus = new Virus(
            UUID.randomUUID().toString(),  // unique virus ID
            DEFAULT_STUDENT_ID,            // system or fallback student ID
            null,                          // null is a virus without a parent Gen Zero
            genome,                        // randomized genome
            DEFAULT_MUTATION_RATE,         // default mutation rate
            0                             // generation 0
        );

        return virus;
    }
}