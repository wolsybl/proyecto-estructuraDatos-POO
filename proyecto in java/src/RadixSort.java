import java.util.*;

public class RadixSort {
    // Una función auxiliar para obtener el valor máximo en citas[]
    static long getMax(List<Cita> citas) {
        long mx = citas.get(0).toNumericValue();
        for (Cita cita : citas)
            if (cita.toNumericValue() > mx)
                mx = cita.toNumericValue();
        return mx;
    }

    // Una función para hacer el ordenamiento por conteo de citas[] de acuerdo a
    // el dígito representado por exp.
    static void countSort(List<Cita> citas, int exp) {
        int n = citas.size();
        List<Cita> output = new ArrayList<>(Collections.nCopies(n, null)); // Inicializa output con nulls
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
    
        // Almacena el conteo de ocurrencias en count[]
        for (i = 0; i < n; i++)
            count[(int) ((citas.get(i).toNumericValue() / exp) % 10)]++;
    
        // Cambia count[i] de modo que count[i] ahora contiene
        // la posición actual de este dígito en output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
    
        // Construye el array de salida
        for (i = n - 1; i >= 0; i--) {
            output.set(count[(int) ((citas.get(i).toNumericValue() / exp) % 10)] - 1, citas.get(i));
            count[(int) ((citas.get(i).toNumericValue() / exp) % 10)]--;
        }
    
        // Copia el array de salida a citas[], de modo que citas[] ahora
        // contiene números ordenados de acuerdo al dígito actual
        for (i = 0; i < n; i++)
            citas.set(i, output.get(i));
    }
    
    // La función principal que ordena citas[] usando Radix Sort
    public static void radixsort(List<Cita> citas) {
        // Encuentra el número máximo para saber el número de dígitos
        long m = getMax(citas);

        // Realiza el ordenamiento por conteo para cada dígito. Nota que
        // en lugar de pasar el número de dígito, se pasa exp.
        // exp es 10^i donde i es el número de dígito actual
        for (long exp = 1; m / exp > 0; exp *= 10)
            countSort(citas, (int) exp);
    }
}
