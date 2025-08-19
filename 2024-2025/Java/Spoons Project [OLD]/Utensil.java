// Utensil.java
/**
 * Represents a utensil in the game: either a Spoon or a Fork.
 */
public class Utensil {
    private final String type;

    public Utensil(String type) {
        this.type = type;
    }

    /**
     * Checks whether this utensil is a fork.
     */
    public boolean isFork() {
        return "Fork".equals(type);
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}