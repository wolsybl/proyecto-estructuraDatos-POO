import java.util.Stack;

public class Infante extends Paciente implements VisitorLogic {

    protected Infante(){
        super();
        setTipoPaciente("Infante");
    }

    protected Infante(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Infante");
    }

    // metodo getter

    protected String getTipoPaciente() {return super.getTipoPaciente();}

    //metodo que redirije al metodo especifico del visitor
    
    @Override
    public String accept(Visitor visitor, Stack<Paciente> listInfante) {
        return visitor.visitInfante(this, listInfante);
    }
}
