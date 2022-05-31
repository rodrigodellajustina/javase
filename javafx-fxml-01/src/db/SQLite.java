package db;

import Scene.Usuarios;
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



}
