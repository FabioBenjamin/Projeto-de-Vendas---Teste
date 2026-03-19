package com.SistemaVendas.Controller;

import com.SistemaVendas.Dao.ClienteDAO;
import com.SistemaVendas.Model.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class ClienteController {

    @FXML
    private TableView<Cliente> tblCliente;

    private ClienteDAO dao;

    public void initialize() {

        try {
            dao = new ClienteDAO();
            tblCliente.getItems().setAll(dao.listarClientes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Abrir tela de cadastro
    @FXML
    private void atualizar() {}

    @FXML
    public void excluir() throws Exception {
        Cliente cliente =  tblCliente.getSelectionModel().getSelectedItem();

        if (cliente != null) {
            dao.ExcluirCliente(cliente.getIdCliente());
            tblCliente.getItems().remove(cliente);
        }
    }
}
