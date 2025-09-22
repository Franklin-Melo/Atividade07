public class Boleto extends FormaPagamento {
    @Override
    public void validarPagamento(String codigoBoleto) throws PagamentoInvalidoException {
        if (codigoBoleto == null || !codigoBoleto.matches("\\d{47}")) {
            throw new PagamentoInvalidoException("Boleto inválido. Deve ter 47 dígitos.");
        }
    }
}
