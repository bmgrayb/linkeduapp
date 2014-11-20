/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.StudentModel;

/**
 *
 * @author brando
 */
public interface StudentDAO {
    public ArrayList<StudentModel> getAllStudents();
    public StudentModel getStudentByID(int id);
    public ArrayList<StudentModel> getStudentsWithGreaterGPA(double gpa);
    public int addStudent(StudentModel stu);
}
