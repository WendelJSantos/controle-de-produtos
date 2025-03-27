package builder;

import page.ControleDeProdutoPO;

/**
 * Classe que sabe construir ou adicionar um produto na tela
 */
public class ProdutoBuilder {






    private ControleDeProdutoPO controleDeProdutoPO;

    //*Construtor do ProdutoBuilder que recebe a página de controle de produtos. */
    public ProdutoBuilder (ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    /**
     * Metodo que sabe adicionar um código ao builder.
     * @param codigo Código que será adicionado.
     * @return Retorna a própria classe que será o ProdutoBuilder.
     */
    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    /**
     * Metodo que sabe adicionar um nome ao builder.
     * @param nome Nome que será adicionado.
     * @return Retorna a própria classe que será o ProdutoBuilder.
     */
    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }

    /**
     * Metodo que sabe adicionar um quantidade ao builder.
     * @param quantidade Quantidade que será adicionado.
     * @return Retorna a própria classe que será o ProdutoBuilder.
     */
    public ProdutoBuilder adicionarQuantidade(String quantidade){
        this.quantidade = quantidade;
        return this;
    }

    /**
     * Metodo que sabe adicionar um valor ao builder.
     * @param valor Valor que será adicionado.
     * @return Retorna a própria classe que será o ProdutoBuilder.
     */
    public ProdutoBuilder adicionarValor(String valor){
        this.valor = valor;
        return this;
    }

    /**
     * Metodo que sabe adicionar um data ao builder.
     * @param data Data que será adicionada.
     * @return Retorna a própria classe que será o ProdutoBuilder.
     */
    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    /**
     * Metodo que constrói o produto, ou seja, adiciona o produto pelo tela de cadastro de produto.
     */
    public void builder (){
      controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
      controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
      controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, quantidade);
      controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, valor);
      controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);
      controleDeProdutoPO.clicarNoBotaoSalvar();
    }

}
