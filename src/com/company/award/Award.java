package com.company.award;

/**
 * Created by Klim_Starykau on 12/15/2017.
 */
public class Award {

    private String type;
    private int id;

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

    static {
        System.out.println("award class init");
    }

    private final int value;
    private Double soli = null;

    public Award(int value) {
        this.value = value;
    }

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


}
