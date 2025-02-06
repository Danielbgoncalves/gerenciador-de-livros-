import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    //private static JTextArea txtAreaListagens;
    public static void main(String[] args) {
        // Algumas variaveis para ajudar no layout
        int txtHeight = 25;
        int btnHeight = 30;
        int btnWidth = 90;
        int txtYPosition = 50;

        // Vamos usando ArrayList
        ArrayList<Obra> obrasListadas = new ArrayList<>();

        //Criar janela da aplicação
        JFrame mainFrame = new JFrame("Gerenciador de Líveis");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(400, 250);
        mainFrame.setLayout(new BorderLayout());

        Image icone = Toolkit.getDefaultToolkit().getImage("./assets/icon.png");
        mainFrame.setIconImage(icone);


        //Cria painéis com CardLayout
        JPanel cards = new JPanel(new CardLayout());

        /// -------------- Painel de Livros --------------
        JPanel painelLivros = new JPanel();
        painelLivros.setLayout(null);
        /* Passar null como parametro deixa a manipulação do layout totalmemte manual; embora possa ser mais
         trabalhoso acho q faz sentido ´colocar mais a mão na massa´ já q esse é o priemiro projeto com o swing
         acho q pode ajduar a entender mais. A desvantagem é q não fica responsivo e tenho que aprender a usar o
         outro depois             */

        JLabel label = new JLabel("Livros");
        label.setBounds(175, 20, 50, 25);

        JLabel livrosTitulo = new JLabel("Título:");
        livrosTitulo.setBounds(30,txtYPosition, 70, txtHeight);
        JTextField txtTitulo = new JTextField();
        txtTitulo.setBounds(90, txtYPosition, 200, txtHeight);

        JLabel livrosAutor = new JLabel("Autor:");
        livrosAutor.setBounds(30,txtYPosition + 30, 70, txtHeight);
        JTextField txtAutor = new JTextField();
        txtAutor.setBounds(90, txtYPosition + 30, 200, txtHeight);

        JLabel livrosAno = new JLabel("Ano:");
        livrosAno.setBounds(30, txtYPosition + 60, 70, txtHeight);
        JTextField txtAno = new JTextField();
        txtAno.setBounds(90, txtYPosition + 60, 100, txtHeight);

        // Seria interessante adicionar alguma verificação da string com trhow new error e tals
        JButton btnIncluir = new JButton("Incluir");
        btnIncluir.setBounds(50, txtYPosition + 110, btnWidth, btnHeight);
        btnIncluir.addActionListener(e -> {
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
                obrasListadas.add(livroCriado);
                JOptionPane.showMessageDialog(mainFrame,"Livro incluído com sucesso!");
                txtTitulo.setText("");
                txtAutor.setText("");
                txtAno.setText("");
            }
            else
           {
               JOptionPane.showMessageDialog(mainFrame,"Não é permitido campo vazio.");
           }

        });

        JButton btnRevistas = new JButton("Revistas");
        btnRevistas.setBounds(150, txtYPosition + 110, btnWidth, btnHeight);

        JButton btnListagens = new JButton("Listagem");
        btnListagens.setBounds(250, txtYPosition + 110, btnWidth, btnHeight);

        painelLivros.add(label);
        painelLivros.add(livrosTitulo);
        painelLivros.add(txtTitulo);
        painelLivros.add(livrosAutor);
        painelLivros.add(txtAutor);
        painelLivros.add(livrosAno);
        painelLivros.add(txtAno);
        painelLivros.add(btnIncluir);
        painelLivros.add(btnRevistas);
        painelLivros.add(btnListagens);

        /// -------------- Painel de Revistas --------------
        JPanel painelRevista = new JPanel();
        painelRevista.setLayout(null);

        JLabel labelR = new JLabel("Revistas");
        labelR.setBounds(175, 20, 50, 25);

        JLabel revistasTitulo = new JLabel("Titulo:");
        revistasTitulo.setBounds(30,txtYPosition, 70, txtHeight);
        JTextField txtTituloR = new JTextField();
        txtTituloR.setBounds(90, txtYPosition, 200, 25);

        JLabel revistasOrg = new JLabel("Org.:");
        revistasOrg.setBounds(30,txtYPosition + 30, 70, txtHeight);
        JTextField txtOrgR = new JTextField();
        txtOrgR.setBounds(90, txtYPosition + 30, 200, 25);

        JLabel revistasVol = new JLabel("Vol.:");
        revistasVol.setBounds(30,txtYPosition + 60, 70, txtHeight);
        JTextField txtVolR = new JTextField();
        txtVolR.setBounds(90, txtYPosition + 60, 55, 25);

        JLabel revistasNmr = new JLabel("Nmr.:");
        revistasNmr.setBounds(160,txtYPosition + 60, 70, txtHeight);
        JTextField txtNmrR = new JTextField();
        txtNmrR.setBounds(200, txtYPosition + 60, 55, 25);

        JLabel revistasAno = new JLabel("Ano:");
        revistasAno.setBounds(270,txtYPosition + 60, 70, txtHeight);
        JTextField txtAnoR = new JTextField();
        txtAnoR.setBounds(310, txtYPosition + 60, 55, 25);

        JButton btnIncluirR = new JButton("Incluir");
        btnIncluirR.setBounds(50, txtYPosition + 110, btnWidth, btnHeight);
        btnIncluirR.addActionListener(e -> {
            String tituloR = txtTituloR.getText();
            String org = txtOrgR.getText();
            String vol = txtVolR.getText();
            String nmr = txtNmrR.getText();
            String anoR = txtAnoR.getText();

            if(!isNumeric(vol) || !isNumeric(nmr) || !isNumeric(anoR) )
            {
                JOptionPane.showMessageDialog(mainFrame,"Tanto \"Vol.\", \"Nmr.\" e \"Ano\" devem ser numéricos.");
            }
            else if (!Objects.equals(tituloR, "") && !Objects.equals(org, "") &&!Objects.equals(vol, "") &&!Objects.equals(nmr, "") &&!Objects.equals(anoR, "") && isNumeric(anoR) && isNumeric(vol) && isNumeric(nmr)  )
            {
                Revista revistaCriada = new Revista(tituloR, anoR, org, vol, nmr);
                obrasListadas.add(revistaCriada);

                JOptionPane.showMessageDialog(mainFrame,"Revista incluída com sucesso!");
                txtTituloR.setText("");
                txtOrgR.setText("");
                txtVolR.setText("");
                txtNmrR.setText("");
                txtAnoR.setText("");
            }
            else
            {
                JOptionPane.showMessageDialog(mainFrame,"Não é permitido campo vazio.");
            }
        });

        JButton btnLivros = new JButton("Livros");
        btnLivros.setBounds(150, txtYPosition + 110, btnWidth, btnHeight);

        JButton btnListagensR = new JButton("Listagem");
        btnListagensR.setBounds(250, txtYPosition + 110, btnWidth, btnHeight);

        painelRevista.add(labelR);
        painelRevista.add(revistasTitulo);
        painelRevista.add(txtTituloR);
        painelRevista.add(revistasOrg);
        painelRevista.add(txtOrgR);
        painelRevista.add(revistasVol);
        painelRevista.add(txtVolR);
        painelRevista.add(revistasNmr);
        painelRevista.add(txtNmrR);
        painelRevista.add(revistasAno);
        painelRevista.add(txtAnoR);
        painelRevista.add(btnIncluirR);
        painelRevista.add(btnLivros);
        painelRevista.add(btnListagensR);

        /// -------------- Painel de Listagens --------------
        CardLayout cl = (CardLayout) cards.getLayout();  // Pertence à configuração dos cards na vdd

        PainelListagens painelListagens = new PainelListagens(cl, cards, "Livros");

        /// -------------- Configuração dos cards --------------
        cards.add(painelRevista, "Revistas");
        cards.add(painelLivros, "Livros");
        cards.add(painelListagens, "Listagens");

        btnRevistas.addActionListener(e -> cl.show(cards, "Revistas"));
        btnLivros.addActionListener(e -> cl.show(cards, "Livros"));
        btnListagens.addActionListener((e -> {
            cl.show(cards, "Listagens");
            painelListagens.atualizarListagens(obrasListadas);
        }));
        btnListagensR.addActionListener((e -> {
            cl.show(cards, "Listagens");
            painelListagens.atualizarListagens(obrasListadas);
        }));

        /// -------------- Configuração da janela --------------
        mainFrame.add(cards, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }

    public static boolean isNumeric(String str){
       // boolean matche = str.matches("//d+");
        //System.out.println("-"+str + ": " + matche + "\n");
        //return matche;
        return str.matches("\\d+");

    }


}