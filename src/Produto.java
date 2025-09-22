public class Produto implements Identificavel<Integer>{
    private final Integer id;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    //Construtor
    public Produto(Integer id, String nome, double preco, int quantidadeEmEstoque){
        if (id == null){
            throw new IllegalArgumentException("ID não pode ser nulo.");
        }
        this.id = id;
        setNome(nome);
        setPreco(preco);
        setQuantidadeEmEstoque(quantidadeEmEstoque);

    }
    @Override
    public Integer getId(){
        return id;
    }

    public void aplicarDesconto(double porcentagem){
        if(porcentagem < 0 || porcentagem > 50){
            throw new IllegalArgumentException("Desconto inválido: deve estar entre 0% e 50%");
        }
        double desconto = preco * (porcentagem/100);
        preco-=desconto;//Atualiza o preço
    }


    //Getters:
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco;
    }
    public int getQuantidadeEmEstoque(){
        return quantidadeEmEstoque;
    }

    //Setters com validação:
    public void setNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome= nome;
    }
    public void setPreco(double preco){
        if(preco < 0){
            throw new IllegalArgumentException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }
    public void setQuantidadeEmEstoque(int quantidadeEmEstoque){
        if(quantidadeEmEstoque < 0){
            throw new IllegalArgumentException("Quantidade em estoque não pode ser negativa");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    @Override
    public String toString(){
        return String.format("Produto{id=%d,nome=`%s`, preco=%.2f, quantidadeEmEstoque=%d}", id,nome, preco,quantidadeEmEstoque);
    }
}

