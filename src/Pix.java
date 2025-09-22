public class Pix extends FormaPagamento {
    @Override
    public void validarPagamento(String chavePix) throws PagamentoInvalidoException {
        if (chavePix == null || chavePix.trim().isEmpty()) {
            throw new PagamentoInvalidoException("Chave Pix inválida.");
        }
        // Exemplo simples: validar se é e-mail, telefone ou chave aleatória
        if (!(chavePix.matches("\\w{32}") || chavePix.contains("@") || chavePix.matches("\\d{11}"))) {
            throw new PagamentoInvalidoException("Formato da chave Pix não reconhecido.");
        }
    }
}
