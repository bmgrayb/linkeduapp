/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author brando
 */
public interface StudentDAO {
    public ArrayList<Student> getAllStudents();
    public Student getStudentByID(int id);
    public ArrayList<Student> getStudentsWithGreaterGPA(double gpa);
}
