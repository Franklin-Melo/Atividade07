public final class ItemCarrinho {
    private final Produto produto;
    private final int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        if (produto == null) throw new IllegalArgumentException("Produto inválido.");
        if (quantidade <= 0) throw new IllegalArgumentException("Quantidade deve ser maior que 0.");
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    @Override
    public String toString() {
        return quantidade + "x " + produto.getNome() + " = R$ " + String.format("%.2f", getSubtotal());
    }
}
