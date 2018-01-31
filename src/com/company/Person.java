package com.company;

import com.company.award.Award;

/**
 * Created by Klim_Starykau on 1/22/2018.
 */
public abstract class Person implements OperationsWithLimit{

    private int userId;
    private String clientName;
    private String userPrivilege = "Base privilege";
    protected int nomineeAwardQuantityLimit;
    protected double nomineeAwardTotalLimit;
    protected int nominatorAwardQuantityLimit;
    protected double nominatorAwardTotalLimit;
    protected String name;


    protected Person(int userId, String clientName, String userPrivilege) {
        this.userId = userId;
        this.clientName = clientName;
        this.userPrivilege = userPrivilege;
    }

    public Person() {
    }

    public void receiveAward(Award award) {}
    public void nominate(Person nominee, Award award){}

    public void AssingToClient(String newClientName) {}

    public void AssingToClient(int newClientId){}

    @Override
    public String toString() {
        return "Person{" +
                "userId=" + userId +
                ", clientName='" + clientName + '\'' +
                ", userPrivilege='" + userPrivilege + '\'' +
                '}';
    }

    @Override
    public boolean isLimitReached(double averageValue, double limitValue) {
        return false;
    }

    public int getNomineeAwardQuantityLimit() {
        return nomineeAwardQuantityLimit;
    }
    public double getNomineeAwardTotalLimit() {
        return nomineeAwardTotalLimit;
    }
    public int getNominatorAwardQuantityLimit() {
        return nominatorAwardQuantityLimit;
    }
    public double getNominatorAwardTotalLimit() {
        return nominatorAwardTotalLimit;
    }

    public String getName() {
        return name;
    }
}