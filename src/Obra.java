public abstract class Obra {
    protected String titulo;
    protected String ano;

    public Obra(String titulo, String ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public abstract String getAsString();



}
