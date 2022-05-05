package db;
import entitites.Cadastros;

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
        this.conn = DriverManager.getConnection("jdbc:sqlite:usuarios.db");
        this.stm = this.conn.createStatement();
    }

    public void insertUsuario(Cadastros cadastro){
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