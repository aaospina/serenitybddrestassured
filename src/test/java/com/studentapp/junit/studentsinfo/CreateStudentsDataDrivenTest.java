package com.studentapp.junit.studentsinfo;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.testbase.TestBase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;

@UseTestDataFrom("testdata/studentinfo.csv")
@RunWith(SerenityParameterizedRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateStudentsDataDrivenTest extends TestBase {

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public String getCourses() {
        return course;
    }

    public void setCourses(String courses) {
        this.course = courses;
    }

    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private String course;

    @Steps
    StudentSerenitySteps steps;

    @Title("Data Driven Test for adding multiple students to the Student app")
    @Test
    public void test001(){

        ArrayList<String> courses = new ArrayList<>();
        courses.add(course);

        steps.createStudent(firstName, lastName, email, programme, courses)
                .statusCode(201);

    }

    @Test
    public void test002(){
        System.out.println("holi");
    }
}
