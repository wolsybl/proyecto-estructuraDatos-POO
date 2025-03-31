import java.util.*;

public class MergeSort {
    // Método para ordenar la lista de pacientes
    public static void sort(List<Paciente> list) {
        // Si la lista tiene un tamaño de 1 o menos, ya está ordenada
        if (list.size() <= 1) {
            return;
        }

        // Divide la lista en dos mitades
        int mid = list.size() / 2;
        List<Paciente> left = new ArrayList<>(list.subList(0, mid));
        List<Paciente> right = new ArrayList<>(list.subList(mid, list.size()));

        // Ordena cada mitad de forma recursiva
        sort(left);
        sort(right);

        // Combina las dos mitades en una lista ordenada
        merge(list, left, right);
    }

    // Método para combinar dos listas ordenadas en una sola lista ordenada
    private static void merge(List<Paciente> list, List<Paciente> left, List<Paciente> right) {
        int i = 0, j = 0, k = 0;

        // Compara los primeros elementos de left y right
        // Mueve el elemento más pequeño a la lista original
        while (i < left.size() && j < right.size()) {
            if (left.get(i).getIdentificacion() <= right.get(j).getIdentificacion()) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        // Mueve los elementos restantes de left a la lista original
        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        // Mueve los elementos restantes de right a la lista original
        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }
}
