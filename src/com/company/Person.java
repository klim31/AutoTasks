package com.company;

/**
 * Created by Klim_Starykau on 1/22/2018.
 */
public class Person {

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
        this.clientName = newClientName;
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "userId=" + userId +
                ", clientName='" + clientName + '\'' +
                ", userPrivilege='" + userPrivilege + '\'' +
                '}';
    }

}