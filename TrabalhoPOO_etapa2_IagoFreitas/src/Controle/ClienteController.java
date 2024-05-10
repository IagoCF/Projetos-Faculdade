package Controle;

import DAO.ClienteDAO;
import DAO.ConexaoDAO;
import Modelo.Cliente;
import View.ClienteView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ClienteController implements ActionListener {
    private ClienteView view;
    private ClienteDAO dao;

    public ClienteController(ClienteView view, ClienteDAO dao) {
        this.view = view;
        this.dao = dao;
        this.view.cadastrar.addActionListener(this);
        this.view.editar.addActionListener(this);
        this.view.remover.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.cadastrar) {
            cadastrarCliente();
        } else if (e.getSource() == view.editar) {
            editarCliente();
        } else if (e.getSource() == view.remover) {
            removerCliente();
        }
    }

    private void cadastrarCliente() {
        int cpf = Integer.parseInt(view.campoCpf.getText());
        String nome = view.campoNome.getText();
        String email = view.campoEmail.getText();
        String dataTexto = view.campoNascimento.getText();

        //Formatação da data
        java.util.Date nascimento = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            nascimento = sdf.parse(dataTexto);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(view, "Formato de data inválido!");
            return;
        }

        Cliente cliente = new Cliente(cpf, nome, email, nascimento);

        try {
            dao.adicionarCliente(cliente);
            JOptionPane.showMessageDialog(view, "Cliente cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao cadastrar cliente: " + ex.getMessage());
        }
    }

    private void editarCliente() {
        int cpf = Integer.parseInt(view.campoCpf.getText());
        String nome = view.campoNome.getText();
        String email = view.campoEmail.getText();
        String dataTexto = view.campoNascimento.getText();

        // Formatação da data
        java.util.Date nascimento = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            nascimento = sdf.parse(dataTexto);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(view, "Formato de data inválido!");
            return;
        }

        Cliente cliente = new Cliente(cpf, nome, email, nascimento);

        try {
            dao.atualizarCliente(cliente);
            JOptionPane.showMessageDialog(view, "Cliente atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao atualizar cliente: " + ex.getMessage());
        }
    }


    private void removerCliente() {
    	int cpf = Integer.parseInt(view.campoCpf.getText());

    	try {
            dao.removerCliente(cpf);
            JOptionPane.showMessageDialog(view, "Cliente removido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(view, "Erro ao deletar cliente: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        ClienteView view = new ClienteView();
        ClienteDAO dao = new ClienteDAO(ConexaoDAO.obterConexao());
        ClienteController controller = new ClienteController(view, dao);
    }
}
