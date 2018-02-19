package com.company;

import com.company.award.Award;
import com.company.award.AwardService;
import com.company.award.AwardServiceImpl;
import com.company.nominator.Nominator;
import com.company.nominee.Nominee;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        NominationHelper nominationHelper = new NominationHelper();
        AwardService awardService = new AwardServiceImpl();
        Award awardNoSoli = new Award(70);
        Person nominator = new Nominator("Gary", 5, 300, 777, "Staff", "Base privilege", "NominatorPrivilege");
        Person nominee = new Nominee("Klim", 4, 350, 666, "Staff", "Base privilege", "NomineePrivilege");
        nominationHelper.nominationInitiator(nominee, nominator, awardNoSoli);
        nominator.AssingToClient(1);
        nominee.AssingToClient("Qlik");
        List<Award> teamworkAwards = awardService.createAwards(5,"Teamwork");
        List<Award> qualitykAwards = awardService.createAwards(5,"Quality");
        List<Award> determinationAwards = awardService.createAwards(5,"Determination");
        List<Award> awards = new ArrayList<Award>();
        awards.addAll(qualitykAwards);
        awards.addAll(determinationAwards);
        awards.addAll(teamworkAwards);
        awardService.printAwards(awards, "Quality");


    }
}
