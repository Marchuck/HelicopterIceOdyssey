package pl.marchuck.helicoptericeodyssey.rxcache.models;

/**
 * @author Lukasz Marczak
 * @since 24.08.16.
 */
public class Poke {
    public String name;
    public int weight;
    public int height;

    @Override
    public String toString() {
        return "[name: " + name
                + ", weight: " + weight
                + ", height: " + height + "]";
    }
}
