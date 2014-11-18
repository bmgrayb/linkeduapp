/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Date;
import model.AppointmentModel;

/**
 *
 * @author brando
 */
public interface AppointmentDAO {
    public ArrayList<AppointmentModel> getAllAppointments();
    public ArrayList<AppointmentModel> getUniversityAppointments();
    public ArrayList<AppointmentModel> getStudentAppointments();
    public AppointmentModel getAppointment(int studentID, int universityID, Date date);
}
