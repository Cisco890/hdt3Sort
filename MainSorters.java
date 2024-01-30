import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;


public class MainSorters {
    
    public static void main(String[] args) {
        CustomStack<Number> stack = new CustomStack<>();
        Random random = new Random();
        int cant = 3000;
        for(int i = 0; i < cant; i++){
            int numeroaleatorio = random.nextInt(10000);
            stack.push(numeroaleatorio);
        }

        escribirCustomStack(stack, "numeros.txt");
        
        
        CustomStack<Number> stackLeido = leerCustomStack("numeros.txt");
        
        
        System.out.println("Números leídos del archivo de texto:");
        while (!stackLeido.isEmpty()) {
            System.out.println(stackLeido.pop());
        }
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

    private static int[] generarNumerosAleatorios(int cantidad, int maximo) {
        int[] numeros = new int[cantidad];
        Random random = new Random();

        for (int i = 0; i < cantidad; i++) {
            numeros[i] = random.nextInt(maximo + 1);
        }

        return numeros;
    } 
}