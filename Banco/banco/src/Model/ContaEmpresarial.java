package Model;

public class ContaEmpresarial extends Conta {

    private double limiteEmprestimo;

    public ContaEmpresarial() {

        super();

    }

    public ContaEmpresarial(int numero, double saldo, String nomeCliente, double limiteEmprestimo) {
        super(numero, nomeCliente, saldo);
        this.limiteEmprestimo = limiteEmprestimo;

    }

    @Override
    public void saque(double valor) {

        if (valor <= this.saldo - 7.0) {

            super.saque(valor);
            this.saldo -= 2.0;
        }

    }

    public void realizarEmprestimo(double emprestimo) {

        if (this.limiteEmprestimo >= emprestimo && saldo >= emprestimo) {

            this.saldo -= emprestimo;

        }
    }

    public double getLimiteEmprestimo() {
        return limiteEmprestimo;
    }

    public void setLimiteEmprestimo(double limiteEmprestimo) {
        this.limiteEmprestimo = limiteEmprestimo;
    }

}
