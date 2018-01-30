package com.company;

/**
 * Created by Klim_Starykau on 1/22/2018.
 */
public abstract class Person implements OperationsWithLimit{

    private int userId;
    private String clientName;
    private String userPrivilege = "Base privilege";


    protected Person(int userId, String clientName, String userPrivilege) {
        this.userId = userId;
        this.clientName = clientName;
        this.userPrivilege = userPrivilege;
    }

    public Person() {
    }

    public void AssingToClient(String newClientName) {

    }

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
}