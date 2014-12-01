/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.RecruiterModel;

/**
 *
 * @author brando
 */
public interface RecruiterDAO {
    public ArrayList<RecruiterModel> getAllRecruiters();
    public RecruiterModel getRecruiterByID(int id);
    public RecruiterModel getRecruiterByUsername(String username);
    public int updateRecruiter(RecruiterModel rec);
    public int addRecruiter(RecruiterModel rec);
}
