import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PainelVideos extends JPanel{
    private ArrayList<Obra> listaObras;
    private JFrame mainFrame;
    private PainelListagens painelDeListagens;

    int txtYPosition = 50;
    int txtHeight = 25;
    int btnWidth = 90;
    int btnHeight = 30;

    JLabel label = new JLabel("Vídeos");
    JLabel videoTitulo = new JLabel("Título:");
    JTextField txtTitulo = new JTextField();
    JLabel videoAno = new JLabel("Ano:");
    JTextField txtAno = new JTextField();
    JLabel videoDuracao = new JLabel("Duração:");
    JTextField txtDuracao = new JTextField();
    JLabel videoAutor = new JLabel("Autor:");
    JTextField txtAutor = new JTextField();

    JButton btnIncluir = new JButton("Incluir");
    JButton btnRevistas = new JButton("Revistas");
    JButton btnLivros = new JButton("Livros");
    JButton btnListagens = new JButton("Listagem");

    PainelVideos(CardLayout cl, JPanel cards, JFrame mainFrame, ArrayList<Obra> lista, PainelListagens painelListagens ){
        this.mainFrame = mainFrame;
        this.listaObras = lista;
        this.painelDeListagens = painelListagens;
        setLayout(null);

        label.setBounds(175, 20, 50, 25);

        videoTitulo.setBounds(30,50, 70, 25);
        txtTitulo.setBounds(90, 50, 200, 25);

        videoAno.setBounds(30,txtYPosition + 30, 70, txtHeight);
        txtAno.setBounds(90, txtYPosition + 30, 200, 25);

        videoDuracao.setBounds(30,txtYPosition + 60, 70, txtHeight);
        txtDuracao.setBounds(90, txtYPosition + 60, 80, 25);

        videoAutor.setBounds(190,txtYPosition + 60, 70, txtHeight);
        txtAutor.setBounds(240, txtYPosition + 60, 80, 25);

        btnIncluir.setBounds(50, txtYPosition + 110, btnWidth, btnHeight);
        btnRevistas.setBounds(150, txtYPosition + 110, btnWidth, btnHeight);
        btnLivros.setBounds(250, txtYPosition + 110, btnWidth, btnHeight);
        btnListagens.setBounds(350, txtYPosition + 110, btnWidth, btnHeight);

        btnRevistas.addActionListener(e -> cl.show(cards, "Revistas"));
        btnLivros.addActionListener(e -> cl.show(cards, "Livros"));
        btnIncluir.addActionListener(e -> incluirVideo());
        btnListagens.addActionListener((e -> {
            cl.show(cards, "Listagens");
            painelDeListagens.atualizarListagens(listaObras);
        }));

        add(label);
        add(videoTitulo);
        add(txtTitulo);
        add(videoAno);
        add(txtAno);
        add(videoDuracao);
        add(txtDuracao);
        add(videoAutor);
        add(txtAutor);
        add(btnIncluir);
        add(btnLivros);
        add(btnRevistas);
        add(btnListagens);
    }

    private void incluirVideo(){
        String titulo = txtTitulo.getText();
        String ano = txtAno.getText();
        String duracao = txtDuracao.getText();
        String autor = txtAutor.getText();

        if(!isNumeric(ano))
        {
            JOptionPane.showMessageDialog(mainFrame,"O campo \"Ano\" ser numérico.");
        }
        else if(!isHour(duracao))
        {
            JOptionPane.showMessageDialog(mainFrame,"O campo \"Duração\" de ser do tipo horas:minutos.");
        }
        else if(titulo.isEmpty() || autor.isEmpty() )
        {
            JOptionPane.showMessageDialog(mainFrame,"Não é permitido campo vazio.");
        }
        else
        {
            Video videoCriado = new Video(ano, titulo, autor, duracao);
            listaObras.add(videoCriado);

            JOptionPane.showMessageDialog(mainFrame, "Vídeo incluído com sucesso!");
            txtTitulo.setText("");
            txtAno.setText("");
            txtDuracao.setText("");
            txtAutor.setText("");
        }
    }


    private boolean isNumeric(String str){
        return str.matches("\\d+");
    }

    private boolean isHour(String str){
        return str.matches("^\\d+:\\d+$");
    }
}
