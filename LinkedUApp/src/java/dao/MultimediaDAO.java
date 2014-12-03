/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.MultimediaModel;

/**
 *
 * @author brando
 */
public interface MultimediaDAO {
    public ArrayList<MultimediaModel> getAllURL();
    public MultimediaModel getURLByID(int studentID);
    public int updateMultimedia(MultimediaModel mult);
    public int addMultimedia(MultimediaModel mult);
}
