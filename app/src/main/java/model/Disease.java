package model;

import java.io.Serializable;

/**
 * Created by Jacob on 3/26/2016.
 */
public class Disease implements Serializable {

    private static Disease d;

    private String diseaseName, diseaseDescription;

    public void setCurrentDisease() {
        d = this;
    }

    public static Disease getCurrentDisease() {
        return d;
    }

    public Disease(String name, String description){
        diseaseName = name;
        diseaseDescription = description;
    }

    public String getDiseaseDescription(){
        return diseaseDescription;
    }

    public String getDiseaseName(){
        return diseaseName;
    }

    public String toString() {
        return getDiseaseName() + " \n" + getDiseaseDescription();
    }
}
