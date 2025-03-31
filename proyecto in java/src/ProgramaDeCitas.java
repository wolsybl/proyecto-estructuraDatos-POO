import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;

public class ProgramaDeCitas{
    private Queue<Cita> colaDeCitas;        //se agregan los medicos como atributos del programa de citas
    private Medico medico1;
    private Medico medico2;

    public ProgramaDeCitas() {          //dentro del constructor del programa de citas se declaran los datos y la malla de cita de cada medico para ser posible usar esta informacion en metodo menu sin crear una lista cada que se llama al menu
        this.colaDeCitas = new LinkedList<>();
        this.medico1 = new Medico("Juan", "Pérez", 1234);         //se instancian dos medicos y a cada uno se le agregan 4 horarios disponibles para que el paciente pueda elegir que cita agendar
        medico1.agregarEnMalla(new Cita(LocalDate.of(2024, 6, 3), LocalTime.of(14, 0), LocalTime.of(16, 0), 23, medico1));
        medico1.agregarEnMalla(new Cita(LocalDate.of(2024, 6, 4), LocalTime.of(16, 0), LocalTime.of(18, 0), 14, medico1));      //las citas se crean en formato fecha, hora de inicio, hora de fin, consultorio y medico asignado
        medico1.agregarEnMalla(new Cita(LocalDate.of(2024, 6, 5), LocalTime.of(12, 0), LocalTime.of(14, 0), 7, medico1));
        medico1.agregarEnMalla(new Cita(LocalDate.of(2024, 6, 7), LocalTime.of(14, 30), LocalTime.of(16, 30), 10, medico1));
        this.medico2 = new Medico("María", "González", 5678);
        medico2.agregarEnMalla(new Cita(LocalDate.of(2024, 6, 3), LocalTime.of(8, 0), LocalTime.of(10, 0), 5, medico2));
        medico2.agregarEnMalla(new Cita(LocalDate.of(2024, 6, 5), LocalTime.of(6, 30), LocalTime.of(8, 30), 9, medico2));
        medico2.agregarEnMalla(new Cita(LocalDate.of(2024, 6, 7), LocalTime.of(7, 0), LocalTime.of(9, 0), 21, medico2));
        medico2.agregarEnMalla(new Cita(LocalDate.of(2024, 6, 4), LocalTime.of(9, 0), LocalTime.of(11, 0), 7, medico2));
    }

