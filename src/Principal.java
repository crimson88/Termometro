import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal extends JFrame {

    ConexionMySQL interfazMysql;
    java.sql.Connection conexion;

    private FormPanel formPanel;
    private Termometro termometro;
    private TableFromDatabase tableFromDatabase;
    //private SearchResult searchResult;
    private JButton btnBuscar;
    //private JFrame frame;
    //JFrame frame = new JFrame();

    public Principal(){

        super("Termometro v1");

        formPanel = new FormPanel();
        termometro = new Termometro();
        //tableFromDatabase = new TableFromDatabase();
        //searchResult = new SearchResult();
        btnBuscar = new JButton("Mostrar Logs");
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TableFromDatabase frame = new TableFromDatabase();
                //frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
                frame.pack();
                frame.setVisible(true);
            }
        });

        this.setSize(800, 400);
        Container contPrinc = this.getContentPane();
        add(formPanel, BorderLayout.EAST);
        add(termometro, BorderLayout.WEST);
        //add(tableFromDatabase, BorderLayout.SOUTH);
        add(btnBuscar, BorderLayout.SOUTH);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        formPanel.setFormListener(new FormListener() {
            public void formEventOcurred(FormEvent e) {
                float tempMin = e.getTempMin();
                float tempMax = e.getTempMax();
                float temperatura = e.getTemperatura();

                termometro.setT(temperatura);
                termometro.settMax(tempMax);
                termometro.settMin(tempMin);


                if (temperatura< tempMax && temperatura > tempMin) {
                    termometro.setBackground(new Color(0,150,0));
                    JOptionPane.showMessageDialog(null, "Temperatura estable");
                }

                if (temperatura< tempMin) {
                    termometro.setBackground(new Color(0,0,150));
                    ConexionMySQL link = new ConexionMySQL();
                    link.Conectar();
                    link.insertTemp(temperatura);;
                    JOptionPane.showMessageDialog(null, "¡Alerta! Temperatura debajo del mínimo permitido, log guardado");

                }

                if (temperatura> tempMax) {
                    termometro.setBackground(new Color(150,0,0));
                    ConexionMySQL link = new ConexionMySQL();
                    link.Conectar();
                    link.insertTemp(temperatura);
                    JOptionPane.showMessageDialog(null, "¡Alerta! Temperatura arriba del maximo permitido, log guardado");

                }
            }

        });
    }



    public static void main(String[] args){
        Principal Ventana = new Principal();
    }

    /*@Override
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("actConectar")) {

            interfazMysql = new ConexionMySQL();

            conexion = interfazMysql.Conectar();

            if (conexion != null) {

                JOptionPane.showMessageDialog(null, "Conectado");

                try {

                    conexion.close();

                } catch (SQLException ex) {

                    System.out.println("Error al desconectar " + ex);

                }

            }
        }
        else if (e.get.equals("actInsertar")){
            int nRegs = interfazMysql.insertaCliente("Artemisa", "Martinez Prieto", "Conocida");
            System.out.println("Registros insertados: " + nRegs);
        }

        else if (e.getActionCommand().equals("actConsultar")){
            ResultSet regsClientes = interfazMysql.consultarClientes();
            try {
                int cont = 0;
                while (regsClientes.next()) {

                    //se crea un array que sera una de las filas de la tabla
                    Object[] fila = new Object[4];

                    //se rellena cada posicion del array con una de las columas de la tabla en la base de datos
                    for (int i = 0; i < 4; i++)
                        fila[i] = regsClientes.getObject(i + 1);

                    cont++;
                    System.out.println("Registros: " + cont + ", " + regsClientes.getString("nombre")
                            + ", " + regsClientes.getString("apellidos") + ", " + regsClientes.getString("direccion"));
                }
                regsClientes.close();
            }
            catch(SQLException error){
                error.printStackTrace();
            }
        }
    }*/

}
