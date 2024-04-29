package Visao;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import Controle.CadastrarCategoriaController;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

public class CadastroCategoriaInterface extends JFrame implements ActionListener {

    private JLabel labelId, labelNome;
    private JFormattedTextField campoId; // Alterado para JFormattedTextField
    private JTextField campoNome;
    private JButton botaoEnviar;

    public CadastroCategoriaInterface() {
        super("Cadastrar Categoria do Livro");

        // Criando e posicionando os labels
        labelId = new JLabel("ID:");
        labelId.setBounds(10, 10, 80, 25);
        add(labelId);

        labelNome = new JLabel("Nome");
        labelNome.setBounds(10, 40, 80, 25);
        add(labelNome);

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

        // Criando e posicionando o botão "Enviar"
        botaoEnviar = new JButton("Enviar");
        botaoEnviar.setBounds(100, 70, 100, 25);
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
                CadastrarCategoriaController cadastrarCategoriaController = new CadastrarCategoriaController();
                cadastrarCategoriaController.salvarCategoria(idLivro, campoNome.getText());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
