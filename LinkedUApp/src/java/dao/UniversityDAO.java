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
public interface UniversityDAO {
    public ArrayList<University> getAllUniversities();
    public University getUniversityByID(int id);
    public ArrayList<University> getUniversitiesEnrollmentGreater(int enrollment);
    public ArrayList<University> getUniversitiesEnrollmentSmaller(int enrollment);
}
