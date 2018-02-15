package com.company.award;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Klim_Starykau on 12/15/2017.
 */
public class Award {


    static {
        System.out.println("award class init");
    }

    private int value;
    private Double soli = null;
    private String type;
    private int id;

    /**
     * Method for creation of the default array of awards
     */

    public ArrayList<Award> awardCreator() {
        ArrayList<Award> awards = new ArrayList<Award>();
        for (int i = 0; i < 5; i++) {
            awards.add(new Award(i, "Teamwork"));
        }
        for (int i = 5; i < 10; i++) {
            awards.add(new Award(i, "Determination"));
        }
        for (int i = 10; i < 15; i++) {
            awards.add(new Award(i, "Quality"));
        }
        return awards;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Award award = (Award) o;

        return type != null ? type.equals(award.type) : award.type == null;

    }

    @Override
    public int hashCode() {
        return type != null ? type.hashCode() : 0;
    }

    /**
     * Method for outputting sorted ArrayList of specific type awards and a set of all the award types
     *
     * @param awards List of awards to be sorted
     * @param type   Type of award to be included into sorted table
     */

    public void printAwards(List<Award> awards, String type) {
        ArrayList<Award> awardsQuality = new ArrayList<Award>();
        for (Award award : awards) {
            if (award.getType() == type) {
                awardsQuality.add(award);
            }
        }
        System.out.println("awards = [" + awards + "]");
        System.out.println("Resulting collection of Quality awards = [" + awardsQuality + "]");
        HashSet<Award> distinctSet = new HashSet<Award>();
        for (Award award : awards) {
            distinctSet.add(award);
        }
        System.out.println("Resulting Set of distinct awards = [" + distinctSet + "]");
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Class constructor. With  id and type parameters specified
     */

    public Award(int id, String type) {
        this.id = id;
        this.type = type;
    }

    /**
     * Class constructor. With  value parameter specified
     */

    public Award(int value) {
        this.value = value;
    }

    /**
     * Class constructor. With  value and soli parameters specified
     */

    public Award(int value, double soli) {
        this.value = value;
        this.soli = soli;
    }

    public int getValue() {
        return value;
    }

    public Double getSoli() {
        return soli;
    }

    @Override
    public String toString() {
        return "Award{" +
                "Type = " + type +
                ", Id = " + id + "}";
    }


}
