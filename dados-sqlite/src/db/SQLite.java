package db;
import entities.Pessoa;
import entities.Produto;

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

    // 4 métodos
    // inserirProduto
    public void insertProduto(Produto produto){
        try {
            if (!this.checkProduto(produto)) {
                this.stm = this.conn.createStatement();
                String cmdSQLInsertProduto = "insert into produto" +
                        "(codbarra, descricao, preco) " +
                        "values" +
                        "('" + produto.getCodbarra() + "', '" + produto.getDescricao() + "', '" + produto.getPreco() + "')";

                this.stm.executeUpdate(cmdSQLInsertProduto);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //InsereProdutoCheck
    public void insertProdutoCheck(Produto produto){
        try {
            this.stm = this.conn.createStatement();
            String cmdSQLInsertProduto = "insert into produto(codbarra, descricao, preco) " +
                                         "select" +
                                         "'"+produto.getCodbarra()+"' as codbarra, " +
                                         "'"+produto.getDescricao()+"' as descricao, " +
                                         "'"+produto.getPreco()+"' as preco " +
                                         "where " +
                                         "not exists(select * from produto where codbarra = '"+produto.getCodbarra()+"' )";

            this.stm.executeUpdate(cmdSQLInsertProduto);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //InsereProdutoCheck
    public void deleteProduto(Produto produto){
        try {
            this.stm = this.conn.createStatement();
            String cmdSQLInsertProduto = "delete from produto " +
                                         "where codbarra = '"+produto.getCodbarra()+"'";

            this.stm.executeUpdate(cmdSQLInsertProduto);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public boolean checkProduto(Produto produto){
        List<Produto> listaProduto = new ArrayList<>();

        try{
            ResultSet resultset ;
            resultset = this.stm.executeQuery("select * from produto where  codbarra = '"+produto.getCodbarra()+"'");

            while(resultset.next()){
                Produto produto1 = new Produto();
                produto1.setCodbarra(resultset.getString("codbarra"));
                produto1.setDescricao(resultset.getString("descricao"));
                produto1.setPreco(Double.valueOf(resultset.getString("preco")));
                listaProduto.add(produto1);
            }

            if (listaProduto.size() >= 1){
                return true;
            }else{
                return false;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;

    }

    public void updatePrice(Produto produto){
        try {
            this.stm = this.conn.createStatement();
            String updatePrice = "update " +
                                 "    produto " +
                                 "set" +
                                 "    preco = '"+produto.getPreco()+"'" +
                                 "where " +
                                 "  codbarra = '"+produto.getCodbarra()+"'";
            this.stm.executeUpdate(updatePrice);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    /*Sobrecarga*/

    public List<Produto> getAllProdutos(){
        return getAllProdutos("");
    }

    public List<Produto> getAllProdutos(String busca){
        List<Produto> listProduto = new ArrayList<>();
        ResultSet rsProduto;

        try {
            if (busca.equals("")){
                rsProduto = this.stm.executeQuery("select * from produto order by preco desc");
            }else{
                String sqlProduto = "select * from produto where descricao like '%"+busca+"%' order by preco desc";
                rsProduto = this.stm.executeQuery(sqlProduto);
            }


            while (rsProduto.next()){
                Produto prdLista = new Produto();
                prdLista.setCodbarra(rsProduto.getString("codbarra"));
                prdLista.setDescricao(rsProduto.getString("descricao"));
                prdLista.setPreco(rsProduto.getDouble("preco"));
                listProduto.add(prdLista);
            }

            rsProduto.close();


        }catch (SQLException e){
            e.printStackTrace();
        }

        return listProduto;
    }




    public void eliminarProduto(Produto produto){
        try{
            this.stm = this.conn.createStatement();
            String deleteProduto = "delete from produto where codbarra = '"+produto.getCodbarra()+"'";
            this.stm.executeUpdate(deleteProduto);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    //InsereProdutoCheck
    public void copiaProduto(Produto produto, String codbarra){
        try {
            this.stm = this.conn.createStatement();
            String cmdSQLInsertProduto = "insert into produto " +
                                        "select " +
                                        "'"+codbarra+"' as codbarra, " +
                                        "descricao, " +
                                        "preco " +
                                        "from produto " +
                                        "where " +
                                        "codbarra = '"+produto.getCodbarra()+"'";

            //System.out.println(cmdSQLInsertProduto);
            this.stm.executeUpdate(cmdSQLInsertProduto);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    /// Categoria de Produtos...
    // Classe espeifica para tratar Categoria (codigo, nome, margem de lucro)






}
