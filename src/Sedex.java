import java.math.BigDecimal;

public class Sedex implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        // Exemplo simples: 10% do valor do pedido
        return pedido.getValorPedido().multiply(new BigDecimal("0.10"));
    }
}




