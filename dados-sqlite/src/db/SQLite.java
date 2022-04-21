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
            if (!this.checkPessoa(pessoa)){
                this.stm = this.conn.createStatement();
                String cmdSQL = "insert into pessoa (nome, sobrenome, idade, cpf) VALUES ('"+pessoa.getNome()+"', '"+pessoa.getSobrenome()+"', "+pessoa.getIdade()+ ", '"+pessoa.getCpf()+"')";
                this.stm.executeUpdate(cmdSQL);
            }

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

    //Método para verificar se o CPF está registrado no banco de dados
    private boolean checkPessoa(Pessoa pessoa){
        List<Pessoa> listaPessoa = new ArrayList<>();

        try{
            ResultSet resultset ;
            resultset = this.stm.executeQuery("select * from pessoa where  CPF = '"+pessoa.getCpf()+"'");

            while(resultset.next()){
                listaPessoa.add(new Pessoa(resultset.getString("nome"), resultset.getString("sobrenome"), resultset.getInt("idade")));
            }

            if (listaPessoa.size() >= 1){
                return true;
            }else{
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;

    }

    // Método para atualizar dados de uma pessoa
    public void updatePessoa(Pessoa pessoa){
        try{

            if (this.checkPessoa(pessoa)){
                this.stm = this.conn.createStatement();
                String cmdUpdate = "update " +
                                   "    pessoa " +
                                   "set " +
                                   "    idade     = "+pessoa.getIdade()+", " +
                                   "    nome      = '"+pessoa.getNome()+"', " +
                                   "    sobrenome = '"+pessoa.getSobrenome()+"' " +
                                   "where " +
                                   "    cpf = '"+pessoa.getCpf()+"'";
                this.stm.executeUpdate(cmdUpdate);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Eliminar objeto pessoa dentro do banco de dados
    public void eliminarPessoa(Pessoa pessoa){
        try{
            this.stm = this.conn.createStatement();
            String cmdDelete = "delete from pessoa where CPF = '"+pessoa.getCpf()+"'";
            this.stm.executeUpdate(cmdDelete);

        }catch (SQLException e){
            e.printStackTrace();
        }


    }





}
