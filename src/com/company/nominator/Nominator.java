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

    public Nominator(String name) {
        this.name = name;
    }

    public void nominate(Nominee nominee, Award award) {
        System.out.println("nominee = [" + nominee.getName() + "], given award = [" + award.getValue() + "]");
        nominee.receiveAward(award);
    }
}
