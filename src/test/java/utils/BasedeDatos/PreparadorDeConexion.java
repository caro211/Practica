package utils.BasedeDatos;

public class PreparadorDeConexion {
    private PreparadorDeConexion() {throw new IllegalStateException("Utility class");}

    public static String getHost(String baseUrl, String complemento) {
        return System.getenv(baseUrl).concat(complemento);
    }

    public static String getUsuario(String usuario) {
        return System.getenv(usuario);
    }

    public static String getName(String name) {
        return System.getenv(name);
    }
    public static String getSquema(String squema) {
        return System.getenv(squema);
    }

    public static String getClave(String clave) {
        return System.getenv(clave);
    }


}
