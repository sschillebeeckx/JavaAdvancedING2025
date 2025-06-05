package be.abis.exercise.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class TestDateTime {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        //A
        LocalDate future = today.plusDays(15).plusMonths(2).plusYears(3);
        System.out.println("Future date= "
                + future.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        Period period = Period.of(3, 2, 15);
        LocalDate futureDate = today.plus(period);
        System.out.println("Future date= " + futureDate);

        //B
        LocalDate birthDate = LocalDate.of(1978, 04, 10);
        System.out.println("Je bent geboren op een "
                + birthDate.format(DateTimeFormatter.ofPattern("EEEE",new Locale("nl"))) + ".");

        //ALTERNATIVES
        System.out.println("You are born on a "+ birthDate.getDayOfWeek());
        System.out.println("You are born on a "+ birthDate.getDayOfWeek().getValue());

        String weekDay = birthDate.getDayOfWeek().getDisplayName(TextStyle.FULL,new Locale("nl"));
        System.out.println("Je bent geboren op een " + weekDay + ".");

        //C
        long daysOld = ChronoUnit.DAYS.between(birthDate, today);
        System.out.println("You are " + daysOld + " days old.");

    }
}
