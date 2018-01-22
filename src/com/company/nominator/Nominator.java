package com.company.nominator;

import com.company.award.Award;
import com.company.nominee.Nominee;

/**
 * Created by Klim_Starykau on 12/15/2017.
 */
public class Nominator {

    static {
        System.out.println("nominator class init");
    }

    private String name;
    private int nominatorAwardQuantityLimit;
    private double nominatorAwardTotalLimit;


    public Nominator(String name) {
        this.name = name;
    }

    public Nominator(String name, int nominatorAwardQuantityLimit, double nominatorAwardTotalLimit) {
        this.name = name;
        this.nominatorAwardQuantityLimit = nominatorAwardQuantityLimit;
        this.nominatorAwardTotalLimit = nominatorAwardTotalLimit;
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
}
