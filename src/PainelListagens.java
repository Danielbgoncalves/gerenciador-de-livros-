import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PainelListagens extends JPanel {
    private JTextArea txtAreaListagens;

    public PainelListagens(CardLayout cl, JPanel cards){
        setLayout(new BorderLayout());

        txtAreaListagens = new JTextArea();
        txtAreaListagens.setEditable(false);
        JScrollPane scrollPane= new JScrollPane(txtAreaListagens);
        add(scrollPane, BorderLayout.CENTER);

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> cl.show(cards, "Livros"));
        add(btnVoltar, BorderLayout.SOUTH);

        txtAreaListagens.setText("");
    }

    public void atualizarListagens(ArrayList<Obra> obras){
        txtAreaListagens.setText("");
        if(obras.isEmpty()){
            txtAreaListagens.append("""
                    ===================================================================
                    \t   No momento não há obras listadas,
                    \t   experimente adicionar alguma
                    ===================================================================
                    """);
        } else {
            for(Obra obra: obras){
                txtAreaListagens.append(obra.getAsString() + "\n");
            }
        }

    }
}
