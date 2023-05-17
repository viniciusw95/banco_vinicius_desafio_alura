package banco_vinicius_desafio_alura;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    
    public static void main(String[] args) {
        Main app = new Main();
        
        ContaCorrente contaOrigem = new ContaCorrente(1000.0);
        Cliente cliente = new Cliente("Vinicius", contaOrigem);
        
        ContaCorrente contaDestino = new ContaCorrente(500.0);
        
        System.out.println("***********************      ");
        System.out.println("Dados iniciais do cliente: \n");
        System.out.println(cliente.extrato());
        System.out.println("***********************    \n");
        
        Scanner teclado = new Scanner(System.in);
         
        int opcao = 0;
        while (opcao != 4) {
            System.out.println();
            app.menuOperacoes();
            try {
                opcao = app.lerOpcao(teclado);
                switch (opcao) {
                    case 1 -> {
                        System.out.println();
                        System.out.println(cliente.extrato());
                    }
                    case 2 -> {
                        System.out.println("Quanto irá receber? ");
                        double valor = app.lerValor(teclado);
                        cliente.receberValor(valor);
                        System.out.println("Valor de " + valor +  " recebido!");
                    }
                    case 3 -> {
                        System.out.println("Quanto irá enviar? ");
                        double valor = app.lerValor(teclado);
                        cliente.transferir(valor, contaDestino);
                        System.out.println("Valor de " + valor + " enviado!");
                    }
                    case 4 -> {
                        break;
                    }
                }
            } catch (TransferenciaExcecao ex) {
                System.out.println(ex.getMessage());
            } catch (InputMismatchException ex) {
                System.out.println(ex.getMessage());
                teclado.nextLine();
            }
        }
        teclado.close();
        
        System.out.println("Desconectado do app.");
        
    }
    
    public void mostrarDados(Cliente cliente) {
        System.out.println(cliente.extrato());
    }
    
    public void menuOperacoes() {
        System.out.print("""
            Operações
            
            1- Consultar saldos
            2- Receber valor
            3- Transferir valor
            4- Sair
            
            Digite a opção desejada (1-4): """);
    }
    
    public int lerOpcao(Scanner teclado) throws InputMismatchException {
        int opcao = 0;
        try {
            opcao = teclado.nextInt();
            return opcao;
        } catch (InputMismatchException ex) {
            throw new InputMismatchException("Teclar apenas um dos valores (1, 2, 3, 4): ");
        }
    }
    public double lerValor(Scanner teclado) {
        double valor;
        try {
            valor = teclado.nextDouble();
            return valor;
        } catch (InputMismatchException ex) {
            throw new InputMismatchException("Valor inválido digitado: ");
        }
    }
}
