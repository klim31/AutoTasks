package com.company;

/**
 * Created by Klim_Starykau on 12/13/2017.
 */
public class Phrases {

    String passPhrase1 = "We make work HUMAN.";
    String passPhrase2 = "Unlock full potential. Celebrate positive moments.";
    String passPhrase3 = "Every day.";
    String globoPhrase = "Globoforce";



    public void textListing() {
        System.out.println(passPhrase1 + "\n" + passPhrase2 + "\n" + passPhrase3);
        int length = passPhrase2.length();
        System.out.println("2nd line length is: " + passPhrase2.length());
        System.out.println("Low register transformation:\n " + passPhrase1.toLowerCase() + "\n" + passPhrase2.toLowerCase() + "\n" + passPhrase3.toLowerCase() );
        String combinedString =  passPhrase1.toLowerCase() + "\n" + passPhrase2.toLowerCase() + "\n" + passPhrase3.toLowerCase();
        String combinedSrtingE = combinedString.replace('e','E');
        System.out.println(" e -> E : " + "\n" + combinedSrtingE );
    }

    public void globoArray() {
        char [] globoarray = globoPhrase.toCharArray();
        System.out.println("Array size: " + globoarray.length);
        for (int i = 0; i < globoarray.length ; i++) {
            if (globoarray [i] == 'b')
                globoarray [i] = '$';
        }
        System.out.println("New string is: " + String.valueOf(globoarray));


    }

}
