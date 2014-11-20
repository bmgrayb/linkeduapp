/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.UniversityModel;

/**
 *
 * @author brando
 */
public interface UniversityDAO {
    public ArrayList<UniversityModel> getAllUniversities();
    public UniversityModel getUniversityByID(int id);
    public ArrayList<UniversityModel> getUniversitiesEnrollmentGreater(int enrollment);
    public ArrayList<UniversityModel> getUniversitiesEnrollmentSmaller(int enrollment);
    public int addUniversity(UniversityModel univ);
}
