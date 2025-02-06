public class Revista extends Obra{
    private String organizacao;
    private String volume;
    private String numero;

    public Revista(String titulo, String ano, String organizacao, String volume, String numero) {
        super(titulo, ano);
        this.organizacao = organizacao;
        this.volume = volume;
        this.numero = numero;
    }

    @Override
    public String getAsString() {
        return  "    " + this.titulo + ": " + this.volume + " Nmr.: " + this.numero + " Ano: " + this.ano + " - " + this.organizacao;
    }
}
