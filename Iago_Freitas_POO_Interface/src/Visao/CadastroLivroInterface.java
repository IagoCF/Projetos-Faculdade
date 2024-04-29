package Visao;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import Controle.CadastrarLivroController;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;


public class CadastroLivroInterface extends JFrame implements ActionListener {

    private JRadioButton fisicoRadioButton;
    private JRadioButton digitalRadioButton;
    private JLabel labelId, labelNome, labelAutor, labelTipo;
    private JFormattedTextField campoId; // Alterado para JFormattedTextField
    private JTextField campoNome, campoAutor, campoTipo;
    private JButton botaoEnviar;

    public CadastroLivroInterface() {
        super("Cadastrar Livro");

        // Criando e posicionando os labels
        labelId = new JLabel("ID:");
        labelId.setBounds(10, 10, 80, 25);
        add(labelId);

        labelNome = new JLabel("Nome");
        labelNome.setBounds(10, 40, 80, 25);
        add(labelNome);

        labelAutor = new JLabel("Autor:");
        labelAutor.setBounds(10, 70, 80, 25);
        add(labelAutor);
        
        labelTipo = new JLabel("Tipo:");
        labelTipo.setBounds(10, 100, 80, 25);
        add(labelTipo);

        // Criando e posicionando os campos de texto
        try {
            MaskFormatter formatter = new MaskFormatter("#####");
            formatter.setPlaceholderCharacter('0');
            campoId = new JFormattedTextField(formatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        campoId.setBounds(90, 10, 200, 25);
        add(campoId);

        campoNome = new JTextField();
        campoNome.setBounds(90, 40, 200, 25);
        add(campoNome);

        campoAutor = new JTextField();
        campoAutor.setBounds(90, 70, 200, 25);
        add(campoAutor);

        campoTipo = new JTextField();
        campoTipo.setBounds(90, 100, 200, 25);
        add(campoTipo);

        // Criando e posicionando o botão "Enviar"
        botaoEnviar = new JButton("Enviar");
        botaoEnviar.setBounds(100, 130, 100, 25);
        botaoEnviar.addActionListener(this); // Adicionando listener ao botão
        add(botaoEnviar);

        // Definindo layout e propriedades da tela
        setLayout(null);
        setSize(320, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoEnviar) {
            int idLivro = Integer.parseInt(campoId.getText()); // Convertendo o texto do campoId para int
            
            TelaResultado telaImpressao = new TelaResultado(campoNome.getText());
            telaImpressao.setVisible(true);
            
            try {
                CadastrarLivroController cadastrarLivroController = new CadastrarLivroController();
                cadastrarLivroController.salvarLivro(idLivro, campoNome.getText(), campoAutor.getText(), new Date(), campoTipo.getText());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new CadastroLivroInterface();
        new CadastroCategoriaInterface();
        new VinculoInterface();
    }
}
