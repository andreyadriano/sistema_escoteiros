package engtelecom.bcd.lobinho.enums;

public enum Modalidade {
    AR("ar"),
    MAR("mar"),
    BASICO("basico");

    private String tipo;

    Modalidade(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
