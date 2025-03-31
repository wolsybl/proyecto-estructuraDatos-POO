import javax.swing.JOptionPane;
public class Paciente {
    
    private String edad;
    private String nombre;
    private Integer identificacion;
    private String genero;
    private String tipoPaciente;
    private Cita citaAsignada;
    private String contraseña;

    protected Paciente(){
        this.edad = null;
        this.nombre = null;
        this.identificacion = null;
        this.genero = null;
        this.tipoPaciente = null;
        this.citaAsignada = null;
        this.contraseña = null;
    }

    protected Paciente(String edad, String nombre, Integer identificacion, String genero, String contraseña) {
        this.edad = edad;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.genero = genero;
        this.contraseña = contraseña;
    }

    //metodos getters

    protected String getEdad() {return edad;}
    protected String getNombre() {return nombre;}
    protected Integer getIdentificacion() {return identificacion;}
    protected String getGenero() {return genero;}
    protected String getTipoPaciente() {return tipoPaciente;}
    protected Cita getCita2() {return citaAsignada;}
    protected String getCita() {
        if (citaAsignada!=null) {
            String citaPaciente = "fecha: "+ citaAsignada.getFechaSolicitud()+ 
            " Hora de inicio: "+ citaAsignada.getHora_inicio()+ 
            " Hora fin: "+ citaAsignada.getHora_fin()+ 
            " medico: "+ citaAsignada.getMedicoAsignado().getNombre()+
            " consultorio: "+ citaAsignada.getNumeroConsultorio();
            return citaPaciente;
        }else{
            return "Sin cita agendada";
        }
        
    }
    protected String getContraseña() {return contraseña;}

    //metodos setters

    protected void setEdad(String edad) {this.edad = edad;}
    protected void setNombre(String nombre) {this.nombre = nombre;}
    protected void setIdentificacion(Integer identificacion) {this.identificacion = identificacion;}
    protected void setGenero(String genero) {this.genero = genero;}
    protected void setTipoPaciente(String tipoPaciente) {this.tipoPaciente = tipoPaciente;}
    protected void setCita(Cita cita) {this.citaAsignada = cita;}
    protected void setContraseña(String contraseña) {this.contraseña = contraseña;}

    protected void imprimir(){
        JOptionPane.showMessageDialog(null, "Los datos del paciente son: \nNombre: " + getNombre() +
                                                                        "\nEdad: " + getEdad() +
                                                                        "\nDocumento: " + getIdentificacion() +
                                                                        "\nGenero: " + getGenero() + 
                                                                        "\nGrupo: " + getTipoPaciente() + 
                                                                        "\nCita medica: " + getCita());
    }
}
