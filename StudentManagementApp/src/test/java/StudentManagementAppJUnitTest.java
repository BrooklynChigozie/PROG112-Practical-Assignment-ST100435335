/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
/**
 *
 * @author brook
 */


public class StudentManagementAppTest {
    private ArrayList<Student> students;

    @Before
    public void setUp() {
        students = new ArrayList<>();
    }

    @Test
    public void TestSaveStudent() {
        Student student = new Student("101", "John Doe", 20, "john.doe@example.com", "Computer Science");
        students.add(student);
        assertEquals(1, students.size());
        assertEquals("John Doe", students.get(0).getName());
    }

    @Test
    public void TestSearchStudent() {
        Student student = new Student("101", "John Doe", 20, "john.doe@example.com", "Computer Science");
        students.add(student);
        Student foundStudent = searchStudent("101");
        assertNotNull(foundStudent);
        assertEquals("John Doe", foundStudent.getName());
    }

    @Test
    public void TestSearch_StudentNotFound() {
        Student foundStudent = searchStudent("999");
        assertNull(foundStudent);
    }

    @Test
    public void TestDeleteStudent() {
        Student student = new Student("101", "John Doe", 20, "john.doe@example.com", "Computer Science");
        students.add(student);
        boolean isDeleted = deleteStudent("101");
        assertTrue(isDeleted);
        assertEquals(0, students.size());
    }

    @Test
    public void TestDeleteStudent_StudentNotFound() {
        boolean isDeleted = deleteStudent("999");
        assertFalse(isDeleted);
    }

    @Test
    public void TestStudentAge_StudentAgeValid() {
        boolean isValid = isValidAge(20);
        assertTrue(isValid);
    }

    @Test
    public void TestStudentAge_StudentAgeInvalid() {
        boolean isValid = isValidAge(15);
        assertFalse(isValid);
    }

    @Test(expected = NumberFormatException.class)
    public void TestStudentAge_StudentAgeInvalidCharacter() {
        isValidAge(Integer.parseInt("abc"));
    }

    private Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private boolean deleteStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    private boolean isValidAge(int age) {
        return age >= 16;
    }
}
