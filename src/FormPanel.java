import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel{

    private FormListener formListener;
    private JLabel lblTempMin = new JLabel("Temperatura minima");
    private JLabel lblTempMax = new JLabel("Temperatura maxima");
    private JLabel lblTemperatura = new JLabel("Ingresar Temperatura");
    private JTextField txtTempMin = new JTextField(5);
    private JTextField txtTempMax = new JTextField(5);
    private JTextField txtTemperatura = new JTextField(5);
    private JButton btnSetTemp = new JButton("Establecer Temperatura");


    public FormPanel(){
        //Dimension dimension = getPreferredSize();
        //dimension.width = 250;
        //setPreferredSize(dimension);

        Border innerBorder = BorderFactory.createTitledBorder("Panel de control");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));


        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        //Fila 1
        gc.gridx = 0;
        gc.gridy = 0;
        add(lblTempMin, gc);
        gc.gridx = 1;
        add(txtTempMin);

        // Fila 2
        gc.gridx = 0;
        gc.gridy = 1;
        add(lblTempMax, gc);
        gc.gridx = 1;
        add(txtTempMax, gc);

        //Fila 3
        gc.gridx = 0;
        gc.gridy = 2;
        add(lblTemperatura, gc);
        gc.gridx = 1;
        add(txtTemperatura, gc);

        //Ffila 4
        gc.gridx = 1;
        gc.gridy = 4;
        add(btnSetTemp, gc);

        //Fila

        btnSetTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*String tempMin = txtTempMin.getText();
                String tempMax = txtTempMax.getText();
                String temperatura = txtTempMax.getText();*/

                try {
                    float tempMin = Float.parseFloat(txtTempMin.getText());
                    float tempMax = Float.parseFloat(txtTempMax.getText());
                    float temperatura = Float.parseFloat(txtTemperatura.getText());

                    FormEvent ev = new FormEvent(this, tempMin, tempMax, temperatura);
                    if (formListener != null) {
                        formListener.formEventOcurred(ev);
                    }

                } catch(Exception ex){
                    JOptionPane.showMessageDialog(null, "Favor de ingresar los datos necesarios");
                }
                //String ageCat = (String) ageList.getSelectedValue();

                //System.out.println(ageCat);


            }
        });
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}
