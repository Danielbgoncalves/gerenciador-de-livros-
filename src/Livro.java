public class Livro extends Obra{
    private String autor;

    public Livro(String titulo, String ano, String autor) {
        super(titulo, ano);
        this.autor = autor;
    }

    public String getAsString(){
        return "    " + this.autor + ": " + this.titulo + " - " + this.ano;
    }
}
