import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Medico {
    private String nombre;
    private String apellido;
    private int rm;     //número de registro médico (RM).
    private ArrayList<Cita> mallaDeCitas;

    public Medico(String nombre, String apellido, int rm) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rm = rm;
        this.mallaDeCitas = new ArrayList<>();
    }
    
    public boolean verificarDisponibilidad(Cita cita) {
        if (cita.getdisponibilidad()) {            //verifica la disponibilidad de la cita seleccionada por el usuario
            return true;
        } else {
            return false;
        }
    }
    
    public void agregarEnMalla(Cita cita) {
            mallaDeCitas.add(cita);
    }

    public boolean cancelarCita(Cita cita) {
        for (Cita c : mallaDeCitas) {
            if (c.equals(cita)) {           //al cancelar una cita vuelve y setea su disponibilidad a verdadero
                c.setdisponibilidad(true);
                c.setPaciente(null);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Cita> getMallaDeCitas() {
        return mallaDeCitas;
    }

    public void showMallaDeCitas() {
        StringBuilder citasString = new StringBuilder();
        for (Cita cita : mallaDeCitas) {
            Paciente paciente = cita.getPaciente();
            String nombrePaciente = (paciente != null) ? paciente.getNombre() : "Sin paciente asignado";        //imprime la lista de citas disponibles del medico
            citasString.append("Fecha: ").append(cita.getFechaSolicitud()).append(", Hora: ")
                       .append(cita.getHora_inicio()).append(" - ").append(cita.getHora_fin())
                       .append(", Consultorio: ").append(cita.getNumeroConsultorio())
                       .append(", Paciente: ").append(nombrePaciente).append("\n");
        }
        JOptionPane.showMessageDialog(null, "Citas con el Doctor "+ getApellido()+ "\n" + citasString.toString(),
                                      "Citas", JOptionPane.INFORMATION_MESSAGE);
    }

    public Cita getCitaPorPosicion(int posicion) {
        if (posicion >= 0 || posicion < mallaDeCitas.size()) {
            Cita cita = mallaDeCitas.get(posicion-1);
            return cita;
        }else{
            return null;
        }
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }


    public int getRm() {
        return rm;
    }


}
