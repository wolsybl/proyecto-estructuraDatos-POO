import java.util.Stack;

public interface Visitor {

    //Metodos especificos para cada tipo de paciente
    String visitNeonato(Neonato neonato, Stack<Paciente> listNeonato);

    String visitBebe(Bebe Bebe, Stack<Paciente> listBebe);

    String visitInfante(Infante infante, Stack<Paciente> listInfante);

    String visitJoven(Joven joven, Stack<Paciente> listJoven);

    String visitJovenAdulto(JovenAdulto jovenAdulto, Stack<Paciente> listJovenAdulto);

    String visitAdulto(Adulto adulto, Stack<Paciente> listAdulto);

    String visitAdultoMayor(AdultoMayor adultoMayor, Stack<Paciente> listAdultoMayor);
}
