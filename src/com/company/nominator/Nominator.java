package com.company.nominator;

import com.company.Person;
import com.company.award.Award;
import com.company.nominee.Nominee;

/**
 * Created by Klim_Starykau on 12/15/2017.
 */
public class Nominator extends Person {

    static {
        System.out.println("nominator class init");
    }

    private String name;
    private int nominatorAwardQuantityLimit;
    private double nominatorAwardTotalLimit;
    private String nominatorPrivilege = "NominatorPrivilege";
    private String nominatorBased;


    public Nominator(String name) {
        this.name = name;
    }


    public Nominator(String name, int nominatorAwardQuantityLimit, double nominatorAwardTotalLimit, int userId, String clientName, String userPrivilege, String nominatorPrivilege) {
        super(userId, clientName, userPrivilege);
        this.name = name;
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
        this.nominatorAwardTotalLimit = nominatorAwardTotalLimit;
        this.nominatorPrivilege = nominatorPrivilege;
    }

    @Override
    public void AssingToClient(String newClientName) {
        this.nominatorBased = "NominatorBased";
        System.out.println(this);
    }


    public void nominate(Nominee nominee, Award award) {
        System.out.println("nominee = [" + nominee.getName() + "], given award = [" + award.getValue() + "]");
        nominee.receiveAward(award);
    }

    public int getNominatorAwardQuantityLimit() {
        return nominatorAwardQuantityLimit;
    }

    public void setNominatorAwardQuantityLimit(int nominatorAwardQuantityLimit) {
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
    }

    public double getNominatorAwardTotalLimit() {
        return nominatorAwardTotalLimit;
    }

    public void setNominatorAwardTotalLimit(double nominatorAwardTotalLimit) {
        this.nominatorAwardTotalLimit = nominatorAwardTotalLimit;
    }

    @Override
    public String toString() {
        return super.toString() + "Nominator{" +
                "name='" + name + '\'' +
                ", nominatorAwardQuantityLimit=" + nominatorAwardQuantityLimit +
                ", nominatorAwardTotalLimit=" + nominatorAwardTotalLimit +
                ", nominatorPrivilege='" + nominatorPrivilege + '\'' +
                ", nominatorBased='" + nominatorBased + '\'' +
                '}';
    }
}
