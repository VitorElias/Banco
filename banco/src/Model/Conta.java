package Model;

public class Conta {

    protected int numero;
    protected String nomeCliente;
    protected double saldo;

    public Conta() {

    }

    public Conta(int numero, String nomeCliente, double saldo) {

        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;

    }

    public boolean saque(double valor) {

        if(valor < this.saldo+5.0) {

            this.saldo -= (valor+5.0);
            return true;
        }
        return false;
    }

    public void depositar(double valor) {

        this.saldo += valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
