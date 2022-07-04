package Controller;

import db.SQLite;
import entities.Cliente;
import entities.Produto;
import entities.VendaProduto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VendaController {

    @FXML
    private TextField tfCliente;

    @FXML
    private Label lbClienteSelecionado;

    @FXML
    private TextField tfProduto;

    @FXML
    private Label lbProdutoSelecionado;

    @FXML
    private TableView twprodutos;

    @FXML
    private TableColumn<VendaProduto, String>  tcCodigo;
    @FXML
    private TableColumn<VendaProduto, String>  tcDescricao;
    @FXML
    private TableColumn<VendaProduto, Integer> tcQuantidade;
    @FXML
    private TableColumn<VendaProduto, Double>  tcUnitario;
    @FXML
    private TableColumn<VendaProduto, Double>  tcTotal;

    public void clickProcurarCliente(Event e) throws SQLException, ClassNotFoundException {
        Alert alertProcuraCliente = new Alert(Alert.AlertType.INFORMATION, "");
        Integer codigo = Integer.parseInt(tfCliente.getText());

        SQLite db = new SQLite();
        Cliente cliente = db.getClienteforCodigo(codigo);

        if (cliente.getNome() == null) {
            lbClienteSelecionado.setText("...");
            tfCliente.setText("");
            tfCliente.requestFocus();
            alertProcuraCliente.setContentText("Cliente não encontrado, favor informe um cliente valido");
            alertProcuraCliente.show();

        }else{
            lbClienteSelecionado.setText(cliente.getNome());
            tfProduto.requestFocus();
        }
    }

    public void clickProcurarProduto(Event e) throws SQLException, ClassNotFoundException {
        Alert alertProcuraCliente = new Alert(Alert.AlertType.INFORMATION, "");
        Integer codigo = Integer.parseInt(tfProduto.getText());

        SQLite db = new SQLite();
        Produto produto = db.getProdutoforCodigo(codigo);

        if (produto.getDescricao().isEmpty()) {
            lbProdutoSelecionado.setText("...");
            tfProduto.setText("");
            tfProduto.requestFocus();
            alertProcuraCliente.setContentText("Produto não encontrado, favor informe um produto valido");
            alertProcuraCliente.show();
        }else{
            lbProdutoSelecionado.setText(produto.getDescricao());
        }
    }

    public void clickIncluirProduto(Event e) throws SQLException, ClassNotFoundException {

        Alert alertIncluirProduto = new Alert(Alert.AlertType.INFORMATION, "");

        if (lbProdutoSelecionado.getText().equals("...")){
            alertIncluirProduto.setContentText("Selecione um produto antes de incluir na venda ");
            alertIncluirProduto.show();
            tfProduto.requestFocus();
        }else{
            VendaProduto vendaProduto = new VendaProduto();
            vendaProduto.setCodigo(Integer.parseInt(tfProduto.getText()));
            vendaProduto.setDescricao(lbProdutoSelecionado.getText());

            SQLite db = new SQLite();
            Produto produtoSelecionado = db.getProdutoforCodigo(Integer.parseInt(tfProduto.getText()));

            TextInputDialog tiDialog = new TextInputDialog("1");

            Integer quantidadeInformada = 0;

            while(quantidadeInformada < 1) {
                quantidadeInformada = 1;
                tiDialog.setHeaderText("Informe a quantidade de venda \nPreço R$ por unidade " + String.valueOf(produtoSelecionado.getPreco()));
                tiDialog.showAndWait();
                quantidadeInformada = Integer.parseInt(tiDialog.getEditor().getText());
            }

            vendaProduto.setQuantidade(quantidadeInformada);



            vendaProduto.setUnitario(produtoSelecionado.getPreco());
            vendaProduto.setTotal(vendaProduto.calcularTotal());

            tcCodigo.setCellValueFactory(new PropertyValueFactory<VendaProduto, String>("codigo"));
            tcDescricao.setCellValueFactory(new PropertyValueFactory<VendaProduto, String>("descricao"));
            tcQuantidade.setCellValueFactory(new PropertyValueFactory<VendaProduto, Integer>("quantidade"));
            tcUnitario.setCellValueFactory(new PropertyValueFactory<VendaProduto, Double>("unitario"));
            tcTotal.setCellValueFactory(new PropertyValueFactory<VendaProduto, Double>("total"));

            Object  a = twprodutos.getItems().add(vendaProduto);
            twprodutos.refresh();

            lbProdutoSelecionado.setText("...");
            tfProduto.clear();
            tfProduto.requestFocus();

        }

    }

    public void clickRemoverProduto(Event e){
        twprodutos.getItems().removeAll(twprodutos.getSelectionModel().getSelectedItems());
        twprodutos.refresh();

    }


}
