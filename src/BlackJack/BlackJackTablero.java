package BlackJack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BlackJackTablero extends JFrame implements ActionListener{
    private JButton j1tirar, j2tirar, j1plantarse, j2plantarse;
    private JLabel lblj1,lblj2;
    private Dado dado = new Dado();
    private int resultadoj1 = 0,resultadoj2 = 0;
    private boolean j1=true,j2=true,juegoacabado=false;

    public BlackJackTablero(){
        this.setLayout(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        j1tirar = new JButton("J1 Tirar");
        j2tirar = new JButton("J2 Tirar");
        j1plantarse = new JButton("J1 Plantarse");
        j2plantarse = new JButton("J2 Plantarse");
        lblj1 = new JLabel();
        lblj2 = new JLabel();
        
        add(j1tirar);
        add(j2tirar);
        add(j1plantarse);
        add(j2plantarse);
        add(lblj1);
        add(lblj2);
        
        j1tirar.setBounds(65, 40, 100, 50);
        j2tirar.setBounds(225, 40, 100, 50);
        j1plantarse.setBounds(40, 120, 150, 50);
        j2plantarse.setBounds(200, 120, 150, 50);
        lblj1.setBounds(40, 200, 150, 50);
        lblj2.setBounds(200, 200, 150, 50);
        
        j1tirar.addActionListener(this);
        j2tirar.addActionListener(this);
        j1plantarse.addActionListener(this);
        j2plantarse.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==j1tirar){
            resultadoj1 += dado.tirar();
            lblj1.setText(Integer.toString(resultadoj1));
            if(resultadoj1>=21){
                j1tirar.setVisible(false);
                j1=false;
                JOptionPane.showMessageDialog(this, "Jugador 2 gana");
            }
        }
        
        if(e.getSource()==j2tirar){
            resultadoj2 += dado.tirar();
            lblj2.setText(Integer.toString(resultadoj2));
            if(resultadoj2>=21){
                j2tirar.setVisible(false);
                j2=false;
                JOptionPane.showMessageDialog(this, "Jugador 1 gana");
            }
        }
        
        if(e.getSource()==j1plantarse){
            j1tirar.setVisible(false);
            j1=false;
        }
        
        if(e.getSource()==j2plantarse){
            j2tirar.setVisible(false);
            j2=false;
        }
        
        if(j1==false && j2==false){
            if(resultadoj1<resultadoj2){
                JOptionPane.showMessageDialog(this, "Jugador 2 gana");
            } else         
            if(resultadoj2<resultadoj1){
                JOptionPane.showMessageDialog(this, "Jugador 1 gana");
            } else {
                if(resultadoj1==resultadoj2){
                    JOptionPane.showMessageDialog(this, "Empate");
                }
            }
            juegoacabado=true;
        }
        
//        if(juegoacabado==true){
//            j1tirar.setVisible(true);
//            j2tirar.setVisible(true);
//            resultadoj1=0;
//            resultadoj2=0;
//            lblj1.setText("");
//            lblj2.setText("");
//        }
    }
    
    public static void main(String[] args){
        BlackJackTablero tablero = new BlackJackTablero();
        tablero.setBounds(100,100,400,300);
        tablero.setVisible(true);
    }
}