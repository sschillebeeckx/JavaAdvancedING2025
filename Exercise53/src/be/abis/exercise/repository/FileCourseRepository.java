package be.abis.exercise.repository;

import be.abis.exercise.model.Course;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileCourseRepository implements CourseRepository {

    private List<Course> courses = new ArrayList<Course>();
    private String fileLocation = "/temp/javacourses/courses.csv";

    public FileCourseRepository() throws IOException {
         this.readFile();
    }

    public void readFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileLocation));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            Course c = this.parseCourse(line);
            this.courses.add(c);
        }
        bufferedReader.close();

        /*
        courses = Files.lines(Paths.get(fileLocation))
                .map(line->this.parseCourse(line))
                .collect(Collectors.toList());

         */
    }

    @Override
    public List<Course> findAllCourses() {
        return courses;
    }

    @Override
    public void addCourse(Course c) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(fileLocation), StandardCharsets.UTF_8, StandardOpenOption.APPEND)) {
            bw.newLine();
            bw.write( CourseRepository.formatCourse(c));
            courses.add(c);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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
