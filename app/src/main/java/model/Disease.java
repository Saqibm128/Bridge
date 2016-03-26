package model;

/**
 * Created by Jacob on 3/26/2016.
 */
public class Disease {

    private String diseaseName, diseaseDescription;


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
}
