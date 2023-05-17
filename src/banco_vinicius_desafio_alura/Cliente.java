package banco_vinicius_desafio_alura;

public class Cliente {
    private String nomeCliente;
    private ContaCorrente contaCorrente;
    
    public Cliente(String nomeCliente, ContaCorrente cc) {
        this.nomeCliente = nomeCliente;
        this.contaCorrente = cc;
    }
    
    public String extrato() {
        String informacoes = "Nome: " + this.nomeCliente;
        informacoes += "\nTipo conta: corrente";
        informacoes += "\nSaldo inicial: " + this.contaCorrente.saldo;
        return informacoes;
    }
    
    public void receberValor(double valor) {
        this.contaCorrente.depositar(valor);
    }
    
    public void transferir(double valor, ContaCorrente destino) {
        this.contaCorrente.sacar(valor);
        destino.depositar(valor);
        
    }
}
