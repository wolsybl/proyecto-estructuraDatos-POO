import java.util.Stack;

public interface VisitorLogic {
    //metodo de redireccion que se va a implementar en cada subclase de paciente
    String accept(Visitor visitor , Stack<Paciente> listPacientes);
}
