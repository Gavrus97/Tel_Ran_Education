package de.telran;

public class Main {

    public static void main(String[] args) {

	    LoanUser youngUser = new LoanUser("Vasja", "Vasin", 25, 40000);
        LoanIssuer lazyAndKindIssuer = new LoanIssuer("Maria", "Petrova", true, true);
        System.out.println(lazyAndKindIssuer.toProvide(youngUser));

        LoanUser prettyOldUserWithGoodSalary = new LoanUser("Oleg", "Petrov", 70, 20000);
        LoanIssuer hardworkingAndKindIssuer = new LoanIssuer("Olga", "Ivanova", false,true);
        System.out.println(hardworkingAndKindIssuer.toProvide(prettyOldUserWithGoodSalary));

        LoanUser middleYearsIssuerWithGoodSalary = new LoanUser("Petja", "Petrov", 45, 23000);
        LoanIssuer hardworkingAndAngryIssuer = new LoanIssuer("Kolia", "Pupkin", false,false);
        System.out.println(hardworkingAndAngryIssuer.toProvide(middleYearsIssuerWithGoodSalary));

        LoanUser tooOldUser = new LoanUser("Konstantin", "Nikitin", 71, 25000);
        System.out.println(hardworkingAndKindIssuer.toProvide(tooOldUser));

    }
}
