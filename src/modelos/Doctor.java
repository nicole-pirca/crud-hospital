package modelos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Doctor extends User {
    private String especialidad;
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public Doctor(String name, String email) {
        super(name, email);
        System.out.println("El nombre del Doctor asignado es: " + name);
        this.especialidad = especialidad;
    }


    public void addAvailableAppointment(String date, String time) throws ParseException {
        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }
    @Override
    public void showDataUser() {
        System.out.println("Hospital el Seguro");
        System.out.println("Hospital La Maternidad");
    }
    public static class AvailableAppointment {
        private int id;
        private Date date;
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        public AvailableAppointment(String date, String time) throws ParseException {
            this.date = format.parse(date);
            this.time = time;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {
            return date;
        }
        public String getDate(){
            return format.format(date);
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public String toString() {
            return "AvailableAppointment \nDate: " + date + "\nTime: " + time;
        }
    }


}
