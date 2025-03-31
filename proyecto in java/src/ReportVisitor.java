import java.util.Stack;

public class ReportVisitor implements Visitor {
    // a cada metodo especifico para cada tipo de paciente se crea un strinbuilder que imprime las listas de cada tipo de paciente
    @Override
    public String visitNeonato(Neonato neonato , Stack<Paciente> listNeonato){
        StringBuilder sb = new StringBuilder();
        for (Paciente paciente : listNeonato) {
            sb.append("Nombre: ").append(paciente.getNombre()).append("\n");
            sb.append("Edad: ").append(paciente.getEdad()).append("\n");
            sb.append("Identificación: ").append(paciente.getIdentificacion()).append("\n");
            sb.append("Género: ").append(paciente.getGenero()).append("\n");
            sb.append("Tipo de Paciente: ").append(paciente.getTipoPaciente()).append("\n");
            sb.append("--------------------\n");
        }
        return sb.toString();
    }

    @Override
    public String visitBebe(Bebe bebe , Stack<Paciente> listBebe){
        StringBuilder sb = new StringBuilder();
        for (Paciente paciente : listBebe) {
            sb.append("Nombre: ").append(paciente.getNombre()).append("\n");
            sb.append("Edad: ").append(paciente.getEdad()).append("\n");
            sb.append("Identificación: ").append(paciente.getIdentificacion()).append("\n");
            sb.append("Género: ").append(paciente.getGenero()).append("\n");
            sb.append("Tipo de Paciente: ").append(paciente.getTipoPaciente()).append("\n");
            sb.append("--------------------\n");
        }
        return sb.toString();
    }

    @Override
    public String visitInfante(Infante infante , Stack<Paciente> listInfante){
        StringBuilder sb = new StringBuilder();
        for (Paciente paciente : listInfante) {
            sb.append("Nombre: ").append(paciente.getNombre()).append("\n");
            sb.append("Edad: ").append(paciente.getEdad()).append("\n");
            sb.append("Identificación: ").append(paciente.getIdentificacion()).append("\n");
            sb.append("Género: ").append(paciente.getGenero()).append("\n");
            sb.append("Tipo de Paciente: ").append(paciente.getTipoPaciente()).append("\n");
            sb.append("--------------------\n");
        }
        return sb.toString();
    }

    @Override
    public String visitJoven(Joven joven , Stack<Paciente> listJoven){
        StringBuilder sb = new StringBuilder();
        for (Paciente paciente : listJoven) {
            sb.append("Nombre: ").append(paciente.getNombre()).append("\n");
            sb.append("Edad: ").append(paciente.getEdad()).append("\n");
            sb.append("Identificación: ").append(paciente.getIdentificacion()).append("\n");
            sb.append("Género: ").append(paciente.getGenero()).append("\n");
            sb.append("Tipo de Paciente: ").append(paciente.getTipoPaciente()).append("\n");
            sb.append("--------------------\n");
        }
        return sb.toString();
    }

    @Override
    public String visitJovenAdulto(JovenAdulto jovenAdulto , Stack<Paciente> listJovenAdulto){
        StringBuilder sb = new StringBuilder();
        for (Paciente paciente : listJovenAdulto) {
            sb.append("Nombre: ").append(paciente.getNombre()).append("\n");
            sb.append("Edad: ").append(paciente.getEdad()).append("\n");
            sb.append("Identificación: ").append(paciente.getIdentificacion()).append("\n");
            sb.append("Género: ").append(paciente.getGenero()).append("\n");
            sb.append("Tipo de Paciente: ").append(paciente.getTipoPaciente()).append("\n");
            sb.append("--------------------\n");
        }
        return sb.toString();
    }

    @Override
    public String visitAdulto(Adulto adulto , Stack<Paciente> listAdulto){
        StringBuilder sb = new StringBuilder();
        for (Paciente paciente : listAdulto) {
            sb.append("Nombre: ").append(paciente.getNombre()).append("\n");
            sb.append("Edad: ").append(paciente.getEdad()).append("\n");
            sb.append("Identificación: ").append(paciente.getIdentificacion()).append("\n");
            sb.append("Género: ").append(paciente.getGenero()).append("\n");
            sb.append("Tipo de Paciente: ").append(paciente.getTipoPaciente()).append("\n");
            sb.append("--------------------\n");
        }
        return sb.toString();
    }

    @Override
    public String visitAdultoMayor(AdultoMayor adultoMayor , Stack<Paciente> listAdultoMayor){
        StringBuilder sb = new StringBuilder();
        for (Paciente paciente : listAdultoMayor) {
            sb.append("Nombre: ").append(paciente.getNombre()).append("\n");
            sb.append("Edad: ").append(paciente.getEdad()).append("\n");
            sb.append("Identificación: ").append(paciente.getIdentificacion()).append("\n");
            sb.append("Género: ").append(paciente.getGenero()).append("\n");
            sb.append("Tipo de Paciente: ").append(paciente.getTipoPaciente()).append("\n");
            sb.append("--------------------\n");
        }
        return sb.toString();
    }
}
