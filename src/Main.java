import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Demostração da classe Produto ===");

        // 1) Criar uma instância válida
        System.out.println("Criando Produto: ");
        Produto p = new Produto(1,"Caneca",19.90, 5);
        System.out.println("Criado: " + p);
        System.out.println("Preço antes do Desconto: " + p.getPreco());

        //Aplicar desconto válido:
        p.aplicarDesconto(20);//20%
        System.out.println("Preço após o desconto: " + p.getPreco());

        //Testar entradas inválidas:
        try{
            System.out.println("Testando entradas Maior que 50%: ");
            p.aplicarDesconto(60);//inválido maior que 50
        }catch (IllegalArgumentException e){
            System.out.println("Erro ao aplicar desconto: " + e.getMessage());
        }
        try {
            System.out.println("Testando entradas Menor que 0%: ");
            p.aplicarDesconto(-5); // inválido: negativo
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao aplicar desconto: " + e.getMessage());
        }

        //Alterar com valores válidos:
        System.out.println("Alterando Produto: ");
        p.setNome("Caneca de Porcelana");
        p.setPreco(25);
        p.setQuantidadeEmEstoque(10);
        System.out.println("Alterado: " + p);

        //Tentar atribuições inválidas e capturar as exceções:
        try {
            System.out.println("Testando preço Menor que 0: ");
            p.setPreco(-5.0);
        }catch(IllegalArgumentException e){
            System.out.println("Erro ao definir preço: " +e.getMessage());
        }
        try {
            System.out.println("Testando Quantidade Menor que 0: ");
            p.setQuantidadeEmEstoque(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir quantidade: " + e.getMessage());
        }

        try {
            System.out.println("Testando Nome vazio: ");
            p.setNome("   "); // vazio após trim
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao definir nome: " + e.getMessage());
        }

        // 4) Tentar criar instâncias inválidas (cada uma lança exceção)
        try {
            System.out.println("Criando Objeto Inválido Com null no parâmetro: ");
            Produto p2 = new Produto(1,null, 10.0, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar produto: " + e.getMessage());
        }

        try {
            System.out.println("Criando Objeto com preço negativo: ");
            Produto p3 = new Produto(1,"Caneta", -2.0, 5);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar produto: " + e.getMessage());
        }

        try {
            System.out.println("Criando Objeto com Quantidade negativa: ");
            Produto p4 = new Produto(1,"Lápis", 1.5, -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar produto: " + e.getMessage());
        }
        System.out.println("Simulando Herança: ");
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Gerente("Ana", new BigDecimal("100000")));
        funcionarios.add(new Desenvolvedor("Franklin",new BigDecimal("50000")));

        for (Funcionario f:funcionarios){
            System.out.printf(
                    "%s (%s) - Salário: R$ %.2f - Bônus: R$ %.2f%n",
                    f.getNome(),
                    f.getClass().getSimpleName(),
                    f.getSalario(),f.calcularBonus());
        }

        System.out.println("Testando Polimorfismo com Interface: ");
        List<IMeioTransporte> meios = new ArrayList<>();
        meios.add(new Carro());

        for(IMeioTransporte m:meios){
            System.out.println("\n--- Testando: " + m + "---");
            try {
                System.out.println("Acelerando... ");
                m.acelerar(20);
                System.out.printf("%s acelerou para %d km/h%n", m, m.getVelocidade());
                System.out.println("Freando... ");
                m.frear(5);
                System.out.printf("%s reduziu para %d km/h%n", m, m.getVelocidade());
            }catch (IllegalArgumentException e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
        System.out.println("Testando Formas de Pagamentos: ");
        List<FormaPagamento> formas = new ArrayList<>();
        formas.add(new CartaoCredito());
        formas.add(new Boleto());
        formas.add(new Pix());

        String[] dadosPagamentos = {

                "1234567812345678", // Cartão válido
                "12345678901234567890123456789012345678901234567", // Boleto válido
                "meuemail@example.com" // Pix válido
        };
        BigDecimal valor = new BigDecimal("150.00");
        for (int i = 0; i < formas.size(); i++){
            FormaPagamento forma = formas.get(i);
            String dados = dadosPagamentos[i];
            try {
                forma.validarPagamento(dados);
                forma.processarPagamento(valor);
                System.out.println("Pagamento realizado com sucesso!\n");

            }catch (PagamentoInvalidoException | IllegalArgumentException e){
                System.out.println("Erro " + e.getMessage());
            }
        }
        // Exemplo de entrada inválida
        try {
            CartaoCredito cc = new CartaoCredito();
            cc.validarPagamento("1234"); // Inválido
        } catch (PagamentoInvalidoException e) {
            System.out.println("Erro esperado: " + e.getMessage());
        }

        //Testando Exercicio 6:
        System.out.println("Testando o Exercicio 6: ");
        Produto caneca = new Produto(1,"Caneca", 20, 10);
        Produto camiseta = new Produto(1,"Camiseta", 50, 5);

        Carrinho carrinho = new Carrinho(List.of());
        carrinho = carrinho.adicionarItem(caneca, 2);
        carrinho = carrinho.adicionarItem(camiseta, 1);

        System.out.println("Carrinho inicial:");
        System.out.println(carrinho);

        Carrinho comDesconto = carrinho.aplicarCupom(10);
        System.out.println("\nCarrinho com desconto de 10%:");
        System.out.println(comDesconto);

        Carrinho removido = comDesconto.removerItem(0);
        System.out.println("\nCarrinho após remover primeiro item:");
        System.out.println(removido);

        System.out.println("Testando Exercicio 7: ");

        IRepository<Produto, Integer> repo = new InMemoryRepository<>();

        Produto p1 = new Produto(1, "Caneca", 20, 10);
        Produto p2 = new Produto(2, "Camiseta", 50, 5);

// Salvar produtos
        repo.salvar(p1);
        repo.salvar(p2);

// Listar todos
        System.out.println("Todos os produtos:");
        repo.listarTodos().forEach(System.out::println);

// Buscar por ID
        System.out.println("\nBuscando produto com ID 1:");
        System.out.println(repo.buscarPorId(1).orElse(null));

// Remover produto
        System.out.println("\nRemovendo produto com ID 1");
        repo.remover(1);

// Listar novamente
        System.out.println("\nProdutos restantes:");
        repo.listarTodos().forEach(System.out::println);

        System.out.println("Testando Exercicio 08: ");

        CalculadoraFrete freteGratisAcima100 = pedido -> {
            if (pedido.getValorPedido().compareTo(new BigDecimal("100")) >= 0) {
                return BigDecimal.ZERO;
            } else {
                return pedido.getValorPedido().multiply(new BigDecimal("0.05"));
            }
        };



        Pedido pedido = new Pedido("12345000", new BigDecimal("120"));

        // Usando estratégia Sedex
        pedido.setEstrategiaFrete(new Sedex());
        System.out.println("Frete Sedex: R$ " + pedido.calcularFrete());

        // Usando lambda promocional
        pedido.setEstrategiaFrete(freteGratisAcima100);
        System.out.println("Frete promocional: R$ " + pedido.calcularFrete());

        // Troca para RetiradaNaLoja
        pedido.setEstrategiaFrete(new RetiradaNaLoja());
        System.out.println("Frete Retirada na Loja: R$ " + pedido.calcularFrete());


    }
}