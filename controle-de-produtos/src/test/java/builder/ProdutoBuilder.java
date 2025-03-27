package builder;

import page.ControleDeProdutoPO;

public class ProdutoBuilder {

    private String codigo = "00001";
    private String nome = "Produto Padrão";
    private String quantidade = "1";
    private String valor = "1.0";
    private String data = "25/03/2025";

    private ControleDeProdutoPO controleDeProdutoPO;

    public ProdutoBuilder (ControleDeProdutoPO controleDeProdutoPO){
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    public ProdutoBuilder adicionarCodigo(String codigo){
        this.codigo = codigo;
        return this;
    }

    public ProdutoBuilder adicionarNome(String nome){
        this.nome = nome;
        return this;
    }

    public ProdutoBuilder adicionarQuantidade(String quantidade){
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoBuilder adicionarValor(String valor){
        this.valor = valor;
        return this;
    }

    
    public ProdutoBuilder adicionarData(String data){
        this.data = data;
        return this;
    }

    public void builder (){
      controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
      controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
      controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, quantidade);
      controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, valor);
      controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);
      controleDeProdutoPO.clicarNoBotaoSalvar();
    }

}
