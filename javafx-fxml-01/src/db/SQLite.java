package db;

import Scene.Usuarios;
import com.sun.security.ntlm.Client;
import entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLite {
    /*
     * Responsável pela comunicação entre o Banco e Aplicação
     * */
    private Connection conn;
    private Statement stm;

    public SQLite() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        this.conn = DriverManager.getConnection("jdbc:sqlite:D:\\javasegit\\javase\\javafx-projeto02\\usuarios.db");
        this.stm = this.conn.createStatement();
    }

    public boolean checkLogin(Usuario usuario){
        List<Usuario> listUsuarioLogin = new ArrayList<>();
        ResultSet resultUsuarioLogin;

        try{
            resultUsuarioLogin = this.stm.executeQuery("select * from usuario " +
                                                       "where email = '"+usuario.getEmail()+"'  and senha = '"+usuario.getSenha()+"'");

            while(resultUsuarioLogin.next()){
                resultUsuarioLogin.close();
                return true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return false;
    }

    public boolean checkEmail(Usuario usuario){
        List<Usuario> listUsuarioLogin = new ArrayList<>();
        ResultSet resultUsuarioLogin;

        try{
            resultUsuarioLogin = this.stm.executeQuery("select * from usuario " +
                                                       "where email = '"+usuario.getEmail()+"'");

            while(resultUsuarioLogin.next()){
                resultUsuarioLogin.close();
                return true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return false;
    }

    public void insertUsuario(Usuario cadastro){
        try {
            this.stm = this.conn.createStatement();
            String sqlInsertUsuario = "insert into usuario (nome, email, senha) " +
                                      "values ('"+cadastro.getNome()+"', '"+cadastro.getEmail()+"', '"+cadastro.getSenha()+"')";
            this.stm.executeUpdate(sqlInsertUsuario);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertProduto(Produto produto){
        try {
            this.stm = this.conn.createStatement();
            String sqlInsertProduto = "insert into produto " +
                                      "(descricao, custo, preco) " +
                                      "values " +
                                      "('"+produto.getDescricao()+"', "+produto.getCusto()+", "+produto.getPreco()+")";
            this.stm.executeUpdate(sqlInsertProduto);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertCliente(Cliente cliente){
        try {
            this.stm = this.conn.createStatement();
            String sqlInsertCliente = "insert into cliente " +
                                      "(nome, cidade, estado) " +
                                      "values ('"+cliente.getNome()+"', '"+cliente.getCidade()+"', '"+cliente.getEstado()+"')";
            this.stm.executeUpdate(sqlInsertCliente);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Estado> getEstados(){
        List<Estado> listEstado = new ArrayList<>();
        ResultSet rsEstado;

        try{
            rsEstado = this.stm.executeQuery("select codigouf, nome, uf from estado order by uf");

            while(rsEstado.next()){
                Estado novoEstado = new Estado();
                novoEstado.setCodigoUf(rsEstado.getInt("codigouf"));
                novoEstado.setNome(rsEstado.getString("nome"));
                novoEstado.setUf(rsEstado.getString("uf"));
                listEstado.add(novoEstado);
            }

            rsEstado.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return listEstado;


    }

    public List<Usuario> getAllUsuarios(){
        List<Usuario> listUsuario = new ArrayList<>();
        ResultSet rsUsuario;

        try{
            String sql = "select nome, email from usuario order by nome";
            rsUsuario = this.stm.executeQuery(sql);

            while(rsUsuario.next()){
                Usuario usuarioCadastrado = new Usuario();
                usuarioCadastrado.setNome(rsUsuario.getString("nome"));
                usuarioCadastrado.setEmail(rsUsuario.getString("email"));
                listUsuario.add(usuarioCadastrado);
            }


        }catch (SQLException e){
            e.printStackTrace();
        }


        return listUsuario;
    }

    public void excluirUsuario(Usuario usuario){

        try {
            this.stm = this.conn.createStatement();
            String exclusao = "delete from usuario where email = '"+usuario.getEmail()+"'";
            this.stm.executeUpdate(exclusao);

        }catch (SQLException e){
            e.printStackTrace();
        }


    }
    public void atualizarUsuario(Usuario usuario, String emailantigo){
        try {
            this.stm = this.conn.createStatement();
            String update = "update usuario " +
                    "        set nome  = '"+usuario.getNome()+"', " +
                    "            email = '"+usuario.getEmail()+"' " +
                    "        where email = '"+emailantigo+"'";
            this.stm.executeUpdate(update);
        }catch (SQLException e){
            e.printStackTrace();
        }


    }

    public Cliente getClienteforCodigo(Integer codigo){
        Cliente clienteCadastrado = new Cliente();
        ResultSet rsCliente;

        try{
            String sql = "select codigo, nome, cidade, estado from cliente where codigo = "+codigo+"";
            rsCliente = this.stm.executeQuery(sql);

            while(rsCliente.next()){
                clienteCadastrado.setNome(rsCliente.getString("nome"));
                clienteCadastrado.setEstado(rsCliente.getString("estado"));
                clienteCadastrado.setCidade(rsCliente.getString("cidade"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return clienteCadastrado;
    }

    public Produto getProdutoforCodigo(Integer codigo){
        Produto produtoCadastrado = new Produto();
        ResultSet rsProduto;

        try{
            String sql = "select descricao, custo, preco from produto where codigo = "+codigo+"";
            rsProduto = this.stm.executeQuery(sql);

            while(rsProduto.next()){
                produtoCadastrado.setDescricao(rsProduto.getString("descricao"));
                produtoCadastrado.setCusto(rsProduto.getDouble("custo"));
                produtoCadastrado.setPreco(rsProduto.getDouble("preco"));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


        return produtoCadastrado;
    }




}
