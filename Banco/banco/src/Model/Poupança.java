package Model;

public class Poupança extends Conta {

    protected double taxaJuros;

    public Poupança(double taxaJuros, int numero, double saldo, String nomeCliente) {

        super(numero, nomeCliente, saldo);

        this.taxaJuros = taxaJuros;

    }

    @Override
    public void saque(double valor) {

        if (valor <= this.saldo) {

            this.saldo -= valor;
        }
    }

    public void atualizarJuros() {

        if (taxaJuros != 0.0) {

            this.saldo = this.saldo+((this.saldo * this.taxaJuros)/100);

        }
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

}
