package config;

import java.util.List;

/*
 * A classe {@code Constants} armazena valores constantes utilizados 
 * em toda a automação, como URLs, tempos de espera, seletores e 
 * mensagens esperadas.
 * O uso de constantes evita a repetição de strings no código, 
 * facilitando a manutenção e reduzindo erros tipográficos.
 */
public class Constants {

    public static final String CODIGO_PRODUTO_PADRAO = "00001";
    public static final String NOME_PRODUTO_PADRAO = "Produto Padrão";
    public static final String QUANTIDADE_PRODUTO_PADRAO = "1";
    public static final String VALOR_PRODUTO_PADRAO = "50.0";
    public static final String DATA_PRODUTO_PADRAO = "01/01/2025";

    /*
     * Caminho base da URL do sistema a ser testado. Host e Porta definido pela
     * extensão do Live Server
     */
    public static final String URB_BASE = "http://127.0.0.1:5500/controle-de-produtos/src/test/java/resource/projeto/sistema/login.html";

    /* Caminho relativo do driver ao prjeto referente ao path */
    public static final String CAMINHO_DRIVER = "src/test/java/resource/chromedriver.exe";

    public static final String TITULO_PAGINA_CONTROLE_DE_PRODUTOS = "Controle de Produtos";
    public static final String TITULO_PAGINA_LOGIN = "Login";
    public static final String DESCRICAO_MODAL_TITTLE_PRODUTO = "Produto";
    public static final String MENSAGEM_CAMPOS_OBRIGATORIOS = "Todos os campos são obrigatórios para o cadastro!";

    public static final String EMAIL_VALIDO = "admin@admin.com";
    public static final String SENHA_VALIDA = "admin@123";

    public static final String MENSAGEM_CAMPOS_EM_BRANCO = "Informe usuário e senha, os campos não podem ser brancos.";
    public static final String MENSAGEM_CAMPOS_INVALIDOS = "E-mail ou senha inválidos";

    public static final String MENSAGEM_VAZIA = "";

    public static final List<String> CAMPOS_TABELA = List.of("codigo", "nome", "quantidade", "valor", "data", "acao");

}
