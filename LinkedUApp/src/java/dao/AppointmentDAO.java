/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.sql.Date;
import model.AppointmentModel;

/**
 *
 * @author brando
 */
public interface AppointmentDAO {
    public ArrayList<AppointmentModel> getAllAppointments();
    public ArrayList<AppointmentModel> getUniversityAppointments(int univID);
    public ArrayList<AppointmentModel> getStudentAppointments(int stuID);
    public AppointmentModel getAppointment(int studentID, int universityID, Date date);
    public int addAppointment(AppointmentModel appt);
}
