import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProbarFicheros {
    public static void main(String[] args) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("hola.txt", true))) {
            bw.write("un anillo para gobernarlos a todos\n");
            bw.write("Un Anillo para encontrarlos\n");
            bw.write("Un Anillo para atraerlos a todos\n");
            bw.write("y atarlos en las tinieblas");

        } catch (IOException err) {
            System.out.println(" ");
            err.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader("hola.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                System.out.println("-");
            } 

        } catch (IOException err) {
            System.out.println("PEDAZO DE ERROR DE LECTURA");
            err.printStackTrace();
        }
    }
}
