import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Carrinho {
    private final List<ItemCarrinho> itens;

    public Carrinho(List<ItemCarrinho> itens) {
        this.itens = Collections.unmodifiableList(new ArrayList<>(itens));
    }

    public List<ItemCarrinho> getItens() {
        return itens;
    }

    public Carrinho adicionarItem(Produto produto, int quantidade) {
        List<ItemCarrinho> novaLista = new ArrayList<>(itens);
        novaLista.add(new ItemCarrinho(produto, quantidade));
        return new Carrinho(novaLista);
    }

    public Carrinho removerItem(int index) {
        List<ItemCarrinho> novaLista = new ArrayList<>(itens);
        if (index < 0 || index >= novaLista.size()) {
            throw new IllegalArgumentException("Índice inválido.");
        }
        novaLista.remove(index);
        return new Carrinho(novaLista);
    }

    public Carrinho aplicarCupom(double porcentagem) {
        if (porcentagem < 0 || porcentagem > 30) {
            throw new IllegalArgumentException("Cupom inválido: máximo 30%.");
        }
        List<ItemCarrinho> novaLista = new ArrayList<>();
        for (ItemCarrinho item : itens) {
            Produto produtoComDesconto = new Produto(
                    item.getProduto().getId(),
                    item.getProduto().getNome(),
                    item.getProduto().getPreco(), // copia do preço original
                    item.getProduto().getQuantidadeEmEstoque()
            );
            produtoComDesconto.aplicarDesconto(porcentagem);
            novaLista.add(new ItemCarrinho(produtoComDesconto, item.getQuantidade()));
        }
        return new Carrinho(novaLista);
    }

    public double getTotal() {
        double total = 0;
        for (ItemCarrinho item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Carrinho:\n");
        for (ItemCarrinho item : itens) {
            sb.append(item).append("\n");
        }
        sb.append("Total: R$ ").append(String.format("%.2f", getTotal()));
        return sb.toString();
    }
}
