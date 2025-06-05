package be.abis.exercise.repository;

import be.abis.exercise.model.Course;
import be.abis.exercise.repository.CourseRepository;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class MemoryCourseRepository implements CourseRepository {

    private List<Course> courses = new ArrayList<>();

    public MemoryCourseRepository(){
        courses.add(new Course("DB2, an overview",5,550.0, LocalDate.of(1986,4,30)));
        courses.add(new Course("Workshop SQL",2,475.0, LocalDate.of(1990,1,9)));
        courses.add(new Course("Java Programming",5,500.0, LocalDate.of(1997,5,27)));
        courses.add(new Course("Maven",1,450.0, LocalDate.of(2007,6,11)));
        courses.add(new Course("Programming with Spring",3,525.0, LocalDate.of(2008,3,21)));

    }

    @Override
    public List<Course> findAllCourses() {
        return courses;
    }

    @Override
    public void addCourse(Course c) {
        courses.add(c);
    }

    @Override
    public void printAllCourses() {

        //System.out.println( "─".repeat(70));
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%40s\n", "Course Overview");
        System.out.println("---------------------------------------------------------------------");
        System.out.printf("%-30s %-25s %-25s \n", "Course Title", "Total Price with VAT", "Release Date");
        System.out.println("---------------------------------------------------------------------");
        //courses.sort((c1,c2)->(int)((c1.calculatePriceWithVAT()-c2.calculatePriceWithVAT())*100));
        courses.sort(Comparator.comparingDouble(Course::calculatePriceWithVAT));
        for (Course c : courses) {
            double totalPrice = c.calculatePriceWithVAT();

            NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("nl", "BE"));
            //nf.setMaximumFractionDigits(2);
            nf.setGroupingUsed(false);
            String formattedNumber = nf.format(totalPrice).replaceAll("\u00A0", "");

            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM dd, yyyy");

            System.out.printf("%-30s %-25s %-25s \n", c.getTitle(), formattedNumber, c.getReleaseDate().format(dtf));

        }
    }

}
