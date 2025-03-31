import java.util.Stack;

public class AdultoMayor extends Paciente implements VisitorLogic {

    protected AdultoMayor(){
        super();
        setTipoPaciente("Adulto Mayor");
    }

    protected AdultoMayor(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Adulto Mayor");
    }
    
    // metodo getter
    
    protected String getTipoPaciente() {return super.getTipoPaciente();}

    //metodo que redirije al metodo especifico del visitor
    
    @Override
    public String accept(Visitor visitor, Stack<Paciente> listAdultoMayor) {
        return visitor.visitAdultoMayor(this, listAdultoMayor);
    }
}
