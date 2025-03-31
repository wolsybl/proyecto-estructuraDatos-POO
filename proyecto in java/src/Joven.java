import java.util.Stack;

public class Joven extends Paciente implements VisitorLogic {

    protected Joven(){
        super();
        setTipoPaciente("Joven adulto");
    }

    protected Joven(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Joven");
    }
    
    // metodo getter
    
    protected String getTipoPaciente() {return super.getTipoPaciente();}

    //metodo que redirije al metodo especifico del visitor
    
    @Override
    public String accept(Visitor visitor, Stack<Paciente> listJoven) {
        return visitor.visitJoven(this, listJoven);
    }
}
