
package Reglas;


public class Autor {
   
String nombre, pais; 
int idA; 

    public Autor() {
    }

    public Autor(String nombre, String pais, int idA) {
        this.nombre = nombre;
        this.pais = pais;
        this.idA = idA;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

   

    
}
