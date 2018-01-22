package com.company;

import com.company.award.Award;
import com.company.nominator.Nominator;
import com.company.nominee.Nominee;

import java.util.ArrayList;

/**
 * Created by Klim_Starykau on 12/21/2017.
 */
public class NominationProcess {

    ArrayList<Nominee> onceNominated = new ArrayList<Nominee>();
    ArrayList<Double> quantities = new ArrayList<Double>();
    private int p = 3;
    UtilClass utilClass = new UtilClass();


    public void massNominateWithSoli(ArrayList<String> nominees, Nominator nominator, Award awardSoli, Award awardNoSoli) {

        for (String s : nominees) {
            Nominee person = new Nominee(s);
            nominator.nominate(person, awardSoli);
            onceNominated.add(person);
            System.out.println("With SOLI: nominee = [" + s + "], awardSoli = [" + awardSoli.getValue() + "] \n ----------------------------------------------------------");
        }
        for (int i = 0; i < 3; i++) {
            float C = utilClass.randomDecimal();
            int z = utilClass.randomInt();
            nominator.nominate(onceNominated.get(i), awardNoSoli);
            Double quantity = (Math.pow(z, 2) * awardNoSoli.getValue() * (1 - (awardNoSoli.getValue()))) / (Math.pow(C, 2)) / (1 + ((((Math.pow(z, 2) * (awardNoSoli.getValue()) * (1 - (awardNoSoli.getValue()))) / (Math.pow(C, 2)))) - 1) / p);
            quantities.add(quantity);
            System.out.println("Without SOLI: nominee = [" + onceNominated.get(i).getName() + "], awardNoSoli = [" + awardNoSoli.getValue() + "], quantity = [" + quantity + "] \n ----------------------------------------------");
        }

    }
}
