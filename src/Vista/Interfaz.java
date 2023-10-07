package Vista;
import Reglas.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Interfaz {
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------  
public void agregarAutor(ArrayList<Autor> autores) {
String nombre = JOptionPane.showInputDialog("Ingresa el Nombre del Autor");
String pais = JOptionPane.showInputDialog("Ingresa el País ");
int id = autores.size() + 1;
autores.add(new Autor(nombre, pais, id));
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public void mostrarAutores(ArrayList<Autor> autores) {
        String salida = "----------------------------Autores----------------------------\n";
        for (Autor a : autores ) {
           salida += a.getNombre() + "|" + a.getPais() + "|" + a.getIdA() + "\n" ;
        }
        JOptionPane.showMessageDialog(null, salida);
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public void mostrarLibros(ArrayList<Libros> libro, ArrayList<Autor> autores) {
        String salida = "----------------------------Libros----------------------------\n";
        for (Libros l : libro ) {
           
            salida += l.getId() + "|" + l.getCodigo() + "|" + l.getAutor().getIdA() + "|" + l.getEditorial() + "|" + l.getTitulo() + "|" + l.getAño()  + "|" + l.getPag() + "" ;
        }
        JOptionPane.showMessageDialog(null, salida);
    }
 //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
public  void BuscarLibro (ArrayList<Libros> libro, ArrayList<Autor> autores){
        int idL = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del libro"));
        int idA = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el id del Escritor"));
        Libros LnEncontado= null;

        for (Libros l : libro) {
            if ((l.getId() == idL)&& (l.getAutor().getIdA() == idA)) {
                LnEncontado = l;
                break;
            }
        }

        if (LnEncontado != null) {
            JOptionPane.showMessageDialog(null, "Libro Encontrado");
            JOptionPane.showMessageDialog(null,LnEncontado.getId() + "|" + LnEncontado.getCodigo() + "|" + LnEncontado.getAutor().getIdA() + "|" + LnEncontado.getEditorial() + "|" + LnEncontado.getTitulo() + "|" + LnEncontado.getAño()  + "|" + LnEncontado.getPag());
        }
        
        else {
            JOptionPane.showMessageDialog(null, "Departamento no Encontrado");
             }
    }
      
}

