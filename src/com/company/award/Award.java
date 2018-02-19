package com.company.award;

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
    private Long id;

    /**
     * Class constructor. With  id and type parameters specified
     */

    public Award(Long id, String type) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
