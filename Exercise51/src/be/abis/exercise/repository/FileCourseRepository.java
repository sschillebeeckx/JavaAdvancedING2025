package be.abis.exercise.repository;

import be.abis.exercise.model.Course;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class FileCourseRepository implements CourseRepository {

    private List<Course> courses = new ArrayList<Course>();

    public FileCourseRepository()  {

    }

    @Override
    public List<Course> findAllCourses() {
        return courses;
    }

    @Override
    public void addCourse(Course c) {

    }

    @Override
    public void printAllCourses() {

    }

    public Course parseCourse(String s){
        String[] vals = s.split(";");
        String title = vals[0];
        int days = Integer.parseInt(vals[1]);
        double price = Double.parseDouble(vals[2]);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        LocalDate released = LocalDate.parse(vals[3],dtf);
        Course c = new Course(title,days,price,released);
        return c;
    }


}
