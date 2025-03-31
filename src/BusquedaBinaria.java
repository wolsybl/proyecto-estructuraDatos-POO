import java.util.ArrayList;
import java.util.Stack;

public class BusquedaBinaria {
    private ArrayList<Paciente> listNeonato;
    private ArrayList<Paciente> listBebe;
    private ArrayList<Paciente> listInfante;
    private ArrayList<Paciente> listJoven;
    private ArrayList<Paciente> listJovenAdulto;
    private ArrayList<Paciente> listAdulto;
    private ArrayList<Paciente> listAdultoMayor;

    public BusquedaBinaria(Stack<Paciente> stackNeonato, Stack<Paciente> stackBebe, Stack<Paciente> stackInfante, Stack<Paciente> stackJoven) {
        this.listNeonato = new ArrayList<>(stackNeonato);
        this.listBebe = new ArrayList<>(stackBebe);
        this.listInfante = new ArrayList<>(stackInfante);
        this.listJoven = new ArrayList<>(stackJoven);

        MergeSort.sort(this.listNeonato);
        MergeSort.sort(this.listBebe);
        MergeSort.sort(this.listInfante);
        MergeSort.sort(this.listJoven);
    }

    public BusquedaBinaria(Stack<Paciente> stackJovenAdulto, Stack<Paciente> stackAdulto, Stack<Paciente> stackAdultoMayor) {
        this.listJovenAdulto = new ArrayList<>(stackJovenAdulto);
        this.listAdulto = new ArrayList<>(stackAdulto);
        this.listAdultoMayor = new ArrayList<>(stackAdultoMayor);

        MergeSort.sort(this.listJovenAdulto);
        MergeSort.sort(this.listAdulto);
        MergeSort.sort(this.listAdultoMayor);
    }

    public BusquedaBinaria(Stack<Paciente> stackNeonato, Stack<Paciente> stackBebe, Stack<Paciente> stackInfante, Stack<Paciente> stackJoven, Stack<Paciente> stackJovenAdulto, Stack<Paciente> stackAdulto, Stack<Paciente> stackAdultoMayor) {
        this.listNeonato = new ArrayList<>(stackNeonato);
        this.listBebe = new ArrayList<>(stackBebe);
        this.listInfante = new ArrayList<>(stackInfante);
        this.listJoven = new ArrayList<>(stackJoven);
        this.listJovenAdulto = new ArrayList<>(stackJovenAdulto);
        this.listAdulto = new ArrayList<>(stackAdulto);
        this.listAdultoMayor = new ArrayList<>(stackAdultoMayor);

        MergeSort.sort(this.listNeonato);
        MergeSort.sort(this.listBebe);
        MergeSort.sort(this.listInfante);
        MergeSort.sort(this.listJoven);
        MergeSort.sort(this.listJovenAdulto);
        MergeSort.sort(this.listAdulto);
        MergeSort.sort(this.listAdultoMayor);
    }

    // el documento en las pilas de menores de edad

    public Paciente buscarti(int documento) {
        Paciente paciente = buscarEnLista(documento, listNeonato);
        if (paciente != null) return paciente;

        paciente = buscarEnLista(documento, listBebe);
        if (paciente != null) return paciente;

        paciente = buscarEnLista(documento, listInfante);
        if (paciente != null) return paciente;

        paciente = buscarEnLista(documento, listJoven);
        return paciente;
    }

    // el documento en las pilas de mayores de edad

    public Paciente buscarcc(int documento) {
        Paciente paciente = buscarEnLista(documento, listJovenAdulto);
        if (paciente != null) return paciente;

        paciente = buscarEnLista(documento, listAdulto);
        if (paciente != null) return paciente;

        paciente = buscarEnLista(documento, listAdultoMayor);
        return paciente;
    }

    // busca en todas las litas para comprobar que no se repita el documento

    public Paciente buscarall(int documento) {
        Paciente paciente = buscarEnLista(documento, listNeonato);
        if (paciente != null) return paciente;

        paciente = buscarEnLista(documento, listBebe);
        if (paciente != null) return paciente;

        paciente = buscarEnLista(documento, listInfante);
        if (paciente != null) return paciente;

        paciente = buscarEnLista(documento, listJoven);
        if (paciente != null) return paciente;

        paciente = buscarEnLista(documento, listJovenAdulto);
        if (paciente != null) return paciente;

        paciente = buscarEnLista(documento, listAdulto);
        if (paciente != null) return paciente;

        paciente = buscarEnLista(documento, listAdultoMayor);
        return paciente;
    }

    // aqui se implementa la busqueda binaria en si

    private Paciente buscarEnLista(int documento, ArrayList<Paciente> lista) {
        int inicio = 0;
        int fin = lista.size() - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;
            Paciente paciente = lista.get(medio);

            if (paciente.getIdentificacion() == documento) {
                return paciente;
            } else if (paciente.getIdentificacion() < documento) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return null;
    }
}