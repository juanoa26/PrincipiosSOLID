package co.unicauca.parqueaderopublico.acceso;
import co.unicauca.parqueaderopublico.modelo.VehiculoEnum;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juan SebasOsorio, Diego Vidal Lopez
 */
public class ParqueaderoRepository implements IParqueaderoRepository {
    /**
     * conexion con la base de datos sqlite
     */
    private Connection conexion;
    
    /**
     * Constructor por defecto
     * este inicializa la base de datos y verifica si esta creada la tabla
     */
    public ParqueaderoRepository() {
        initDatabase();
    }
    /**
     * Guarda un vehiculo dentro del parqueadero
     * @param vehiculo recibe el vehiculo
     * @return true o false confirmando el exito de la operacion
     */
    @Override
    public boolean guardarVehiculo(Parqueadero vehiculo) {
        try {
            if (vehiculo == null || vehiculo.getPlaca().isBlank() || 
                vehiculo.getFechaEntrada().toString().isBlank() ||
                vehiculo.getVehiculo().name().isBlank()) {
                return false;
            }
            String sql = "INSERT INTO Vehiculo ( placa, fechaEntrada, tipoVehiculo ) "
                    + "VALUES ( ?, ?, ? )";

            PreparedStatement pstmt = conexion.prepareStatement(sql);
            pstmt.setString(1, vehiculo.getPlaca());
            pstmt.setTimestamp(2, Timestamp.from(vehiculo.getFechaEntrada()));
            pstmt.setObject(3, vehiculo.getVehiculo());
            pstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    /**
     * Lista todos los vehiculos del repositorio creado para el parqueadero
     * sacados de la base de datos
     * @return lista completa de vehiculos en un parqueadero
     */

    @Override
    public List<Parqueadero> lista() {
        List<Parqueadero> vehiculos = new ArrayList<>();
        try {
            String sql = "SELECT placa, fechaEntrada, tipoVehiculo FROM Vehiculo";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Parqueadero newProduct = new Parqueadero();
                newProduct.setPlaca(rs.getString("placa"));
                newProduct.setFechaEntrada(rs.getTimestamp("fechaEntrada").toInstant());
                newProduct.setVehiculo(VehiculoEnum.valueOf(rs.getString("tipoVehiculo")));

                vehiculos.add(newProduct);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehiculos;
    }
    /**
     * Inicializa la base de datos o crea la tabla para el trabajo
     */
    private void initDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS Vehiculo (\n"
                + "	placa varchar2 PRIMARY KEY,\n"
                + "	fechaEntrada timestamp NOT NULL,\n"
                + "	tipoVehiculo varchar2\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conexion.createStatement();
            stmt.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * conecta la base de datos con la api
     */
    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conexion = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Desconecta la base de datos con la api
     */
    public void disconnect() {
        try {
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
   
}
