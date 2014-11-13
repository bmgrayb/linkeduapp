/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author brando
 */
public interface AppointmentDAO {
    public ArrayList<Appointment> getAllAppointments();
    public ArrayList<Appointment> getUniversityAppointments();
    public ArrayList<Appointment> getStudentAppointments();
    public Appointment getAppointment(int studentID, int universityID, Date date);
}