    public void menu(Paciente paciente){
                // Ordenar las citas de cada médico
                ordenarCitas(medico1);
                ordenarCitas(medico2);
        
        String[] botones2 = {"Ver Citas Disponibles", "volver"};
                            int opcion2 = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Sistema de Pacientes",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones2, botones2[0]);
                                if (opcion2 == 0) {
                                    String opcion3;
                                    opcion3 = (String) JOptionPane.showInputDialog(
                                            null,
                                            "En que horario desea agendar:\n" +
                                                    "1. Mañana\n" +
                                                    "2. Tarde\n",
                                            "Menú principal",
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,
                                            new Object[]{"Mañana", "Tarde"},
                                            "Mañana"
                                    );
                                    
                                    if (opcion3 == null) {
                                        return;
                                    }
                                    switch (opcion3) {
                                        case "Mañana":
                                            boolean citaValida = false;
                                            while (!citaValida) {
                                                StringBuilder citasString = new StringBuilder();
                                                int index = 1;
                                                for (Cita cita : medico2.getMallaDeCitas()) {
                                                    Paciente paciente2 = cita.getPaciente();
                                                    String nombrePaciente = (paciente2!= null)? paciente2.getNombre() : "Sin paciente asignado";              //imprime la lista de citas disponibles del medico
                                                    citasString.append(index++).append(". Fecha: ").append(cita.getFechaSolicitud()).append(", Hora: ")
                                                        .append(cita.getHora_inicio()).append(" - ").append(cita.getHora_fin())
                                                        .append(", Consultorio: ").append(cita.getNumeroConsultorio())
                                                        .append(", Paciente: ").append(nombrePaciente).append("\n");
                                                }
                                                String input = JOptionPane.showInputDialog(null, "Citas con Medico " + medico2.getApellido() + "\n" + citasString.toString(), "Elija una cita a agendar");
                                                if (input == null) {
                                                    break; // El usuario presionó Cancelar
                                                } else {
                                                    try {
                                                        int citaElegida = Integer.parseInt(input);
                                                        if (citaElegida > 0 && citaElegida <= medico2.getMallaDeCitas().size()) {
                                                            agendarCita(medico2.getCitaPorPosicion(citaElegida), paciente);
                                                            citaValida = true;
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "No existe esa cita", null, JOptionPane.INFORMATION_MESSAGE);
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        JOptionPane.showMessageDialog(null, "Por favor ingrese un número", null, JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                }
                                            }
                                            mostrarColaDeCitas();
                                            break;
                                        case "Tarde":
                                            boolean citaValida2 = false;
                                            while (!citaValida2) {
                                                StringBuilder citasString2 = new StringBuilder();
                                                int index2 = 1;
                                                for (Cita cita : medico1.getMallaDeCitas()) {
                                                    Paciente paciente2 = cita.getPaciente();
                                                    String nombrePaciente = (paciente2!= null)? paciente2.getNombre() : "Sin paciente asignado";              //imprime la lista de citas disponibles del medico
                                                    citasString2.append(index2++).append(". Fecha: ").append(cita.getFechaSolicitud()).append(", Hora: ")
                                                        .append(cita.getHora_inicio()).append(" - ").append(cita.getHora_fin())
                                                        .append(", Consultorio: ").append(cita.getNumeroConsultorio())
                                                        .append(", Paciente: ").append(nombrePaciente).append("\n");
                                                }
                                                String input = JOptionPane.showInputDialog(null, "Citas con Medico " + medico1.getApellido() + "\n" + citasString2.toString(), "Elija una cita a agendar");
                                                if (input == null) {
                                                    break; // El usuario presionó Cancelar
                                                } else {
                                                    try {
                                                        int citaElegida2 = Integer.parseInt(input);
                                                        if (citaElegida2 > 0 && citaElegida2 <= medico1.getMallaDeCitas().size()) {
                                                            agendarCita(medico1.getCitaPorPosicion(citaElegida2), paciente);
                                                            citaValida2 = true;
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "No existe esa cita", null, JOptionPane.INFORMATION_MESSAGE);
                                                        }
                                                    } catch (NumberFormatException e) {
                                                        JOptionPane.showMessageDialog(null, "Por favor ingrese un número", null, JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                }
                                            }
                                            mostrarColaDeCitas();
                                            break;
                                        default:
                                            break;
                                    }
                                }
    }
    // este metodo llama el algortimo Radix sort en las listas de citas del medico
    public void ordenarCitas(Medico medico) {
        RadixSort.radixsort(medico.getMallaDeCitas());
    }

    public void agendarCita(Cita cita, Paciente paciente) {
        if (paciente.getCita2()==null) {
            if (cita.getMedicoAsignado().verificarDisponibilidad(cita)) {       //se recibe la cita elegida por el paciente y el paciente que la eligio, luego verifica la disponibilidad de la cita con un metodo del medico asignado
                cita.setPaciente(paciente);
                cita.setdisponibilidad(false);
                colaDeCitas.add(cita);              //si la cita esta disponible, se asigna ese paciente a la cita y la cita se agrega a la lista enlazada de todas las citas programadas y se setea la disponibilidad de la cita a false
                paciente.setCita(cita);
                JOptionPane.showMessageDialog(null, "Cita asignada con éxito", null, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No hay disponibilidad para asignar la cita", null, JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ya tiene una cita agendada", null, JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean cancelarCita(Cita cita, Paciente paciente) {
        if (cita.getMedicoAsignado().cancelarCita(cita)) {          //verifica que el medico asignado tenga dicha cita para cancelarla
            cita.setPaciente(null);
            colaDeCitas.remove(cita);
            paciente.setCita(null);
            return true;    //si la tiene la cancela y si no la tiene no puede cancelar alg que no esta en su poder
        } else {
            return false;
        }
    }

    public void mostrarColaDeCitas() {          //con un ciclo for imprime dato por dato todas las citas agendadas por todos los pacientes
        for (Cita cita : colaDeCitas) {
            JOptionPane.showMessageDialog(null, "Fecha de solicitud: "+ cita.getFechaSolicitud()+
            "\nFecha de programación: " + cita.getFechaSolicitud()+
            "\nHora de asignación: " + cita.getHora_inicio()+ " hasta "+ cita.getHora_fin()+
            "\nNúmero de consultorio: " + cita.getNumeroConsultorio()+
            "\nMédico asignado: " + cita.getMedicoAsignado().getNombre() + " " + cita.getMedicoAsignado().getApellido()+
            "\nNombre del paciente: " + cita.getNombrePaciente()+
            "\nDocumento del paciente: " + cita.getDocumentoPaciente()+
            "\nEstado: " + cita.getdisponibilidad(), null, JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
