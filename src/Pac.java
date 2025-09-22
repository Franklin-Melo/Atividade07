import java.math.BigDecimal;

public class Pac implements CalculadoraFrete {
    @Override
    public BigDecimal calcular(Pedido pedido) {
        return pedido.getValorPedido().multiply(new BigDecimal("0.05"));
    }
}