package Vista;
import Reglas.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

 public class Main {
    public static void main(String[] args) {
    Interfaz interfaz = new Interfaz();
    ArrayList<Libros> libro = new ArrayList<>(); 
    ArrayList<Autor> autores = new ArrayList<>();
    leerAutoresDesdeArchivo(autores);
    leerLibrosDesdeArchivo(libro,autores);
    
        String Menu;
        int op;
        Menu = "Bienvenido \n1.Agregar Libro \n2.Agregar Autores \n3.Buscar libros \n4.Mostrar libros \n5.Mostrar Autores \n0.Salir"; 
        op = Integer.parseInt(JOptionPane.showInputDialog(Menu));
        while ((op >= 0) && (op <= 5)){
        if (op == 1){
        agregarLibro(libro,autores); 
        op = Integer.parseInt(JOptionPane.showInputDialog(Menu));
        }
        if (op == 2){
        interfaz.agregarAutor(autores);
        guardarAutoresEnArchivo(autores);
        op = Integer.parseInt(JOptionPane.showInputDialog(Menu));
        }
        
        if (op == 3){
        interfaz.BuscarLibro(libro, autores);
        op = Integer.parseInt(JOptionPane.showInputDialog(Menu));    
        }
        
       if (op == 4){
         interfaz.mostrarLibros(libro, autores);
         op = Integer.parseInt(JOptionPane.showInputDialog(Menu));
        }
        
     if (op == 5){
         interfaz.mostrarAutores(autores);
         op = Integer.parseInt(JOptionPane.showInputDialog(Menu));
        }    
      if (op == 0){
         JOptionPane.showMessageDialog(null,"GRACIAS POR PREFERIRNOS \nHASTA PRONTO");
         break;
        }      
    }
 }
    
private static void leerLibrosDesdeArchivo(ArrayList<Libros> libro, ArrayList<Autor> autores) {
    try (BufferedReader reader = new BufferedReader(new FileReader("Libros.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\-");
            if (parts.length == 7) {
                int id = Integer.parseInt(parts[0]);
                int codigo = Integer.parseInt(parts[1]);
                int idA = Integer.parseInt(parts[2]);
                String editorial = parts[3];
                String titulo = parts[4];
                int año = Integer.parseInt(parts[5]);
                int pag = Integer.parseInt(parts[6]);

                Autor autor = null;
                for (Autor a : autores) {
                    if (a.getIdA() == idA) {
                        autor = a;
                        break;
                    }
                }

                if (autor != null) {
                    libro.add(new Libros(id, codigo, autor, editorial, titulo, pag, año));
                } else {
                    // Manejar el caso en el que no se encuentra el autor
                    // Puedes lanzar una excepción o mostrar un mensaje de error
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Libros leídos desde el archivo 'Libros.txt'");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al leer el archivo 'Libros.txt'");
    }
}

private static void guardarLibrosEnArchivo(ArrayList<Libros> libro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Libros.txt"))) {
            for (Libros lb : libro) {
                String libroNuevo = lb.getId()+ "-"+ lb.getCodigo()+ "-"+ lb.getAutor().getIdA()+ "-"+ lb.getEditorial() + "-"+ lb.getTitulo() + "-"+ lb.getAño() + "-"+ lb.getPag();
                writer.write(libroNuevo);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Libros guardados en el archivo 'Libros.txt'");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo 'Libros.txt'");
        }
    }
    
private static void leerAutoresDesdeArchivo( ArrayList<Autor> autores) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Autor.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\-");
                if (parts.length == 3) {
                    String nombre = parts[0];
                    String pais = parts[1];
                    int id = Integer.parseInt(parts[2]);
                    
                    autores.add(new Autor( nombre , pais, id));
                }
            }
            JOptionPane.showMessageDialog(null, "Autores leídos desde el archivo ");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
        }
    }

private static void guardarAutoresEnArchivo( ArrayList<Autor> autores) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Autor.txt"))) {
            for (Autor au : autores) {
                String AutorNuevo = au.getNombre() + "-" + au.getPais() + "-" + au.getIdA()  ;
                writer.write(AutorNuevo);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "Libros guardados en el archivo 'Autor.txt'");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al escribir en el archivo 'Autor.txt'");
        }
    }

private static void agregarLibro(ArrayList<Libros> libros, ArrayList<Autor> autores) {
    int idLb = libros.size() + 1;
    int cd = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el código del libro:"));
    int idA = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el ID del Autor:"));

    Autor autor = null;
    for (Autor a : autores) {
        if (a.getIdA() == idA) {
            autor = a;
            break;
        }
    }
        if (autor != null) {
        String editorial = JOptionPane.showInputDialog("Ingresa la editorial del libro:");
        String titulo = JOptionPane.showInputDialog("Ingresa el título del libro:");
        int paginas = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el número de páginas del libro:"));
        int año = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el año de publicación del libro:"));

        Libros nuevoLibro = new Libros(idLb, cd, autor, editorial, titulo, paginas, año);
        libros.add(nuevoLibro);
        guardarLibrosEnArchivo(libros);
        JOptionPane.showMessageDialog(null, "Libro agregado con éxito.");
    } else {
        JOptionPane.showMessageDialog(null, "El ID del autor ingresado no existe. Por favor, cree el Autor");
        String nombre = JOptionPane.showInputDialog("Ingresa el Nombre del Autor");
        String pais = JOptionPane.showInputDialog("Ingresa el País ");
        int id = autores.size() + 1;
        autores.add(new Autor(nombre, pais, id));
        guardarAutoresEnArchivo(autores);

    }
}
               
 }
 



