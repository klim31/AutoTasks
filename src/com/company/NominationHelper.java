package com.company;

import com.company.award.Award;
import com.company.nominator.Nominator;
import com.company.nominee.Nominee;


/**
 * Created by Klim_Starykau on 12/21/2017.
 */
public class NominationHelper {
    private double nomineeCurrentAwardsTotal = 0; //Required for  nominateNomineeAwardTotal

    enum MethodName {nominateNominatorAwardTotal, nominateNominatorAwardQuantity, nominateNomineeAwardTotal, nominateNomineeAwardQuantity, all}

    private void nominateWithLimits(Nominee nominee, Nominator nominator, Award award) {
        double nominatorCurrentAwardsTotal = 0;
        int nominatorCurrentAwardsAmount = 0;
        double nomineeCurrentAwardsTotal = 0;
        int nomineeCurrentAwardsAmount = 0;


        for (int i = 0; i < 100; i++) {
            if ((nominatorCurrentAwardsTotal + award.getValue()) <= nominator.getNominatorAwardTotalLimit()) {
                if (nominatorCurrentAwardsAmount < nominator.getNominatorAwardQuantityLimit()) {
                    if ((nomineeCurrentAwardsTotal + award.getValue()) <= nominee.getNomineeAwardTotalLimit()) {
                        if (nominatorCurrentAwardsAmount < nominee.getNomineeAwardQuantityLimit()) {
                            nominator.nominate(nominee, award);
                            nominatorCurrentAwardsTotal += award.getValue();
                            nominatorCurrentAwardsAmount++;
                            nomineeCurrentAwardsTotal += award.getValue();
                            nomineeCurrentAwardsAmount++;
                        } else {
                            System.out.println("Nominee's Award Quantity Limit is reached. Current awards  quantity: [" + nomineeCurrentAwardsAmount + "] and limit is: [" + nominee.getNomineeAwardQuantityLimit() + "]");
                            return;
                        }
                    } else {
                        System.out.println("Nominee's Award Total Limit is reached. Current awards  total: [" + nomineeCurrentAwardsTotal + "] and limit is: [" + nominee.getNomineeAwardTotalLimit() + "]");
                        return;
                    }
                } else {
                    System.out.println("Nominator's Award Amount Limit is reached. Current awards  amount: [" + nominatorCurrentAwardsAmount + "] and limit is: [" + nominator.getNominatorAwardQuantityLimit() + "]");
                    return;
                }
            } else {
                System.out.println("Nominator's Award Total Limit will be exceeded on next nomination. Current awards  total: [" + nominatorCurrentAwardsTotal + "] and limit is: [" + nominator.getNominatorAwardTotalLimit() + "]");
                return;
            }
        }


    }

    private void nominateNominatorAwardTotal(Nominee nominee, Nominator nominator, Award award) {
        double nominatorCurrentAwardsTotal = 0;
        while ((nominatorCurrentAwardsTotal + award.getValue()) < nominator.getNominatorAwardTotalLimit()) {
            nominator.nominate(nominee, award);
            nominatorCurrentAwardsTotal += award.getValue();
        }
        notificator("nominateNominatorAwardTotal");
    }


    private void nominateNominatorAwardQuantity(Nominee nominee, Nominator nominator, Award award) {
        int nominatorCurrentAwardsAmount = 0;
        do {
            nominator.nominate(nominee, award);
            nominatorCurrentAwardsAmount++;
        }
        while (nominatorCurrentAwardsAmount < nominator.getNominatorAwardQuantityLimit());
        notificator("nominateNominatorAwardQuantity");
    }


    private void nominateNomineeAwardTotal(Nominee nominee, Nominator nominator, Award award) {
        while (true) {
            switch ((int) (nomineeCurrentAwardsTotal)) {
                case 350:
                    notificator("nominateNomineeAwardTotal");
                    break;
                default:
                    nominator.nominate(nominee, award);
                    nomineeCurrentAwardsTotal += award.getValue();
                    nominateNomineeAwardTotal(nominee, nominator, award);
            }
            return;
        }
    }


    private void nominateNomineeAwardQuantity(Nominee nominee, Nominator nominator, Award award) {
        int nomineeCurrentAwardsAmount = 0;
        for (int i = 0; nomineeCurrentAwardsAmount < nominee.getNomineeAwardQuantityLimit(); i++) {
            nominator.nominate(nominee, award);
            nomineeCurrentAwardsAmount++;
        }
        notificator("nominateNomineeAwardQuantity");
    }

    public void nominationInitiator(Nominee nominee, Nominator nominator, Award award, MethodName methodName) {
        switch (methodName) {
            case nominateNominatorAwardTotal:
                nominateNominatorAwardTotal(nominee, nominator, award);
                break;
            case nominateNominatorAwardQuantity:
                nominateNominatorAwardQuantity(nominee, nominator, award);
                break;
            case nominateNomineeAwardTotal:
                nominateNomineeAwardTotal(nominee, nominator, award);
                break;
            case nominateNomineeAwardQuantity:
                nominateNomineeAwardQuantity(nominee, nominator, award);
                break;
            case all:
                nominateNominatorAwardTotal(nominee, nominator, award);
                nominateNominatorAwardQuantity(nominee, nominator, award);
                nominateNomineeAwardTotal(nominee, nominator, award);
                nominateNomineeAwardQuantity(nominee, nominator, award);
        }
    }

    private void notificator(String methodName) {
        switch (methodName) {
            case "nominateNominatorAwardTotal":
                System.out.println("Nominator's Award Total Limit will is exceeded.] \n _________________________________________________________________________");
                break;
            case "nominateNominatorAwardQuantity":
                System.out.println("Nominator's Award Amount Limit is reached.] \n _________________________________________________________________________");
                break;
            case "nominateNomineeAwardTotal":
                System.out.println("Nominee's Award Total Limit is reached.] \n _________________________________________________________________________");
                break;
            case "nominateNomineeAwardQuantity":
                System.out.println("Nominee's Award Quantity Limit is reached.] \n _________________________________________________________________________ ");
                break;
        }

    }
}
