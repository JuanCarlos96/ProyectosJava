package Memo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Carta extends JLabel implements Cloneable{
    private String image;
    private JLabel carta;
    private boolean tapada;

    public Carta(String image) {
        super();
        setIcon(new ImageIcon(getClass().getResource("/Memo/res/reverso.png")));
        this.image = image;
        this.tapada = true;
    }
    
    public void tapar(boolean tapada) {
        if (tapada) {
            this.setIcon(new ImageIcon(getClass().getResource("/Memo/res/reverso.png"))); 
        } else {
            this.setIcon(new ImageIcon(getClass().getResource(image))); 
        }
        this.tapada = tapada;
    }

    public boolean isTapada() {
        return tapada;
    }

    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public JLabel getCarta() {
        return carta;
    }

    public void setCarta(JLabel carta) {
        this.carta = carta;
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}