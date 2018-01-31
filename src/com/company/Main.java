package com.company;

import com.company.award.Award;
import com.company.nominator.Nominator;
import com.company.nominee.Nominee;

public class Main {

    public static void main(String[] args) {

        //Inheritance task
        NominationHelper nominationHelper = new NominationHelper();
        Award awardNoSoli = new Award(70);
        Person nominator = new Nominator("Gary", 5, 300, 777, "Staff", "Base privilege", "NominatorPrivilege");
        Person nominee = new Nominee("Klim", 4, 350, 666, "Staff", "Base privilege", "NomineePrivilege");
        nominationHelper.nominationInitiator(nominee, nominator, awardNoSoli);
        nominator.AssingToClient(1);
        nominee.AssingToClient("Qlik");

    }
}
