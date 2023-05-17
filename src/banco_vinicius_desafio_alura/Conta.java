package banco_vinicius_desafio_alura;

public class Conta {
    protected double saldo;
    
    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }
    
    public void depositar(double valor) {
        if (valor <= 0) {
            throw new TransferenciaExcecao("Exceção: Valor inválido para receber (<= 0)");
        }
        this.saldo += valor;
    }
    
    public void sacar(double valor) {
        if (valor <= 0) {
            throw new TransferenciaExcecao("Exceção: Valor inválido para retirada (<= 0)");
        }
        if (this.saldo <= valor) {
            throw new TransferenciaExcecao("Exceção: saldo insuficiente para "
                    + "saques/transferências. Saldo: " + this.saldo 
                    + " Valor digitado: " + valor );
        }
        this.saldo -= valor;
    }
}
