/**
 * Represents a utensil in the Spoons game, which can either be a "Spoon" or a "Fork".
 * <p>
 * Forks are treated differently during the race for utensils.
 * </p>
 */
public class Utensil {
    private final String type;

    /**
     * Constructs a {@code Utensil} with the specified type.
     *
     * @param type the type of utensil, expected to be either "Spoon" or "Fork"
     */
    public Utensil(String type) {
        this.type = type;
    }

    /**
     * Returns the type of this utensil.
     *
     * @return the utensil type as a {@code String}
     */
    public String getType() {
        return type;
    }

    /**
     * Determines whether this utensil is a fork.
     *
     * @return {@code true} if the utensil is a "Fork"; {@code false} otherwise
     */
    public boolean isFork() {
        return "Fork".equals(type);
    }

    /**
     * Returns a string representation of this utensil.
     *
     * @return the utensil type as a {@code String}
     */
    @Override
    public String toString() {
        return type;
    }
}
