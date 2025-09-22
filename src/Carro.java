public class Carro implements IMeioTransporte{
    private int velocidade;
    private final int VELOCIDADE_MAX = 200;

    @Override
    public void acelerar(int incremento) {
        if(incremento <= 0){
            throw new IllegalArgumentException(("Incremento deve ser positivo"));
        }
        velocidade+=incremento;
        if(velocidade > VELOCIDADE_MAX){
            velocidade = VELOCIDADE_MAX;
        }

    }

    @Override
    public void frear(int decremento) {
        if (decremento <= 0){
            throw new IllegalArgumentException("Decremento deve ser positivo");
        }
        velocidade-=decremento;
        if(velocidade < 0){
            velocidade = 0;
        }
    }

    @Override
    public int getVelocidade() {
        return velocidade;
    }
    @Override
    public String toString() {
        return "Carro";
    }
}
