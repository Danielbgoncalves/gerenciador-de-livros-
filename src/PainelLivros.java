import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class PainelLivros extends JPanel {
    private ArrayList<Obra> listaObras;
    private JFrame mainFrame;
    private PainelListagens painelDeListagens;

    private int txtYPosition = 50;
    private int txtHeight = 25;
    private int btnWidth = 90;
    private int btnHeight = 30;

    JLabel label = new JLabel("Livros");
    JLabel livrosTitulo = new JLabel("Título:");
    JTextField txtTitulo = new JTextField();
    JLabel livrosAutor = new JLabel("Autor:");
    JTextField txtAutor = new JTextField();
    JLabel livrosAno = new JLabel("Ano:");
    JTextField txtAno = new JTextField();
    JButton btnIncluir = new JButton("Incluir");
    JButton btnRevistas = new JButton("Revistas");
    JButton btnVideos = new JButton("Videos");
    JButton btnListagens = new JButton("Listagem");


    PainelLivros(CardLayout cl, JPanel cards, JFrame mainFrame, ArrayList<Obra> lista, PainelListagens painelListagens){
        this.mainFrame = mainFrame;
        this.listaObras = lista;
        this.painelDeListagens = painelListagens;
        setLayout(null);

        label.setBounds(175, 20, 50, 25);
        livrosTitulo.setBounds(30,txtYPosition, 70, txtHeight);
        txtTitulo.setBounds(90, txtYPosition, 200, txtHeight);
        livrosAutor.setBounds(30,txtYPosition + 30, 70, txtHeight);
        txtAutor.setBounds(90, txtYPosition + 30, 200, txtHeight);
        livrosAno.setBounds(30, txtYPosition + 60, 70, txtHeight);
        txtAno.setBounds(90, txtYPosition + 60, 100, txtHeight);

        btnIncluir.setBounds(50, txtYPosition + 110, btnWidth, btnHeight);
        btnRevistas.setBounds(150, txtYPosition + 110, btnWidth, btnHeight);
        btnVideos.setBounds(250, txtYPosition + 110, btnWidth, btnHeight);
        btnListagens.setBounds(350, txtYPosition + 110, btnWidth, btnHeight);

        btnRevistas.addActionListener(e -> cl.show(cards, "Revistas"));
        btnVideos.addActionListener(e -> cl.show(cards, "Videos"));
        btnIncluir.addActionListener((e -> incluirLivro()));
        btnListagens.addActionListener(e -> {
            cl.show(cards, "Listagens");
            painelDeListagens.atualizarListagens(listaObras);
        });

        add(label);
        add(livrosTitulo);
        add(txtTitulo);
        add(livrosAutor);
        add(txtAutor);
        add(livrosAno);
        add(txtAno);
        add(btnIncluir);
        add(btnRevistas);
        add(btnVideos);
        add(btnListagens);
    }

    private void incluirLivro(){
        String titulo = txtTitulo.getText();
        String autor = txtAutor.getText();
        String ano = txtAno.getText();
        if(!isNumeric(ano))
        {
            JOptionPane.showMessageDialog(mainFrame,"O campo \"ano\" deve ser numérico");
        }
        else if (!Objects.equals(titulo, "") && !Objects.equals(autor, "") && !Objects.equals(ano, "") )
        {
            Livro livroCriado = new Livro(titulo, ano, autor);
            listaObras.add(livroCriado);

            JOptionPane.showMessageDialog(mainFrame,"Livro incluído com sucesso!");
            txtTitulo.setText("");
            txtAutor.setText("");
            txtAno.setText("");
        }
        else
        {
            JOptionPane.showMessageDialog(mainFrame,"Não é permitido campo vazio.");
        }
    }

    private boolean isNumeric(String str){
        return str.matches("\\d+");
    }
}
