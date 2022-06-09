package db;

import Scene.Usuarios;
import entities.Estado;
import entities.Produto;
import entities.Usuario;

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



}
