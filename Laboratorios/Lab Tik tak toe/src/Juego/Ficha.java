
package Juego;


public class Ficha {
    private final String valor;  
    private final int fila;      
    private final int columna;   

    // Constructor
    public Ficha(String valor, int fila, int columna) {
        this.valor = valor;
        this.fila = fila;
        this.columna = columna;
    }

 
    public String getValor() {
        return valor;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    @Override
    public String toString() {
        return "Ficha{" +
               "valor='" + valor + '\'' +
               ", fila=" + fila +
               ", columna=" + columna +
               '}';
    }
}