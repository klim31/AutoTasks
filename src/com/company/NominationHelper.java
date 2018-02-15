package com.company;

import com.company.award.Award;


/**
 * Created by Klim_Starykau on 12/21/2017.
 */
public class NominationHelper {
    private double nomineeCurrentAwardsTotal = 0; //Required for  nominateNomineeAwardTotal

    private void nominateWithLimits(Person nominee, Person nominator, Award award) {
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

    private void nominateNominatorAwardTotal(Person nominee, Person nominator, Award award) {
        double nominatorCurrentAwardsTotal = 0;
        while ((nominatorCurrentAwardsTotal < nominator.getNominatorAwardTotalLimit())) {
            nominator.nominate(nominee, award);
            nominatorCurrentAwardsTotal += award.getValue();
            nominator.isLimitReached(nominatorCurrentAwardsTotal, nominator.getNominatorAwardTotalLimit());
        }
        notificator("nominateNominatorAwardTotal");
    }


    private void nominateNominatorAwardQuantity(Person nominee, Person nominator, Award award) {
        int nominatorCurrentAwardsAmount = 0;
        do {
            nominator.nominate(nominee, award);
            nominatorCurrentAwardsAmount++;
            nominator.isLimitReached(Double.valueOf(nominatorCurrentAwardsAmount), Double.valueOf(nominator.getNominatorAwardQuantityLimit()));
        }
        while (nominatorCurrentAwardsAmount < nominator.getNominatorAwardQuantityLimit());
        notificator("nominateNominatorAwardQuantity");
    }


    private void nominateNomineeAwardTotal(Person nominee, Person nominator, Award award) {
        while (true) {
            switch ((int) (nomineeCurrentAwardsTotal)) {
                case 350:
                    notificator("nominateNomineeAwardTotal");
                    break;
                default:
                    nominator.nominate(nominee, award);
                    nomineeCurrentAwardsTotal += award.getValue();
                    nominee.isLimitReached(nomineeCurrentAwardsTotal, 350);
                    nominateNomineeAwardTotal(nominee, nominator, award);
            }
            return;
        }
    }


    private void nominateNomineeAwardQuantity(Person nominee, Person nominator, Award award) {
        int nomineeCurrentAwardsAmount = 0;
        for (int i = 0; nomineeCurrentAwardsAmount < nominee.getNomineeAwardQuantityLimit(); i++) {
            nominator.nominate(nominee, award);
            nomineeCurrentAwardsAmount++;
            nominee.isLimitReached(nomineeCurrentAwardsAmount, nominee.getNomineeAwardQuantityLimit());
        }
        notificator("nominateNomineeAwardQuantity");
    }

    public void nominationInitiator(Person nominee, Person nominator, Award award) {
        nominateNominatorAwardTotal(nominee, nominator, award);
        nominateNominatorAwardQuantity(nominee, nominator, award);
        nominateNomineeAwardTotal(nominee, nominator, award);
        nominateNomineeAwardQuantity(nominee, nominator, award);
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
