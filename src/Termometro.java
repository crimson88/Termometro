import javax.swing.*;
import java.awt.*;

public class Termometro extends JPanel {

    private FormPanel formPanel;
    public float tMax;
    public float tMin;
    public float t;

    public float gettMax() {
        return tMax;
    }

    public void settMax(float tMax) {
        this.tMax = tMax;
    }

    public float gettMin() {
        return tMin;
    }

    public void settMin(float tMin) {
        this.tMin = tMin;
    }

    public float getT() {
        return t;
    }

    public void setT(float t) {
        this.t = t;
    }

//FormEvent s = new FormEvent();

    public Termometro() {
        setBackground(Color.GRAY);
        setPreferredSize(new Dimension(400,400));

        /*formPanel = new FormPanel();

        formPanel.setFormListener(new FormListener() {
            public void formEventOcurred(FormEvent e) {
                float tempMin = e.getTempMin();
                float tempMax = e.getTempMax();
                float temperatura = e.getTemperatura();

                System.out.println(tempMin);
                System.out.println(temperatura);
                System.out.println(tempMax);
                if (temperatura> 0 & temperatura< 25) {
                    setBackground(Color.green);
                }

                if (temperatura> 24 & temperatura< 50) {
                    setBackground(Color.yellow);
                }

                if (temperatura> 50) {
                    setBackground(Color.red);

                }
            }

        });*/

    }


    @Override
    public void paint(Graphics g) {
        String tMinS =  String.valueOf(tMin);
        String tMaxS =  String.valueOf(tMax);
        int tMaxI = (int)tMax;
        int tMinI = (int)tMin;
        int tI = (int)t;
        int wOval = 150;
        int hOval = 150;
        int posX = 80;
        int posY = 150;
        int grados = 360;
        int angIni = 180;

        super.paint(g);
        g.setColor(Color.black);
        {
            g.drawOval(posX-1, posY-1, wOval+2, hOval+2);
        }
        g.setColor(Color.black);
        g.drawString("Temp. Min: " + tMinS, 20, 300);
        g.drawString("Temp. Max: " + tMaxS, 200, 300);
        g.setColor(Color.white);
        g.fillOval(posX, posY, wOval, hOval);

        if (this.t > tMin & this.t < tMax) {
            g.setColor(Color.GREEN);
            g.fillArc(posX, posY, wOval, hOval, angIni, -(grados/tMaxI*tI));
            g.setColor(Color.black);
            g.drawString(this.t + "ºC", 150, 220);
        }

        if (this.t < tMin) {
            g.setColor(Color.blue);
            g.fillArc(posX, posY, wOval, hOval, angIni, -(grados/tMaxI*tI));
            g.setColor(Color.black);
            g.drawString(this.t + "ºC", 150, 220);
        }

        if (this.t > tMaxI) {
            g.setColor(Color.red);
            g.fillArc(posX, posY, wOval, hOval, angIni, -(grados));
            g.setColor(Color.black);
            g.drawString(this.t + "ºC", 150, 220);
        }

    }

}
