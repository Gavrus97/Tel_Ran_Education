import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Homework {
    public static void main(String[] args) {
        LocalDate date = LocalDate.parse("1997-11-08");
        System.out.println(findDayOfBirth(date));
        LocalDate today = LocalDate.of(2022, 11, 3);
        System.out.println(howManyDaysBeforeNewYear(today));
        System.out.println(getDaysBeforeBirthday(today, 11,7));
    }
    // Узнать день недели, в котором вы родились
    public static String findDayOfBirth(LocalDate date){
        return date.getDayOfWeek().toString();
    }

    // Узнать количество дней до нового года, при условии, что нельзя явно указывать год.
    public static int howManyDaysBeforeNewYear(LocalDate date){
        int year = LocalDate.now().getYear();
        LocalDate nextNewYear = LocalDate.of(year, 12,31);
        return (int)ChronoUnit.DAYS.between(date, nextNewYear);
    }

    // Узнать количество дней до дня рождения, при уловии, что дан только день рождения без года.
    public static int getDaysBeforeBirthday(LocalDate date, int monthOfBirth, int dayOfBirth){
        LocalDate birthday = LocalDate.of(date.getYear(), monthOfBirth, dayOfBirth);
        if(date.isBefore(birthday))
            return (int)ChronoUnit.DAYS.between(date, birthday);
        else
            return (int)ChronoUnit.DAYS.between(date, birthday.plusYears(1));
    }

}
