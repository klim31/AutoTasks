package com.company;

import com.company.award.Award;
import com.company.nominator.Nominator;
import com.company.nominee.Nominee;

public class Main {

    public static void main(String[] args) {

        NominationHelper nominationHelper = new NominationHelper();
        Award awardNoSoli = new Award(70);
        Nominator nominator = new Nominator("Gary", 5, 300);
        Nominee nominee = new Nominee("Klim", 4, 350);
        nominationHelper.nominationInitiator(nominee, nominator, awardNoSoli);
    }
}
