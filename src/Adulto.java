import java.util.Stack;

public class Adulto extends Paciente implements VisitorLogic {
    
    protected Adulto(){
        super();
        setTipoPaciente("Adulto");
    }

    protected Adulto(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Adulto");
    }
    
    // metodo getter
    
    protected String getTipoPaciente() {return super.getTipoPaciente();}

    //metodo que redirije al metodo especifico del visitor
    
    @Override
    public String accept(Visitor visitor, Stack<Paciente> listAdulto) {
        return visitor.visitAdulto(this, listAdulto);
    }
}
