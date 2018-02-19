package com.company.award;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Klim_Starykau on 2/19/2018.
 */
public class AwardServiceImpl implements AwardService {

    @Override
    public ArrayList<Award> createAwards(int count, String type) {
        ArrayList<Award> awards = new ArrayList<Award>();
        for (Long i = 1L; i < count; i++) {
            awards.add(new Award(i, type));
        }
        return awards;
    }

    @Override
    public void printAwards(List<Award> awards, String type) {
        ArrayList<Award> awardsQuality = new ArrayList<Award>();
        for (Award award : awards) {
            if (award.getType() == type) { // TODO: 2/19/2018 Equals , == difference
                awardsQuality.add(award);
            }
        }
        System.out.println("awards = [" + awards + "]");
        System.out.println("Resulting collection of Quality awards = [" + awardsQuality + "]");
        HashSet<Award> distinctSet = new HashSet<Award>();
        distinctSet.addAll(awards);
        System.out.println("Resulting Set of distinct awards = [" + distinctSet + "]");
    }
}
