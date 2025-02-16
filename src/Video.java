public class Video extends Obra{
    private String autor;
    private String duracao;

    public Video(String ano, String titulo, String autor, String duracao){
        super(titulo, ano);
        this.autor = autor;
        this.duracao = duracao;
    }

    public String getAsString(){
        return  "\tVídeo: " +  this.titulo + " - " + this.autor + " - " + this.ano + " - " + this.duracao;
    }

}
