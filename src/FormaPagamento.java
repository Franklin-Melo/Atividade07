import java.math.BigDecimal;

public abstract class FormaPagamento {
    // Validações específicas implementadas nas subclasses
    public abstract void validarPagamento(String dados) throws PagamentoInvalidoException;

    //Lógica comum para processar qualquer pagamento
    public void processarPagamento(BigDecimal valor) {
        if(valor == null || valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Valor do pagamento deve ser positivo");
        }
        System.out.println("Processando pagamento de R$: " + valor);


    }


}
