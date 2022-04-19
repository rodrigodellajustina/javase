package db;

import entities.Pessoa;

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
        this.conn = DriverManager.getConnection("jdbc:sqlite:base.db");
        this.stm  = this.conn.createStatement();
    }

    /*Método responsável por inserir os dados na tabela pessoa*/
    public void insertPessoa(Pessoa pessoa){
        try {
            this.stm = this.conn.createStatement();

            this.stm.executeUpdate("insert into pessoa (nome, sobrenome, idade) VALUES ('"+pessoa.getNome()+"', '"+pessoa.getSobrenome()+"', "+pessoa.getIdade()+")");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /*Método para recuperar os dados da tabela Pessoa*/
    public List<Pessoa> getAllPessoas(){
        List<Pessoa> listaPessoa = new ArrayList<>();
        ResultSet    resultset;

        try{
            // Busca os dados através da query "select * from pessoa*
            // atribui os valores para dentro de um resultset
            resultset = this.stm.executeQuery("select * from pessoa");

            /*Percorre o resultset  <list> e atribui os valore para dentro da listPessoa (ADD)*/
            while(resultset.next()){
                listaPessoa.add(new Pessoa(resultset.getString("nome"), resultset.getString("sobrenome"), resultset.getInt("idade")));
            }
            /*Finalizar o result set*/
            resultset.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return listaPessoa;

    }



}
