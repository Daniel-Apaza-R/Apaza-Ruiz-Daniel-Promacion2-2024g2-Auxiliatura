package Juego;//by ELRODRIGOADDDDD :)

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Interfaz {
    // Tamaño del tablero
    private static final int SIZE = 3;
    
    // Matriz de botones que representa las casillas del juego
    private JButton[][] buttons = new JButton[SIZE][SIZE];
    private String[][] boardState = new String[SIZE][SIZE];  
    private char currentPlayer = 'X';  
    private Image xImage, oImage, backgroundImage;  
    private boolean gameOver = false;  
    private JButton resetButton;  
    
    
    public Interfaz() {
        
        try {
           
            xImage = ImageIO.read(new File("C:\\Users\\apaza\\OneDrive\\Pictures\\Keramon Stage.png"));
            oImage = ImageIO.read(new File("C:\\Users\\apaza\\OneDrive\\Pictures\\patamon.png"));
            
            backgroundImage = ImageIO.read(new File("C:\\Users\\apaza\\OneDrive\\Pictures\\descarga.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        JFrame frame = new JFrame("Tic-Tac-Toe");
        frame.setSize(400, 450);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        frame.setLayout(new BorderLayout());  

        // Crear un panel para el fondo
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);  
            }
        };
        panel.setLayout(new GridLayout(SIZE, SIZE));  
        frame.add(panel, BorderLayout.CENTER);  

        // Crear los botones para el tablero
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(100, 100));  
                buttons[i][j].setFont(new Font("Arial", Font.PLAIN, 40));  
                buttons[i][j].setContentAreaFilled(false);  
                buttons[i][j].setBorder(BorderFactory.createEmptyBorder());  
                buttons[i][j].setOpaque(false);  

                // Acción cuando se hace clic en un botón
                buttons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (gameOver) {
                            return;  
                        }

                        JButton source = (JButton) e.getSource();
                        if (source.getIcon() == null) {
                    
                            if (currentPlayer == 'X') {
                                source.setIcon(new ImageIcon(getScaledImage(xImage, source.getWidth(), source.getHeight()))); 
                                boardState[getButtonPosition(source)[0]][getButtonPosition(source)[1]] = "X";  
                            } else {
                                source.setIcon(new ImageIcon(getScaledImage(oImage, source.getWidth(), source.getHeight())));  
                                boardState[getButtonPosition(source)[0]][getButtonPosition(source)[1]] = "O";  
                            }

                            // Comprobar si hay un ganador
                            if (checkWin()) {
                                JOptionPane.showMessageDialog(null, "¡Jugador " + currentPlayer + " ha ganado!", "¡Juego Terminado!", JOptionPane.INFORMATION_MESSAGE);
                                gameOver = true; 
                            } else if (isBoardFull()) {
                                JOptionPane.showMessageDialog(null, "¡Es un empate!", "¡Juego Terminado!", JOptionPane.INFORMATION_MESSAGE);
                                gameOver = true;  
                            } else {
                                // Cambiar al siguiente jugador
                                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                            }
                        }
                    }
                });

                panel.add(buttons[i][j]);  
            }
        }

        // Crear botón de "Jugar de nuevo"
        resetButton = new JButton("Jugar de nuevo");
        resetButton.setPreferredSize(new Dimension(400, 50));  
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();  
            }
        });

        frame.add(resetButton, BorderLayout.SOUTH); 
        frame.setVisible(true);
    }

   
    private Image getScaledImage(Image originalImage, int width, int height) {
        return originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    // Método para obtener la posición del botón en la matriz
    private int[] getButtonPosition(JButton button) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (buttons[i][j] == button) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};  
    }

    // Verificar si el jugador actual ha ganado
    private boolean checkWin() {
        // Comprobar filas y columnas
        for (int i = 0; i < SIZE; i++) {
           
            if (boardState[i][0] != null && 
                boardState[i][0].equals(boardState[i][1]) && 
                boardState[i][1].equals(boardState[i][2]) && 
                !boardState[i][0].equals("")) {
                return true; 
            }
        
            if (boardState[0][i] != null && 
                boardState[0][i].equals(boardState[1][i]) && 
                boardState[1][i].equals(boardState[2][i]) && 
                !boardState[0][i].equals("")) {
                return true;  
            }
        }

     
        if (boardState[0][0] != null && 
            boardState[0][0].equals(boardState[1][1]) && 
            boardState[1][1].equals(boardState[2][2]) && 
            !boardState[0][0].equals("")) {
            return true; 
        }
        if (boardState[0][2] != null && 
            boardState[0][2].equals(boardState[1][1]) && 
            boardState[1][1].equals(boardState[2][0]) && 
            !boardState[0][2].equals("")) {
            return true;  
        }

        return false;
    }

   
    private boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (boardState[i][j] == null || boardState[i][j].equals("")) { 
                    return false;
                }
            }
        }
        return true;
    }

    // Método para reiniciar el juego
    private void resetGame() {
    
        boardState = new String[SIZE][SIZE];
        gameOver = false;
        currentPlayer = 'X';


        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                buttons[i][j].setIcon(null);  
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Interfaz());  
    }
} 