import java.util.Stack;

public class Bebe extends Paciente implements VisitorLogic {
    
    protected Bebe(){
        super();
        setTipoPaciente("Bebé");
    }

    protected Bebe(String edad, String nombre, Integer identificacion, String genero, String contraseña){
        super(edad, nombre, identificacion, genero, contraseña);
        setTipoPaciente("Bebé");
    }
    
    // metodo getter
    
    protected String getTipoPaciente() {return super.getTipoPaciente();}

    //metodo que redirije al metodo especifico del visitor
    
    @Override
    public String accept(Visitor visitor, Stack<Paciente> listBebe) {
        return visitor.visitBebe(this, listBebe);
    }
}
