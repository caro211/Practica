package utils.BasedeDatos;

import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static utils.BasedeDatos.PreparadorDeConexion.getHost;
import static utils.BasedeDatos.PreparadorDeConexion.getName;
import static utils.BasedeDatos.PreparadorDeConexion.getUsuario;


public class BaseDatosConexion {

    private static final String HOST = "HOST";
    private static final String USUARIO_CON = "USUARIO_BD";
    private static final String CLAVE_CON = "PASSWORD_BD";
    private static final String AMBIENTE = "AMBIENTE";
    private static final String DBNAME="/labcorebienestar";
    private static final String DBSQUEMA="esqcorebienestarlab";

    public static final int PRIMER_REGISTRO = 0;

    private static Connection conexion;

    private BaseDatosConexion() {throw new IllegalStateException("Utility class");}

    private static void conectarCon(String baseDeDatos) throws SQLException {
        conexion = null;
        try {

            String host = getHost(HOST, DBNAME);
            conexion = DriverManager.getConnection(host,getUsuario(USUARIO_CON), getUsuario(CLAVE_CON));
        } catch (SQLException ex) {
            throw new SQLException("Error al conectar con la base de datos Postgresql", ex);
        }
    }


    private static void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
            conexion = null;
        }
    }

    /**
     * @param baseDeDatos a qué base de datos debe ir a consultar
     * @param consulta    sentencia que espera ejecutar
     * @throws SQLException
     */
    public static void ejecutaLaSentencia(String baseDeDatos, String consulta) throws SQLException {
        conectarCon(baseDeDatos);
        try (Statement statement = conexion.createStatement()) {
            statement.execute(consulta);
        } catch (SQLException ex) {
            throw new SQLException("No pudo realizar la consulta a base de datos", ex);
        } finally {
            desconectar();
        }
    }

    /**
     * @param baseDeDatos a qué base de datos debe ir a consultar
     * @param consulta    sentencia que espera ejecutar
     * @return todas las ocurrencias de respuesta en el resulset
     * @throws SQLException
     */
    public static List<String> consultar(String baseDeDatos, String consulta) throws SQLException {
        List<String> informacion = new ArrayList<>();
        conectarCon(baseDeDatos);
        ResultSet resultadoConsulta;
        try (Statement statement = conexion.createStatement()) {
            resultadoConsulta = statement.executeQuery(consulta);
            while (resultadoConsulta.next()){
                informacion.add(resultadoConsulta.getString(1));
            }
        } catch (SQLException ex) {
            throw new SQLException("No pudo realizar la consulta a base de datos", ex);
        } finally {
            desconectar();
        }
        return informacion;
    }
}
