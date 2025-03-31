import java.util.Stack;

public class JovenAdulto extends Paciente implements VisitorLogic {
    
    protected JovenAdulto(){
        super();
        setTipoPaciente("Joven adulto");
    }

    protected JovenAdulto(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Joven adulto");
    }
    
    // metodo getter
    
    protected String getTipoPaciente() {return super.getTipoPaciente();}

    //metodo que redirije al metodo especifico del visitor
    
    @Override
    public String accept(Visitor visitor, Stack<Paciente> listJovenAdulto) {
        return visitor.visitJovenAdulto(this, listJovenAdulto);
    }

}
