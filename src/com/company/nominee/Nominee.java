package com.company.nominee;

import com.company.Person;
import com.company.award.Award;

/**
 * Created by Klim_Starykau on 12/15/2017.
 */
public class Nominee extends Person{

    static {
        System.out.println("nominee class init");
    }

    private String name;
    private String nomineePrivilege = "NomineePrivilege";
    private String nomineeBased;


    public Nominee(String name, int nomineeAwardQuantityLimit, double nomineeAwardTotalLimit, int userId, String clientName, String userPrivilege, String nomineePrivilege) {
        super(userId, clientName, userPrivilege);
        this.name = name;
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
        this.nomineeAwardTotalLimit = nomineeAwardTotalLimit;
        this.nomineePrivilege = nomineePrivilege;
    }

    @Override
    public void AssingToClient(String newClientName) {
        this.nomineeBased = "NomineeBased - Qlik";
        System.out.println(this);
    }

    public Nominee(String name) {
        this.name = name;
    }

    public void receiveAward(Award award) {
        if (award.getSoli() != null) {
            double recalculatedAward = award.getValue() * award.getSoli();
            System.out.println("Soli = [" + award.getSoli() + "] Recalculated award = [" + recalculatedAward + "] Initial amount difference = [" + ((award.getValue() - recalculatedAward) / award.getValue()) * 100 + "%]");
        } else
            System.out.println("Received award = [" + award.getValue() + "]");
    }

    public String getName() {
        return name;
    }

    public int getNomineeAwardQuantityLimit() {
        return nomineeAwardQuantityLimit;
    }

    public void setNomineeAwardQuantityLimit(int nomineeAwardQuantityLimit) {
        this.nomineeAwardQuantityLimit = nomineeAwardQuantityLimit;
    }

    public double getNomineeAwardTotalLimit() {
        return nomineeAwardTotalLimit;
    }

    public void setNomineeAwardTotalLimit(double nomineeAwardTotalLimit) {
        this.nomineeAwardTotalLimit = nomineeAwardTotalLimit;
    }


    @Override
    public String toString() {
        return   super.toString() + "Nominee{" +
                "name='" + name + '\'' +
                ", nomineeAwardQuantityLimit=" + nomineeAwardQuantityLimit +
                ", nomineeAwardTotalLimit=" + nomineeAwardTotalLimit +
                ", nomineePrivilege='" + nomineePrivilege + '\'' +
                ", nomineeBased='" + nomineeBased + '\'' +
                '}';
    }
}
