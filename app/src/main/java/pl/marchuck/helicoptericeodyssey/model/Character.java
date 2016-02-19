package pl.marchuck.helicoptericeodyssey.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Łukasz Marczak
 *
 * @since 19.02.16
 */
public class Character {
    public String name;
    public String height;
    public String mass;
    public String hairColor;
    public String skinColor;
    public String eyeColor;
    public String birthYear;
    public String gender;
    public String homeworld;
    public List<String> films = new ArrayList<String>();
    public List<String> species = new ArrayList<String>();
    public List<String> vehicles = new ArrayList<String>();
    public List<String> starships = new ArrayList<String>();
    public String created;
    public String edited;
    public String url;
}
