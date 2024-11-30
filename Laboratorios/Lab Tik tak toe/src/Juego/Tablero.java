package Juego;

public class Tablero {
    private final Ficha[][] tablero; 

    public Tablero(int filas, int columnas) {
        tablero = new Ficha[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = null; 
            }
        }
    }

 
    public void agregarFicha(Ficha ficha) {
        tablero[ficha.getFila()][ficha.getColumna()] = ficha;
    }


    public Ficha obtenerFicha(int fila, int columna) {
        return tablero[fila][columna];
    }

    
    public void imprimirTablero() {
        for (Ficha[] fila : tablero) {
            for (Ficha ficha : fila) {
                if (ficha != null) {
                    System.out.print(ficha.getValor() + " ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}