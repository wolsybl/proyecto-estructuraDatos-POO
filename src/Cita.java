import java.time.LocalDate;
import java.time.LocalTime;

public class Cita {
    private LocalDate fechaSolicitud;
    private LocalTime hora_inicio;
    private LocalTime hora_fin;
    private int numeroConsultorio;
    private Medico medicoAsignado;
    private String nombrePaciente;
    private Integer documentoPaciente;
    private boolean disponibilidad;
    private Paciente paciente;

    public Cita(LocalDate fechaSolicitud, LocalTime hora_inicio, LocalTime hora_fin , int numeroConsultorio, Medico medicoAsignado) {
        this.fechaSolicitud = fechaSolicitud;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.numeroConsultorio = numeroConsultorio;
        this.medicoAsignado = medicoAsignado;           //la informacion del paciente se declara nula puesto que las citas las tendran los medicos almacenada para que el paciente elija cual solicitar
        this.paciente = null;
        this.nombrePaciente = null;
        this.documentoPaciente = null;
        this.disponibilidad = true;
    }

    public boolean getdisponibilidad() {
        return disponibilidad;
    }

    public void setdisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
        if (paciente == null) {
            this.nombrePaciente = null;
            this.documentoPaciente = null;
        }else{
            this.nombrePaciente = paciente.getNombre();             //una vez se agende la cita la informacion del paciente sera seteada a la del paciente que agendo la cita
            this.documentoPaciente = paciente.getIdentificacion();
        }
        
    }
    public Paciente getPaciente(){
        return paciente;
    }
    public LocalDate getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(LocalDate fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }


    public LocalTime getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(LocalTime hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public LocalTime getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(LocalTime hora_fin) {
        this.hora_fin = hora_fin;
    }

    public int getNumeroConsultorio() {
        return numeroConsultorio;
    }

    public void setNumeroConsultorio(int numeroConsultorio) {
        this.numeroConsultorio = numeroConsultorio;
    }

    public Medico getMedicoAsignado() {
        return medicoAsignado;
    }

    public void setMedicoAsignado(Medico medicoAsignado) {
        this.medicoAsignado = medicoAsignado;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public Integer getDocumentoPaciente() {
        return documentoPaciente;
    }

        // convierte la fecha y la hora de una cita a valor numerito para enviarselo al Radix sort
    public long toNumericValue() {
        return fechaSolicitud.toEpochDay() * 24 * 60 + hora_inicio.toSecondOfDay() / 60;
    }
}