import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;
import java.util.Stack;
public class Sistema {

    private static Stack<Paciente> listNeonato = new Stack<>();
    private static Stack<Paciente> listBebe = new Stack<>();
    private static Stack<Paciente> listInfante = new Stack<>();
    private static Stack<Paciente> listJoven = new Stack<>();
    private static Stack<Paciente> listJovenAdulto = new Stack<>();
    private static Stack<Paciente> listAdulto = new Stack<>();
    private static Stack<Paciente> listAdultoMayor = new Stack<>();
    
    public static void main(String[] args) throws Exception{
        
        // instancia el objeto para realizar despues la agendacion de cita

        ProgramaDeCitas programaDeCitas = new ProgramaDeCitas();

        // instancia el objeto para implementar el visitor

        //ReportVisitor reportVisitor = new ReportVisitor();

        // intancia los objetos tipo Neonato

        Paciente nPaciente1 = new Neonato("5" , "Cornifer" , 6853234 , "Masculino",null);
        Paciente nPaciente2 = new Neonato("15" , "Luin" , 4653309 , "Femenino",null);

        // intancia los objetos tipo Bebe

        Paciente bPaciente1 = new Bebe("126" , "Brhadaranyakopanishadvivekachudamani Erreh" , 8903456 , "Masculino",null);
        Paciente bPaciente2 = new Bebe("345" , "Taumatawhakatangihangakoauauotamateaturipukakapikimaungahoronukupokaiwhenuakitanatahu" , 5409780 , "Femenino",null);

        // intancia los objetos tipo Infante

        Paciente iPaciente1 = new Infante("3" , "Juan", 9780642, "Masculino",null);
        Paciente iPaciente2 = new Infante("10" , "Andrea" , 3242590 , "Femenino",null);

        // intancia los objetos tipo Joven

        Paciente jPaciente1 = new Joven("16" , "Luisa" , 7654243 , "Femenino",null);
        Paciente jPaciente2 = new Joven("14" , "Albert" , 6704234 , "Masculino",null);
    
        // intancia los objetos tipo JovenAdulto

        Paciente jaPaciente1 = new JovenAdulto("18", "Ana", 1234456, "Femenino",null);
        Paciente jaPaciente2 = new JovenAdulto("20", "Ramon", 1734849, "Masculino",null);
        Paciente jaPaciente3 = new JovenAdulto("18","pepe",5300300,"Masculino","pepe");

        // intancia los objetos tipo Adulto

        Paciente aPaciente1 = new Adulto("27" , "Parangaricutirimicuaro" , 5924034 , "Masculino","null");
        Paciente aPaciente2 = new Adulto("43", "Otorrinolaringologo" , 2043495, "Masculino",null);

        // intancia los objetos tipo AdultoMayor

        Paciente amPaciente1 = new AdultoMayor("60" , "Boludo" , 8478413, "Masculino",null);
        Paciente amPaciente2 = new AdultoMayor("73" , "Marina" , 3954043 , "Femenino",null);
        
        // se agregan los Neonato a sus Stacks respectivas

        listNeonato.push(nPaciente1);
        listNeonato.push(nPaciente2);

        // se agregan los Bebe a sus Stacks respectivas

        listBebe.push(bPaciente1);
        listBebe.push(bPaciente2);

        // se agregan los Infante a sus Stacks respectivas

        listInfante.push(iPaciente1);
        listInfante.push(iPaciente2);
        
        // se agregan los Joven a sus Stacks respectivas

        listJoven.push(jPaciente1);
        listJoven.push(jPaciente2);
        
        // se agregan los JovenAdulto a sus Stacks respectivas

        listJovenAdulto.push(jaPaciente1);
        listJovenAdulto.push(jaPaciente2);
        listJovenAdulto.push(jaPaciente3);

        // se agregan los Adulto a sus Stacks respectivas
        
        listAdulto.push(aPaciente1);
        listAdulto.push(aPaciente2);

        // se agregan los AdultoMayor a sus Stacks respectivas

        listAdultoMayor.push(amPaciente1);
        listAdultoMayor.push(amPaciente2);
        
        boolean volverInicio;
        boolean cuentaCreada = false;
        boolean sesionIniciada;
    //se va a generar un bucle do while para que el usuario inicie sesion con su cuenta ya creada
do {
    //se va a generar un bucle do while por si el usuario llega a querer volver al inicio del menu
    do {
        // saldra una ventana emergente en la cual dara dos opciones, uno para crear un perfil y el otro niciar sesion
        volverInicio = false;
        String[] botones = {"Crear Cuenta", "Iniciar Sesión" , "Salir"};
        int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Sistema de Pacientes",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
        
        if (opcion == 0) { //si la opcion es iniciar sesion segun su edad este mandara los datos a instanciar en la subclase que pertenesca 

            String nombre = Nombre();
            if (nombre == null) {
                // El usuario hizo clic en "cancelar" al ingresar el nombre
                // Volver al inicio del bucle
                continue;
            }
            Integer id = idCreate();
            if (id == -1) {
                // El usuario hizo clic en "cancelar" al ingresar el documento
                // Volver al inicio del bucle
                continue;
            }
            String genero = Genero();
            JOptionPane.showMessageDialog(null, "dijita bien tu fecha de nacimiento, si te equivocas tendras que eliminar la cuenta y vovler a crear otra");
            double edad = solicitarEdad();
            if (edad == -1) {
                // El usuario hizo clic en "cancelar" al ingresar la edad
                // Volver al inicio del bucle
                continue;
            }
            String Contrasena = Contraseña();
            if (Contrasena == null) {
                // El usuario hizo clic en "cancelar" al ingresar la contraseña
                // Volver al inicio del bucle
                continue;
            }
            
            int edadEntero = (int)edad;
            String edadString = String.valueOf(edadEntero);

            if (edad >= 0 && edad <= 0.0767123) { // NEONATO
                double edadDias = edad * 365;
                int edadDiasEntero = (int)edadDias;
                String edadDiasString = String.valueOf(edadDiasEntero);
                Paciente nPaciente = new Neonato(edadDiasString,nombre,id,genero,Contrasena);

                listNeonato.push(nPaciente);
                nPaciente.imprimir();
            } else if(edad > 0.0767123 && edad <1){ // BEBE
                double edadDias = edad * 365;
                int edadDiasEntero = (int)edadDias;
                String edadDiasString = String.valueOf(edadDiasEntero);
                Paciente bPaciente = new Bebe(edadDiasString,nombre,id,genero,Contrasena);

                listBebe.push(bPaciente);
                bPaciente.imprimir();
            } else if (edad >= 1 && edad <= 12) { // INFANTE
                Paciente iPaciente = new Infante(edadString,nombre,id,genero,Contrasena);

                listInfante.push(iPaciente);
                iPaciente.imprimir();
            } else if (edad > 12 && edad < 18){ // JOVEN
                Paciente jPaciente = new Joven(edadString,nombre,id,genero,Contrasena);

                listJoven.push(jPaciente);
                jPaciente.imprimir();
            } else if (edad >= 18 && edad <= 25){ // JOVEN ADULTO
                Paciente jaPaciente = new JovenAdulto(edadString,nombre,id,genero,Contrasena);

                jaPaciente.imprimir();
                listJovenAdulto.push(jaPaciente);
            } else if (edad > 25 && edad <= 59){ // ADULTO
                Paciente aPaciente = new Adulto(edadString,nombre,id,genero,Contrasena);

                listAdulto.push(aPaciente);
                aPaciente.imprimir();
            } else if (edad > 59){ // ADULTO MAYOR
                Paciente amPaciente = new AdultoMayor(edadString,nombre,id,genero,Contrasena);

                listAdultoMayor.push(amPaciente);
                amPaciente.imprimir();
            }
            
            JOptionPane.showMessageDialog(null, "cuenta creada, ahora inicie sesion");

        } else if (opcion == 1) { // si es iniciar secion pedira que tipo de documentacion tiene y de ahi buscara el objeto que tenga el mismo documento ingresado por el usuario

            // se crea otro bucle por si el paciente se equivoca escogiendo el tipo de documento lo regrese a la eleccion de tipo de documento
            boolean pacienteEncontrado = false;

            do {
                String[] botones1 = {"TI", "Cc" , "Volver al inicio"};
                int opcion1 = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Iniciar Sesion",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones1, botones1[0]);

                    if (opcion1 == 0){ // busca en las listas de menores de edad
                        BusquedaBinaria busqueda = new BusquedaBinaria(listNeonato, listBebe, listInfante, listJoven);

                        // Llama al método para buscar el objeto
                        int doc = id();
                        if (doc == -1) {
                            volverInicio = true;
                            continue;
                        }

                        Paciente paciente = busqueda.buscarti(doc);

                        if (paciente != null) {

                            // verifica si la contraseña es correcta y si no lo hobliga que la dijite bien

                            String contraseñaIngresada = JOptionPane.showInputDialog("Por favor, ingrese la contraseña");

                            if (contraseñaIngresada == null) {
                                sesionIniciada = true;
                                break;
                            }
                            
                            while (!paciente.getContraseña().equals(contraseñaIngresada)) {
                                JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Por favor, intente de nuevo.");
                                contraseñaIngresada = JOptionPane.showInputDialog("Por favor, ingrese la contraseña");
                            }

                            // entra a la cuenta

                            do {
                            sesionIniciada = false;
                            String[] botones2 = {"Editar cuenta" , "Gestion de citas medicas" , "Mirar datos" , "Cerrar sesion"};
                            int opcion2 = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Iniciar Sesion",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones2, botones2[0]);

                            if (opcion2 == 0){ // boton de editar cuenta
                                
                                String[] botones2_1 = {"Editar datos" , "eliminar cuenta" , "volver" };
                                int opcion2_1 = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Iniciar Sesion",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones2_1, botones2_1[0]);

                                if (opcion2_1 == 0) {
                                    String opcion2_1_1;
                                    opcion2_1_1 = (String) JOptionPane.showInputDialog(
                                            null,
                                            "que datos deseas actualizar:\n" +
                                                    "- nombre\n" +
                                                    "- documento\n" +
                                                    "- genero\n" +
                                                    "- contraseña",
                                            "Menú de edicion de cuenta",
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,
                                            new Object[]{"nombre", "documento", "genero", "contraseña"},
                                            "nombre");

                                    if (opcion2_1_1 == null) {
                                        pacienteEncontrado = true;
                                        continue;
                                    }

                                    switch (opcion2_1_1) {
                                        case "nombre":
                                            String newnombre = Nombre();
                                            if (newnombre == null) {
                                                pacienteEncontrado = true;
                                                continue;
                                            }
                                            paciente.setNombre(newnombre);
                                            break;

                                        case "documento":
                                            Integer newid = id();
                                            if (newid == -1) {
                                                pacienteEncontrado = true;
                                                continue;
                                            }
                                            paciente.setIdentificacion(newid);
                                            break;

                                        case "genero":
                                            String newgenero = Genero();
                                            if (newgenero == null) {
                                                pacienteEncontrado = true;
                                                continue;
                                            }
                                            paciente.setGenero(newgenero);
                                            break;
                                            
                                        case "contraseña":
                                            String newcontraseña = Contraseña();
                                            if (newcontraseña == null) {
                                                pacienteEncontrado = true;
                                                continue;
                                            }
                                            paciente.setContraseña(newcontraseña);
                                            break;

                                            
                                        default:
                                            break;
                                    }

                                    paciente.imprimir();

                                } else if (opcion2_1 == 1) { // eliminar cuenta
                                    String[] botones2_1_2 = {"no" , "si" };
                                    int opcion2_1_2 = JOptionPane.showOptionDialog(null, "¿estas seguro?", "Iniciar Sesion",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones2_1_2, botones2_1_2[0]);

                                    if (opcion2_1_2 == 0) { // se cago
                                        
                                    } else if (opcion2_1_2 == 1) { // no se cago
                                        programaDeCitas.cancelarCita(paciente.getCita2(), paciente);
                                        listNeonato.remove(paciente);
                                        listBebe.remove(paciente);
                                        listInfante.remove(paciente);
                                        listJoven.remove(paciente);
                                        JOptionPane.showMessageDialog(null, "Paciente eliminado exitosamente.");
                                        sesionIniciada = true;
                                        break;
                                    }
                                }

                            } else if (opcion2 == 1){ // boton Agendar cita

                                boolean opvalida = false;
                                while(!opvalida){
                                    String[] botonesc = {"agendar cita", "cancelar cita", "volver"};      
                                    int opcionc = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestion de citas",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botonesc, botonesc[0]);
                                        if (opcionc == 0) {
                                            programaDeCitas.menu(paciente);
                                            opvalida = true;
                                        }else if (opcionc == 1) {
                                            if (paciente.getCita2()!=null) {
                                                String[] butontal = {"si", "no"};      
                                                int opciontal = JOptionPane.showOptionDialog(null, "¿estas seguro de cancelar la cita?", "Gestion de citas",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, butontal, butontal[0]);
                                                if (opciontal == 0) {
                                                    if (programaDeCitas.cancelarCita(paciente.getCita2(), paciente)) {
                                                        JOptionPane.showMessageDialog(null, "Cita cancelada con éxito", null, JOptionPane.INFORMATION_MESSAGE); 
                                                        opvalida = true;
                                                    }else{
                                                        JOptionPane.showMessageDialog(null, "No se pudo cancelar la cita", null, JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                } else if (opciontal == 1) {
                                                    opvalida = true;
                                                    break;
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "No hay cita agendada", null, JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        }else if (opcionc == 2){
                                            opvalida = true;
                                            break;
                                        }
                                }
                            
                            }else if (opcion2 == 2) { // read
                                
                                paciente.imprimir();
                            
                            } else if (opcion2 == 3){// boton cerrar sesion
                                sesionIniciada = true;
                                break;
                            } } while (!sesionIniciada);
                                                                
                            pacienteEncontrado = true;
                        } else {
                            JOptionPane.showMessageDialog(null, "Paciente no encontrado, intentelo nuevamente");
                        }
                    }else if (opcion1 == 1){ // busca en las lista de mayores de edad
                        BusquedaBinaria busqueda = new BusquedaBinaria(listJovenAdulto, listAdulto, listAdultoMayor);

                        // Llama al método para buscar el objeto
                        int doc = id();
                        if (doc == -1) {
                            volverInicio = true;
                            continue;
                        }

                        Paciente paciente = busqueda.buscarcc(doc);

                        
                        if (paciente != null) {

                            // verifica si la contraseña es correcta y si no lo hobliga que la dijite bien

                            String contraseñaIngresada = JOptionPane.showInputDialog("Por favor, ingrese la contraseña");
                            
                            if (contraseñaIngresada == null) {
                                sesionIniciada = true;
                                break;
                            }

                            while (!paciente.getContraseña().equals(contraseñaIngresada)) {
                                JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Por favor, intente de nuevo.");
                                contraseñaIngresada = JOptionPane.showInputDialog("Por favor, ingrese la contraseña");
                            }

                            // entra a la cuenta

                            do{
                            sesionIniciada = false;
                            String[] botones2 = {"Editar cuenta" , "Gestion de citas medicas" , "Mirar datos" , "Cerrar sesion"};
                            int opcion2 = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Iniciar Sesion",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones2, botones2[0]);

                            if (opcion2 == 0){ // boton de editar cuenta
                                
                                String[] botones2_1 = {"Editar datos" , "eliminar cuenta" , "volver"};
                                int opcion2_1 = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Iniciar Sesion",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones2_1, botones2_1[0]);

                                if (opcion2_1 == 0) { // panel para editar perfil
                                    String opcion2_1_1;
                                    opcion2_1_1 = (String) JOptionPane.showInputDialog(
                                            null,
                                            "que datos deseas actualizar:\n" +
                                                    "- nombre\n" +
                                                    "- documento\n" +
                                                    "- genero\n" +
                                                    "- contraseña",
                                            "nombre",
                                            JOptionPane.PLAIN_MESSAGE,
                                            null,
                                            new Object[]{"nombre", "documento", "genero", "contraseña"},
                                            "Mañana");

                                    if (opcion2_1_1 == null) {
                                        pacienteEncontrado = true;
                                        continue;
                                    }

                                    switch (opcion2_1_1) {
                                        case "nombre":
                                            String newnombre = Nombre();
                                            if (newnombre == null) {
                                                pacienteEncontrado = true;
                                                continue;
                                            }
                                            paciente.setNombre(newnombre);
                                            break;

                                        case "documento":
                                            Integer newid = id();
                                            if (newid == -1) {
                                                pacienteEncontrado = true;
                                                continue;
                                            }
                                            paciente.setIdentificacion(newid);
                                            break;

                                        case "genero":
                                            String newgenero = Genero();
                                            if (newgenero == null) {
                                                pacienteEncontrado = true;
                                                continue;
                                            }
                                            paciente.setGenero(newgenero);
                                            break;

                                        case "contraseña":
                                            String newcontraseña = Contraseña();
                                            if (newcontraseña == null) {
                                                pacienteEncontrado = true;
                                                continue;
                                            }
                                            paciente.setContraseña(newcontraseña);
                                            break;
                                    
                                        default:
                                            break;
                                    }

                                    paciente.imprimir();

                                } else if (opcion2_1 == 1) { // eliminar cuenta
                                    String[] botones2_1_2 = {"no" , "si" };
                                    int opcion2_1_2 = JOptionPane.showOptionDialog(null, "¿estas seguro?", "Iniciar Sesion",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botones2_1_2, botones2_1_2[0]);

                                    if (opcion2_1_2 == 0) { // se cago
                                        
                                    } else if (opcion2_1_2 == 1) { // no se cago
                                        programaDeCitas.cancelarCita(paciente.getCita2(), paciente);
                                        listJovenAdulto.remove(paciente);
                                        listAdulto.remove(paciente);
                                        listAdultoMayor.remove(paciente);
                                        JOptionPane.showMessageDialog(null, "Paciente eliminado exitosamente.");
                                        sesionIniciada = true;
                                        break;
                                    }
                                }

                            } else if (opcion2 == 1){ // boton Agendar cita
                                boolean opvalida = false;
                                while(!opvalida){
                                    String[] botonesc = {"agendar cita", "cancelar cita", "volver"};      
                                    int opcionc = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Gestion de citas",
                                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, botonesc, botonesc[0]);
                                        if (opcionc == 0) {
                                            programaDeCitas.menu(paciente);
                                            opvalida = true;
                                        }else if (opcionc == 1) {
                                            if (paciente.getCita2()!=null) {
                                                String[] butontal = {"si", "no"};      
                                                int opciontal = JOptionPane.showOptionDialog(null, "¿estas seguro de cancelar la cita?", "Gestion de citas",
                                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, butontal, butontal[0]);
                                                if (opciontal == 0) {
                                                    if (programaDeCitas.cancelarCita(paciente.getCita2(), paciente)) {
                                                        JOptionPane.showMessageDialog(null, "Cita cancelada con éxito", null, JOptionPane.INFORMATION_MESSAGE); 
                                                        opvalida = true;
                                                    }else{
                                                        JOptionPane.showMessageDialog(null, "No se pudo cancelar la cita", null, JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                } else if (opciontal == 1) {
                                                    opvalida = true;
                                                    break;
                                                }
                                            }else{
                                                JOptionPane.showMessageDialog(null, "No hay cita agendada", null, JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        }else if(opcionc == 2){
                                            opvalida = true;
                                            break;
                                        }
                                }

                            } else if (opcion2 == 2){ // read

                                paciente.imprimir();

                            } else if (opcion2 == 3){ // boton cerrar sesion
                                sesionIniciada = true;
                                break;
                            } } while(!sesionIniciada);
                            
                            pacienteEncontrado = true;

                        } else {
                            JOptionPane.showMessageDialog(null, "Paciente no encontrado, intentelo nuevamente");
                        }   
                    }else if (opcion1 == 2){
                        volverInicio = true;
                        break;
                    }


                
            } while (!pacienteEncontrado);
        } else if (opcion == 2){
            System.exit(0);
        }
    } while (volverInicio);
// se envian las listas de pacientes a su respectivo visitor
    /*
    String reporteNeonatos = reportVisitor.visitNeonato(null, listNeonato);
    System.out.println(reporteNeonatos);

    String reporteBebes = reportVisitor.visitBebe(null, listBebe);
    System.out.println(reporteBebes);

    String reporteInfantes = reportVisitor.visitInfante(null, listInfante);
    System.out.println(reporteInfantes);

    String reporteJovenes = reportVisitor.visitJoven(null, listJoven);
    System.out.println(reporteJovenes);

    String reporteJovenesAdultos = reportVisitor.visitJovenAdulto(null, listJovenAdulto);
    System.out.println(reporteJovenesAdultos);

    String reporteAdultos = reportVisitor.visitAdulto(null, listAdulto);
    System.out.println( reporteAdultos);

    String reporteAdultosMayores = reportVisitor.visitAdultoMayor(null, listAdultoMayor);
    System.out.println(reporteAdultosMayores);
    */
    
} while (!cuentaCreada);               

        
    }

    // estos metodos tomara los valores de entrada de dia, mes y año, con estos valores se autocalculara la fecha
    
    public static double solicitarEdad() {
        while (true) {
            try {
                String diaStr = JOptionPane.showInputDialog("Digite el día de nacimiento");
                if (diaStr == null) {
                    // El usuario hizo clic en "cancelar"
                    return -1;
                }
                int dia = Integer.parseInt(diaStr);
    
                String mesStr = JOptionPane.showInputDialog("Digite el mes de nacimiento");
                if (mesStr == null) {
                    // El usuario hizo clic en "cancelar"
                    return -1;
                }
                int mes = Integer.parseInt(mesStr);
    
                String anioStr = JOptionPane.showInputDialog("Digite el año de nacimiento");
                if (anioStr == null) {
                    // El usuario hizo clic en "cancelar"
                    return -1;
                }
                int anio = Integer.parseInt(anioStr);
    
                if (dia < 1 || dia > 31) {
                    JOptionPane.showMessageDialog(null, "El día debe estar entre 1 y 31. Por favor, intente de nuevo.");
                    continue;
                }
    
                if (mes < 1 || mes > 12) {
                    JOptionPane.showMessageDialog(null, "El mes debe estar entre 1 y 12. Por favor, intente de nuevo.");
                    continue;
                }
    
                if (anio < 1900 || anio > LocalDate.now().getYear()) {
                    JOptionPane.showMessageDialog(null, "El año debe estar entre 1900 y el año actual. Por favor, intente de nuevo.");
                    continue;
                }
    
                int confirmacion = JOptionPane.showConfirmDialog(null, "¿Está seguro de que esta es su fecha de nacimiento?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.NO_OPTION) {
                    continue;
                }
    
                double edad = calcularEdad(dia, mes, anio);
                if (edad != 0) {
                    return edad;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese solo números.");
            }
        }
    }
    
    

    private static double calcularEdad(int dia, int mes, int anio) {
        try {
            LocalDate fechaNacimiento = LocalDate.of(anio, mes, dia);
            LocalDate fechaActual = LocalDate.now();
            if (fechaNacimiento.isAfter(fechaActual)) {
                JOptionPane.showMessageDialog(null, "La fecha de nacimiento no puede ser en el futuro. Por favor, intente de nuevo.");
                return 0;
            }
            long diasTotales = ChronoUnit.DAYS.between(fechaNacimiento, fechaActual);
            double edadDecimal = diasTotales / 365.25;
            if (edadDecimal > 150) {
                JOptionPane.showMessageDialog(null, "La fecha registrada no es posible. Por favor, intente de nuevo.");
                return 0; 
            }
            return edadDecimal;
        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, "La fecha ingresada no es válida. Por favor, intente de nuevo.");
            return 0;
        }
    }

    // este metodo estatico introduce un bloque de ecepcion para ingresar adecuadamente el documento

    public static int id() {
        while (true) {
            String input = JOptionPane.showInputDialog("Digite su documentacion");
            if (input == null) {
                return -1;
            }
            try {
                Integer documento = Integer.parseInt(input);
                String documentoStr = String.valueOf(documento);
                if (documentoStr.length() >= 6 && documentoStr.length() <= 10) {
                    return documento;
                } else {
                    JOptionPane.showMessageDialog(null, "El documento ingresado es incorrecto. Debe tener entre 6 y 10 dígitos. Por favor, intente de nuevo.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese su documento correctamente.");
            }
        }
    }

    public static int idCreate() {
        BusquedaBinaria busqueda = new BusquedaBinaria(listNeonato, listBebe, listInfante, listJoven,listJovenAdulto, listAdulto, listAdultoMayor);

    while (true) {
        String input = JOptionPane.showInputDialog("Digite su documentacion");
            if (input == null) {
                return -1;
            }
        try {
            Integer documento = Integer.parseInt(input);
            String documentoStr = String.valueOf(documento);
            if (documentoStr.length() >= 6 && documentoStr.length() <= 10) {
                // Verificar si el documento ya existe en las listas de pacientes
                Paciente pacienteExistente = busqueda.buscarall(documento);
                if (pacienteExistente == null) {
                    return documento;
                } else {
                    JOptionPane.showMessageDialog(null, "Este documento ya tiene cuenta. Por favor, ingrese un documento diferente.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El documento ingresado es incorrecto. Debe tener entre 6 y 10 dígitos. Por favor, intente de nuevo.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese su documento correctamente.");
        }
    }
    }

    // este metodo estatico permite una ventana emergente con dos selecciones a gusto del usuario para ingresar su genero biologico

    public static String Genero() {
        Object[] opciones = {"Masculino", "Femenino"};
        int seleccion = JOptionPane.showOptionDialog(
            null, 
            "Seleccione su género biologico", 
            "Género", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.INFORMATION_MESSAGE, 
            null, 
            opciones, 
            opciones[0] 
        );
        return (seleccion == 0) ? "Masculino" : "Femenino";
    }

    // este metodo estatico permite una ventana emergente que permime dijitar el nombre pero no recibe valores null

    public static String Nombre() {
        String nombre = null;
        while (true) {
            nombre = JOptionPane.showInputDialog("Por favor, ingrese su nombre");
            if (nombre == null) {
                // El usuario hizo clic en "cancelar"
                return null;
            } else if (nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío. Por favor, intente de nuevo.");
            } else {
                // El nombre es válido
                return nombre;
            }
        }
    }
    

    // este metodo estatico permite una ventana emergente que permime dijitar la contraseña pero no recibe valores null y tenga un maximo de 10 dijitos
    
    public static String Contraseña() {
        String contraseña = null;
        while (true) {
            contraseña = JOptionPane.showInputDialog("Por favor, ingrese su contraseña (máximo 10 caracteres)");
            if (contraseña == null) {
                // El usuario hizo clic en "cancelar"
                return null;
            } else if (contraseña.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La contraseña no puede estar vacía. Por favor, intente de nuevo.");
            } else if (contraseña.length() > 10) {
                JOptionPane.showMessageDialog(null, "La contraseña no puede tener más de 10 caracteres. Por favor, intente de nuevo.");
            } else {
                // La contraseña es válida
                return contraseña;
            }
        }
    }
    
}