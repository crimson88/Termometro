import java.sql.*;
import javax.swing.JOptionPane;

public class ConexionMySQL {

    public String db = "temperaturas";
    public String url = "jdbc:mysql://localhost/"+ db + "?useServerPrepStmts=true"
            + "&useJDBCCompliantTimezoneShift=true"
            + "&useLegacyDatetimeCode=false"
            + "&serverTimezone=UTC";
    public String user = "root";
    public String pass = "elite";

    Connection link;


    public Connection Conectar(){

        //Connection link = null;

        try{

            //Class.forName("org.gjt.mm.mysql.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);

        }catch(Exception ex){

            JOptionPane.showMessageDialog(null, ex);

        }

        return link;

    }
    /*public static void main(String args[]) {
        System.out.println("hola");
        ConexionMySQL con = new ConexionMySQL();
        con.Conectar();
        con.insertTemp(30);
    }*/

    public int insertTemp(float temperatura){
        int contRegIns = 0;
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

        try {
            PreparedStatement stInsertTemp = link.prepareStatement("INSERT INTO logtemperatura(temperatura, fecha) " + "VALUES (?,?)");
            stInsertTemp.setFloat(1, temperatura);
            stInsertTemp.setTimestamp(2, date);

            contRegIns = stInsertTemp.executeUpdate();

            stInsertTemp.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return contRegIns;
    }

}
