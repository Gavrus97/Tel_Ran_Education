import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Main {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now(); //с моего компа
        LocalDate myBirthday = LocalDate.parse("1985-08-01");//("yyyy-mm-dd")
        LocalDate fromYMD = LocalDate.of(2011, 8, 18);

        System.out.println(today);
        System.out.println(myBirthday);
        System.out.println(fromYMD);

        // можно складывать/вычитать временные периоды
        LocalDate tomorrow = today.plusDays(1);
        System.out.println(tomorrow);
        LocalDate todayNextMonth = today.plusMonths(1);
        System.out.println(todayNextMonth);

        System.out.println(today.plus(37, ChronoUnit.DAYS)); //день, месяц, год, декада, век ...

        //можно доставать различнуб информацию о дате типа день недели и т.п.
        System.out.println(today.getDayOfWeek());// wednesday
        System.out.println(today.getDayOfWeek().getValue()); //3

        //можнл сравнивать две даты на больше меньше (isAfter, isBefore)
        System.out.println(today.isBefore(tomorrow));//true
        System.out.println(tomorrow.isAfter(today));//true

        //метод with получает получить инную дату на основе текущей
        System.out.println(today.with(TemporalAdjusters.firstDayOfMonth()));

        //LocalTime
        // создать объект localTime
        LocalTime currentTime = LocalTime.now(); //11:08:42.373681
        System.out.println(currentTime);
        LocalTime lessonStart = LocalTime.of(9, 30);

        System.out.println(LocalTime.of(9, 30));

        // можно складывать/вычитать временные периоды
        System.out.println(currentTime.plus(1, ChronoUnit.HOURS));

        //различные геттеры getters
        System.out.println(currentTime.getHour());

        //сравнивать isBefore/isAfter
        System.out.println(currentTime.isBefore(lessonStart));// false

        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);

        //LocalDateTime - совмещает в себе все возможности LocalDate и LocalTime
        LocalDateTime combinedNow = LocalDateTime.of(today, currentTime);
        System.out.println(combinedNow);//2022-04-06T11:21:59.149732
        LocalDateTime parsedLocalDateTime = LocalDateTime.parse("1985-08-01T01:00");// не забыввать букву T
        System.out.println(parsedLocalDateTime);


        // ZonedDateTime - объект несущий в сеье информацию о дате и времени с привязкой к часовому поясу
        ZonedDateTime nowZonedBerlin = ZonedDateTime.of(combinedNow, ZoneId.of("Europe/Berlin"));//2022-04-06T11:29:08.140151+02:00[Europe/Berlin]
        System.out.println(nowZonedBerlin);

        //чтобы узнать о доступных zoneId можно распечатать ZoneId.getAvailableZoneIds()
        System.out.println(ZoneId.getAvailableZoneIds());

        //перевод часов
        ZonedDateTime nowZonedNewYork = nowZonedBerlin.withZoneSameInstant(ZoneId.of("US/Eastern"));//переводит время в другой часосовй пояс
        System.out.println(nowZonedNewYork);

        //подмена зоны
        System.out.println(nowZonedBerlin.withZoneSameLocal(ZoneId.of("US/Eastern")));//время тоже зона другая

        // Instant - обертка над Current time millis
        ZonedDateTime.ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), ZoneId.of("US/Eastern"));

        //Period - класс, описывающий временные периоды для работы с датами. Периоды описываюся в виде
        //годаб месяцы, дни
        System.out.println(today.plus(Period.ofDays(15)));
        Period period = Period.between(myBirthday, today);
        System.out.println(period);//P36Y8M5D
        System.out.println(period.getDays());//5
        System.out.println(period.getMonths());//8
        System.out.println(period.getYears());//36

        //количество дней между датами
        System.out.println(ChronoUnit.DAYS.between(myBirthday, today));//13397
        System.out.println(ChronoUnit.DAYS.between(today, myBirthday));//-13397

        //duration - class описывающий временные периоды для работы с временем
        Duration fromStart = Duration.between(currentTime, lessonStart);
        System.out.println(fromStart);
        System.out.println(fromStart.getSeconds());

        //форматирование DateTimeFormatter - class описывающий правило для перевода времени и даты в строку
        // и обратно

        DateTimeFormatter slashFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        //вместо yyyy-mm-dd будет yyyy/mm/dd
        //localDate to string
        System.out.println(slashFormatter.format(today));
        //String to localDate
        LocalDate fromSlashFormatter = LocalDate.parse("2022/06/06", slashFormatter);
        System.out.println(fromSlashFormatter);


        // форматирлвание даты с помощью форматтера
        DateTimeFormatter macFormatter = DateTimeFormatter.ofPattern("EE d MMM");
        System.out.println(macFormatter.format(today));
    }
}
