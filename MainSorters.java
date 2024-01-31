import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class MainSorters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la cantidad de números que desea generar: ");
        int cant = scanner.nextInt();

        // Genera números aleatorios y escribe en el archivo
        CustomStack<Number> stack = generarNumerosAleatorios(cant);
        escribirCustomStack(stack, "numeros.txt");

        // Lee los números desde el archivo
        CustomStack<Number> numerosLeidos = leerCustomStack("numeros.txt");

        // Convierte el CustomStack en un array para aplicar algoritmo
        Integer[] arrayNumeros = (Integer[]) numerosLeidos.toArray(new Integer[numerosLeidos.size()]);

       GnomeSort<Integer> gnomeSort = new GnomeSort<>();
        arrayNumeros = gnomeSort.sort(arrayNumeros);
        
        escribirArrayEnArchivo(arrayNumeros, "numeros_gnome.txt");
        
        // Aplica el QuickSort
        QuickSort<Integer> quickSort = new QuickSort<>();
        arrayNumeros = quickSort.sort(arrayNumeros);
        escribirArrayEnArchivo(arrayNumeros, "numeros_quick.txt");

        // Aplica el merge sort
        MergeSort<Integer> merge = new MergeSort<>();
        arrayNumeros = merge.sort(arrayNumeros);
        escribirArrayEnArchivo(arrayNumeros, "numeros_merge.txt");

         // Aplica el radix sort
        RadixSort<Integer> radix = new RadixSort<>();
        arrayNumeros = radix.sort(arrayNumeros);
        escribirArrayEnArchivo(arrayNumeros, "numeros_radix.txt");
          
        
        // Aplica el heap sort
         HeapSort<Integer> heap = new HeapSort<>();
          arrayNumeros = heap.sort(arrayNumeros);
         escribirArrayEnArchivo(arrayNumeros, "numeros_heap.txt");
        scanner.close();
    }

    public static CustomStack<Number> generarNumerosAleatorios(int cantidad) {
        CustomStack<Number> stack = new CustomStack<>();
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            int numeroAleatorio = random.nextInt(10000);
            stack.push(numeroAleatorio);
        }

        return stack;
    }

    public static void escribirCustomStack(CustomStack<Number> stack, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            while (!stack.isEmpty()) {
                writer.println(stack.pop());
            }
            System.out.println("CustomStack escrito en el archivo de texto correctamente.");
        } catch (IOException e) {
            System.err.println("Error al escribir el CustomStack en el archivo de texto: " + e.getMessage());
        }
    }

    public static CustomStack<Number> leerCustomStack(String nombreArchivo) {
        CustomStack<Number> stack = new CustomStack<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                stack.push(Integer.parseInt(linea.trim()));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el CustomStack del archivo de texto: " + e.getMessage());
        }
        return stack;
    }

    // Método adicional para escribir un array en un archivo
    public static void escribirArrayEnArchivo(Number[] array, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Number numero : array) {
                writer.println(numero);
            }
            System.out.println("Array ordenado escrito en el archivo de texto correctamente. Archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al escribir el array ordenado en el archivo de texto: " + e.getMessage());
        }
    }
}
