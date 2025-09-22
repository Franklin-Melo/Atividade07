public class CartaoCredito extends FormaPagamento {
    @Override
    public void validarPagamento(String numeroCartao)throws PagamentoInvalidoException {
        if(numeroCartao == null || !numeroCartao.matches("\\d{16}")){
            throw new PagamentoInvalidoException("Número de cartão inválido. Deve ter 16 dígitos.");
        }
    }

}
