import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Vamos usando ArrayList
        ArrayList<Obra> obrasListadas = new ArrayList<>();

        //Criar janela da aplicação
        JFrame mainFrame = new JFrame("Gerenciador de Obras");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 250);
        mainFrame.setLayout(new BorderLayout());

        Image icone = Toolkit.getDefaultToolkit().getImage("./assets/icon.png");
        mainFrame.setIconImage(icone);

        /// -------------- Cria painéis com CardLayout --------------
        JPanel cards = new JPanel(new CardLayout());

        /// -------------- Configuração dos cards --------------
        CardLayout cl = (CardLayout) cards.getLayout();

        /// -------------- Painel de Listagens --------------
        PainelListagens painelListagens = new PainelListagens(cl, cards);

        /// -------------- Painel de Livros --------------
        PainelLivros painelLivros = new PainelLivros(cl, cards, mainFrame, obrasListadas, painelListagens);

        /// -------------- Painel de Revistas --------------
        PainelRevistas painelRevistas = new PainelRevistas(cl, cards, mainFrame, obrasListadas, painelListagens);

        /// -------------- Painel de Vídeos --------------
        PainelVideos painelVideos = new PainelVideos(cl, cards, mainFrame, obrasListadas, painelListagens);

        /// -------------- Configuração dos cards --------------
        cards.add(painelRevistas, "Revistas");
        cards.add(painelLivros, "Livros");
        cards.add(painelVideos, "Videos");
        cards.add(painelListagens, "Listagens");

        /// -------------- Configuração da janela --------------
        mainFrame.add(cards, BorderLayout.CENTER);
        mainFrame.setVisible(true);
    }

}