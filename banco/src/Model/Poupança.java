package Model;

public class Poupança extends Conta {

    protected double taxaJuros;


    public Poupança(double taxaJuros, int numero, double saldo, String nomeCliente) {

        super(numero,nomeCliente,saldo);

        this.taxaJuros = taxaJuros;



    }

    @Override
    public boolean saque(double valor) {

        if(valor < this.saldo) {

          this.saldo -= valor;
            return true;
        }
        return false;

    }

    public void atualizarJuros() {

        if(taxaJuros != 0.0) {

            this.saldo = this.saldo * taxaJuros;

        }
    }


}
