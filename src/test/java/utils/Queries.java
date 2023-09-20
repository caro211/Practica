package utils;

public enum Queries {
CONSULTAR_CLIENTE("SELECT cdcliente FROM esqcorebienestarlab.tcob_clientes WHERE cddni='%s';"),
CONSULTAR_VALORACION("SELECT * FROM esqcorebienestarlab.tcob_valoraciones WHERE cdcliente='%s';");

    private final String consulta;

    Queries(String consulta) {
        this.consulta = consulta;
    }

    public String getQuery() {
        return consulta;
    }
}
