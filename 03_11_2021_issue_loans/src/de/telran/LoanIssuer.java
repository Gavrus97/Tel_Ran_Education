package de.telran;

public class LoanIssuer {
    String name;
    String surname;
    boolean isLazy;
    boolean isKind;

    public LoanIssuer(String name, String surname, boolean isLazy, boolean isKind) {
        this.name = name;
        this.surname = surname;
        this.isLazy = isLazy;
        this.isKind = isKind;
    }
    public boolean toProvide(LoanUser user){
        if (isLazy && user.annualSalary >=20000)
            return true;
        if(!isLazy && isKind && user.annualSalary>=20000 && user.age<=70)
            return true;
        if(!isLazy && !isKind && user.annualSalary>=20000 && user.age <=50)
            return true;
     return false;
    }

}
