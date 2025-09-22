import java.math.BigDecimal;

public class Pedido {
    private String cepDestino;
    private BigDecimal valorPedido;
    private CalculadoraFrete estrategiaFrete;

    public Pedido(String cepDestino, BigDecimal valorPedido) {
        this.cepDestino = cepDestino;
        this.valorPedido = valorPedido;
    }

    public void setEstrategiaFrete(CalculadoraFrete estrategiaFrete) {
        this.estrategiaFrete = estrategiaFrete;
    }

    public BigDecimal calcularFrete() {
        if (estrategiaFrete == null) {
            throw new IllegalStateException("Nenhuma estratégia de frete definida.");
        }
        return estrategiaFrete.calcular(this);
    }

    // Getters
    public String getCepDestino() { return cepDestino; }
    public BigDecimal getValorPedido() { return valorPedido; }
}
