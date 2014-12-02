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
    public UniversityModel getUniversityByUsername(String un);
    public ArrayList<UniversityModel> getUniversitesByState(String state);
    //deprecated
    public ArrayList<UniversityModel> getUniversitiesEnrollmentGreater(int enrollment);
    //deprecated
    public ArrayList<UniversityModel> getUniversitiesEnrollmentSmaller(int enrollment);
    
    //TODO: Implement 
    public ArrayList<UniversityModel> getUniversitiesBetween(int lower, int higher);
    public ArrayList<UniversityModel> getUniversitiesByStateAndRange(String state, int lower, int higher);
    
    public ArrayList<UniversityModel> getShowcasedUniversities();
    public int updateUniversity(UniversityModel unit);
    public int addUniversity(UniversityModel univ);
}
