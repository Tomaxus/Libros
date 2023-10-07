
package Reglas;


public class Libros {
    
int id, codigo, año, pag;
String editorial,titulo; 
Autor autor;

    public Libros(int id, int codigo, Autor autor , String editorial, String titulo , int pag , int año) {
        this.id = id;
        this.codigo = codigo;
        this.año = año;
        this.pag = pag;
        this.editorial = editorial;
        this.titulo = titulo;
        this.autor = autor;
    }

    public Libros() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getPag() {
        return pag;
    }

    public void setPag(int pag) {
        this.pag = pag;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
   
}
