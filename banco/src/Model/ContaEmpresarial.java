package Model;

public class ContaEmpresarial extends Conta {


    private double limiteEmprestimo;

    public ContaEmpresarial() {

        super();

    }

    public ContaEmpresarial(int numero, double saldo, String nomeCliente, double limiteEmprestimo) {
        super(numero,nomeCliente,saldo);
        this.limiteEmprestimo = limiteEmprestimo;

    }

    @Override
    public boolean saque(double valor) {

        if(valor > saldo) {

            super.saque(valor);
            this.saldo -= 2.0;
            return true;

        }else {
            return false;
        }

    }
}
