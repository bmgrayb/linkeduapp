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
    ArrayList<RecruiterModel> getAllRecruiters();
    RecruiterModel getRecruiterByID(int id);
    public int addRecruiter(RecruiterModel rec);
}
