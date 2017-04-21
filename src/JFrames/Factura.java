package JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Factura extends JFrame implements ActionListener{
    private JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
    private JButton btn;
    private JTextField txt1,txt2,txt3,txt4,txt5;
    private JComboBox combo;
    private JRadioButton rdbtn1,rdbtn2;
    private ButtonGroup btngroup;
    private JCheckBox chkbox;

    public Factura() {
        this.setLayout(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        lbl1 = new JLabel();
        lbl2 = new JLabel();
        lbl3 = new JLabel();
        lbl4 = new JLabel();
        lbl5 = new JLabel();
        lbl6 = new JLabel();
        lbl7 = new JLabel();
        btn = new JButton();
        txt1 = new JTextField();
        txt2 = new JTextField();
        txt3 = new JTextField();
        txt4 = new JTextField();
        txt5 = new JTextField();
        combo = new JComboBox();
        rdbtn1 = new JRadioButton();
        rdbtn2 = new JRadioButton();
        btngroup = new ButtonGroup();
        chkbox = new JCheckBox("IVA");
        
        //Texto Nombre
        lbl1.setBounds(10, 10, 80, 40);
        lbl1.setText("Nombre");
        add(lbl1);
        
        //Campo Nombre
        txt1.setBounds(10, 40, 80, 20);
        add(txt1);
        
        //Texto Fecha
        lbl2.setBounds(200, -20, 100, 100);
        lbl2.setText("Fecha");
        add(lbl2);
        
        //Campo Fecha
        txt2.setBounds(200, 40, 80, 20);
        add(txt2);
        
        //Texto Descuento
        lbl3.setBounds(390, 10, 80, 40);
        lbl3.setText("Descuento");
        add(lbl3);
        
        //Desplegable Descuento
        combo.setBounds(390, 40, 80, 20);
        add(combo);
        combo.addItem("Ninguno");
        combo.addItem("20%");
        combo.addItem("50%");
        
        //Texto Producto
        lbl4.setBounds(10, 120, 80, 40);
        add(lbl4);
        lbl4.setText("Producto");
        
        //Campo Producto
        txt3.setBounds(10, 150, 80, 20);
        add(txt3);
        
        //Texto Cantidad
        lbl5.setBounds(200, 120, 80, 40);
        add(lbl5);
        lbl5.setText("Cantidad");
        
        //Campo Cantidad
        txt4.setBounds(200, 150, 80, 20);
        add(txt4);
        
        //CheckBox IVA
        chkbox.setBounds(390, 120, 80, 40);
        add(chkbox);
        
        //Texto Precio
        lbl6.setBounds(200, 200, 80, 40);
        add(lbl6);
        lbl6.setText("Precio");
        
        //Campo Precio
        txt5.setBounds(200, 230, 80, 20);
        add(txt5);
        
        //Texto Envio
        lbl7.setBounds(390, 200, 80, 40);
        add(lbl7);
        lbl7.setText("Envío");
        
        //Botones Radio
        btngroup.add(rdbtn1);
        btngroup.add(rdbtn2);
        rdbtn1.setBounds(390, 230, 100, 20);
        add(rdbtn1);
        rdbtn1.setText("Normal 1€");
        rdbtn2.setBounds(390, 250, 100, 20);
        add(rdbtn2);
        rdbtn2.setText("Urgente 5€");
        
        //Botón Calcular Factura
        btn.setBounds(170, 310, 150, 40);
        btn.setText("Calcular factura");
        add(btn);
        btn.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String factura;
        if(txt1.getText().isEmpty() || txt2.getText().isEmpty() || txt3.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "¡Debe rellenar todos los campos y de manera adecuada!");
        }else{
            try{
                //Factura
                factura = "Nombre: "+txt1.getText()+"\n"+
                    "Fecha: "+txt2.getText()+"\n"+
                    "------------------------------------------\n"+
                    "Producto\n"+
                    txt3.getText()+"      |Unidad(es): "+txt4.getText()+"         |Precio: "+txt5.getText()+"\n"+
                    "--------------------------------------------------\n";

                float pvp,descuento,pvpfinal;
                int cantidad;

                cantidad = Integer.parseInt(txt4.getText());

                //Cálculo Descuento
                if(combo.getSelectedItem().equals("20%")){
                    pvp = Float.parseFloat(txt5.getText())*cantidad;
                    descuento = (pvp*20)/100;
                    pvpfinal = pvp - descuento;
                    factura += "Subtotal: "+pvp+"\n"+
                        "Descuento "+combo.getSelectedItem().toString()+": "+descuento+"\n";
                }else{
                    if(combo.getSelectedItem().equals("50%")){
                    pvp = Float.parseFloat(txt5.getText())*cantidad;
                    descuento = (pvp*50)/100;
                    pvpfinal = pvp - descuento;
                    factura += "Subtotal: "+pvp+"\n"+
                        "Descuento "+combo.getSelectedItem().toString()+": "+descuento+"\n";
                    }else{
                       pvpfinal = Float.parseFloat(txt5.getText())*cantidad;
                       factura += "Subtotal: "+pvpfinal+"\n";
                    }
                }

                //Cálculo de IVA
                if(chkbox.isSelected()){
                    float iva = (pvpfinal*21)/100;
                    pvpfinal += iva;
                    factura += "IVA 21%: "+iva+"\n";
                }

                //Importe del envío
                if(rdbtn1.isSelected()){
                    pvpfinal += 1;
                    factura += "Método de envío seleccionado: "+rdbtn1.getText()+"\n"+
                            "---------------------------------\n"+
                            "Precio Total: "+pvpfinal;
                }
                if(rdbtn2.isSelected()){
                    pvpfinal += 5;
                    factura += "Método de envío seleccionado: "+rdbtn2.getText()+"\n"+
                            "---------------------------------\n"+
                            "Precio Total: "+pvpfinal;
                }
                if(!rdbtn1.isSelected() && !rdbtn2.isSelected()){
                    factura = "Debe seleccionar un método de envío";
                }
            }catch(Exception exception){
                factura = "¡Debe rellenar todos los campos y de manera adecuada!";
            }
            JOptionPane.showMessageDialog(this, factura);
        }
    }
    
    public static void main(String[] args){
        Factura factura = new Factura();
        factura.setBounds(100,100,520,400);
        factura.setVisible(true);
    }
}