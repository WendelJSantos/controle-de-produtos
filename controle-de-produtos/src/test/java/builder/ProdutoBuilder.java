package builder;

import page.ControleDeProdutoPO;
import config.Constants;

/**
 * Classe que sabe construir ou adicionar um produto na tela
 */
public class ProdutoBuilder {

    private String codigo;
    private String nome;
    private String quantidade;
    private String valor;
    private String data;

    private final ControleDeProdutoPO controleDeProdutoPO;

    private ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO) {
        this.controleDeProdutoPO = controleDeProdutoPO;
        this.codigo = Constants.CODIGO_PRODUTO_PADRAO;
        this.nome = Constants.NOME_PRODUTO_PADRAO;
        this.quantidade = Constants.QUANTIDADE_PRODUTO_PADRAO;
        this.valor = Constants.VALOR_PRODUTO_PADRAO;
        this.data = Constants.DATA_PRODUTO_PADRAO;
    }

    public static ProdutoBuilder criar(ControleDeProdutoPO controleDeProdutoPO) {
        return new ProdutoBuilder(controleDeProdutoPO);
    }

    public ProdutoBuilder adicionarCodigo(String codigo) {
        this.codigo = codigo;
        return this;
    }

    public ProdutoBuilder adicionarNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder adicionarQuantidade(String quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoBuilder adicionarValor(String valor) {
        this.valor = valor;
        return this;
    }

    public ProdutoBuilder adicionarData(String data) {
        this.data = data;
        return this;
    }

    public void builder() {
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, quantidade);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, valor);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);
        controleDeProdutoPO.clicar(controleDeProdutoPO.buttonSalvar);
    }

}
