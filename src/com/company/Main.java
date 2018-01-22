package com.company;

import com.company.award.Award;
import com.company.nominator.Nominator;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        NominationProcess nominationProcess = new NominationProcess();
        QuantitiesComparator quantitiesComparator = new QuantitiesComparator();
        ArrayList<String> nomineesNames = new ArrayList<String>(Arrays.asList("Klim", "Andrew", "Dmitry", "Pasha", "Tanya", "Ira"));
        Award awardSoli = new Award(100, 0.7);
        Award awardNoSoli = new Award(100);
        Nominator nominator = new Nominator("Gary");
        nominationProcess.massNominateWithSoli(nomineesNames, nominator, awardSoli, awardNoSoli);
        quantitiesComparator.compare(nominationProcess.quantities);
    }
}
