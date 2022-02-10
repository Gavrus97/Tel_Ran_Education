package de.telran;

public class Human {

    private static int humanNumber = 0;
    private static double averageAge = 0;

    private String name;
    private String surname;     //тогда в main нельзя будет просто так поменять
    private int age;
    private String email;
    private boolean isAlive = true;




    public Human(String specifiedName, String specifiedSurname, int specifiedAge){  //Конструктор
        name = specifiedName;
        surname=specifiedSurname;
        age=specifiedAge;

        averageAge = (averageAge * humanNumber + age)/(humanNumber+1);
        humanNumber++; //increment
    }


    public Human(String specifiedName, String specifiedSurname, int spcifiedAge, String email){
       this(specifiedName,specifiedSurname,spcifiedAge);
       this.email=email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public static int getHumanNumber() {
        return humanNumber;
    }

    public static int getAverageAge(){
        return (int) averageAge;
    }

    public String getName(){        //Getter чтобы можно было смотреть в main значение переменной (control и enter нажать)
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public void die() {
        if(isAlive)
        introduce();
        averageAge = (averageAge * humanNumber - age) / (--humanNumber);
    }



    public void introduce(){    //Метод для представления(каждый человек может сеья представить )

        if(!isAlive)
            System.out.println(name + " " + surname + " " + "R.I.P.");
        else if (age < 50)
            System.out.println("Hi, my name is " + name +" "+ surname + " . I'm " + age+ " years old.");
        else
            System.out.println("Hello my name is " + name +" "+ surname + " . I'm " + age+ " years old.");


    }

}






