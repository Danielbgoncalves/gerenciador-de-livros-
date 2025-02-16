import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class PainelRevistas extends JPanel implements FunctionHelper {
    private ArrayList<Obra> listaObras;
    private JFrame mainFrame;
    private PainelListagens painelDeListagens;

    private int txtYPosition = 50;
    private int txtHeight = 25;
    private int btnWidth = 90;
    private int btnHeight = 30;

    JLabel labelR = new JLabel("Revistas");
    JLabel revistasTitulo = new JLabel("Titulo:");
    JTextField txtTitulo = new JTextField();
    JLabel revistasOrg = new JLabel("Org.:");
    JTextField txtOrg = new JTextField();
    JLabel revistasVol = new JLabel("Vol.:");
    JTextField txtVol = new JTextField();
    JLabel revistasNmr = new JLabel("Nmr.:");
    JTextField txtNmr = new JTextField();
    JLabel revistasAno = new JLabel("Ano:");
    JTextField txtAno = new JTextField();

    JButton btnIncluir = new JButton("Incluir");
    JButton btnLivros = new JButton("Livros");
    JButton btnVideos = new JButton("Videos");
    JButton btnListagens = new JButton("Listagem");

    PainelRevistas(CardLayout cl, JPanel cards, JFrame mainFrame, ArrayList<Obra> lista, PainelListagens painelListagens ){
        this.mainFrame = mainFrame;
        this.listaObras = lista;
        this.painelDeListagens = painelListagens;
        setLayout(null);

        labelR.setBounds(175, 20, 50, 25);
        revistasTitulo.setBounds(30,txtYPosition, 70, txtHeight);
        txtTitulo.setBounds(90, txtYPosition, 200, 25);
        revistasOrg.setBounds(30,txtYPosition + 30, 70, txtHeight);
        txtOrg.setBounds(90, txtYPosition + 30, 200, 25);
        revistasVol.setBounds(30,txtYPosition + 60, 70, txtHeight);
        txtVol.setBounds(90, txtYPosition + 60, 55, 25);
        revistasNmr.setBounds(160,txtYPosition + 60, 70, txtHeight);
        txtNmr.setBounds(200, txtYPosition + 60, 55, 25);
        revistasAno.setBounds(270,txtYPosition + 60, 70, txtHeight);
        txtAno.setBounds(310, txtYPosition + 60, 55, 25);

        btnIncluir.setBounds(50, txtYPosition + 110, btnWidth, btnHeight);
        btnLivros.setBounds(150, txtYPosition + 110, btnWidth, btnHeight);
        btnVideos.setBounds(250, txtYPosition + 110, btnWidth, btnHeight);
        btnListagens.setBounds(350, txtYPosition + 110, btnWidth, btnHeight);

        btnVideos.addActionListener(e -> cl.show(cards, "Videos"));
        btnLivros.addActionListener(e -> cl.show(cards, "Livros"));
        btnIncluir.addActionListener(e -> incluirRevista() );
        btnListagens.addActionListener((e -> {
            cl.show(cards, "Listagens");
            painelListagens.atualizarListagens(listaObras);
        }));

        add(labelR);
        add(revistasTitulo);
        add(txtTitulo);
        add(revistasOrg);
        add(txtOrg);
        add(revistasVol);
        add(txtVol);
        add(revistasNmr);
        add(txtNmr);
        add(revistasAno);
        add(txtAno);
        add(btnIncluir);
        add(btnLivros);
        add(btnVideos);
        add(btnListagens);
    }

    private void incluirRevista(){
        String titulo = txtTitulo.getText();
        String org = txtOrg.getText();
        String vol = txtVol.getText();
        String nmr = txtNmr.getText();
        String ano = txtAno.getText();

        if(!FunctionHelper.isNumeric(vol) || !FunctionHelper.isNumeric(nmr) || !FunctionHelper.isNumeric(ano) )
        {
            JOptionPane.showMessageDialog(mainFrame,"Tanto \"Vol.\", \"Nmr.\" e \"Ano\" devem ser numéricos.");
        }
        else if (!Objects.equals(titulo, "") && !Objects.equals(org, "") &&!Objects.equals(vol, "")
                &&!Objects.equals(nmr, "") &&!Objects.equals(ano, "") && FunctionHelper.isNumeric(ano) &&
                FunctionHelper.isNumeric(vol) && FunctionHelper.isNumeric(nmr)  )
        {
            Revista revistaCriada = new Revista(titulo, ano, org, vol, nmr);
            listaObras.add(revistaCriada);

            JOptionPane.showMessageDialog(mainFrame,"Revista incluída com sucesso!");
            txtTitulo.setText("");
            txtOrg.setText("");
            txtVol.setText("");
            txtNmr.setText("");
            txtAno.setText("");
        }
        else
        {
            JOptionPane.showMessageDialog(mainFrame,"Não é permitido campo vazio.");
        }
    }


}
