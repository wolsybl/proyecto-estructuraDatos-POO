import java.util.Stack;

public class Neonato extends Paciente implements VisitorLogic {

    protected Neonato(){
        super();
        setTipoPaciente("Neonato");
    }

    protected Neonato(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Neonato");
    }

    // metodo getter
    
    protected String getTipoPaciente() {return super.getTipoPaciente();}

    //metodo que redirije al metodo especifico del visitor
    
    @Override
    public String accept(Visitor visitor, Stack<Paciente> listNeonato) {
        return visitor.visitNeonato(this, listNeonato);
    }
}