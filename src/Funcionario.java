import java.math.BigDecimal;

public abstract class Funcionario {//Não será instanciada diretamente

    protected String nome;
    protected BigDecimal salario;

    public Funcionario(String nome, BigDecimal salario){
        if(salario == null || salario.compareTo(BigDecimal.ZERO) <=0){
            throw new IllegalArgumentException("Salário deve ser positivo");
        }
        if (nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
        this.salario = salario;
    }
    //Getters:
    public String getNome(){
        return nome;
    }
    public BigDecimal getSalario(){
        return salario;
    }
    // Método abstrato obriga subclasses a implementarem
    public abstract BigDecimal calcularBonus();
}


