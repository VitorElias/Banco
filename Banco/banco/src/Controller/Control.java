package Controller;

import Model.*;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Control {

    private ArrayList<Conta> conta = new ArrayList<>();

    public Control() {

    }

    public void criarConta(String msg, int numero, String nome, double saldo) throws RuntimeException {

        if (msg.equals("poupanca") || msg.equals("poupança")) {

            double taxa = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a taxa de juros (%):"));
            conta.add(new Poupança(taxa, numero, saldo, nome));
            return;

        }

        if (msg.equals("empresarial")) {

            double limiteEmprestimo = Double
                    .parseDouble(JOptionPane.showInputDialog(null, "Digite o limite de emprestimo da empresa:"));
            conta.add(new ContaEmpresarial(numero, saldo, nome, limiteEmprestimo));
            return;

        }

        throw new RuntimeException("Erro, digite corretamente!");

    }

    public void deletarConta(int numero) throws RuntimeException {

        for (Conta conta : this.conta) {

            if (conta.getNumero() == numero) {

                this.conta.remove(conta);
                return;

            }
        }

        throw new RuntimeException("Não foi possivel encontrar a conta! ");
    }

    public String retornarInformacao(int con) throws RuntimeException {

        for (Conta conta : this.conta) {

            if (conta.getNumero() == con) {

                if (conta instanceof ContaEmpresarial) {

                    ContaEmpresarial c = (ContaEmpresarial) conta;
                    return String.format("CONTA EMPRESARIAL \n\n Numero da conta: " + c.getNumero() + "\n Saldo: "
                            + c.getSaldo() + " \n Nome: " + c.getNomeCliente() + " \n Limite emprestimo: "
                            + c.getLimiteEmprestimo());

                }

                if (conta instanceof Poupança) {

                    Poupança c = (Poupança) conta;
                    return String.format(
                            "CONTA EMPRESARIAL \n\n Numero da conta: " + c.getNumero() + "\n Saldo: " + c.getSaldo()
                                    + " \n Nome: " + c.getNomeCliente() + " \n Taxa de juros: " + c.getTaxaJuros());

                }
            }
        }

        throw new RuntimeException("Erro conta não encontrada!");

    }

    public String saque(int cont, double saque) throws RuntimeException {

        for (Conta conta : this.conta) {

            if (conta.getNumero() == cont) {

                conta.saque(saque);
                return String.format("Novo saldo: " + conta.getSaldo());

            }
        }

        throw new RuntimeException("Erro não foi possivel encontrar a conta!");

    }

    public String depositar(int cont, double deposito) throws RuntimeException {

        for (Conta conta : this.conta) {

            if (conta.getNumero() == cont) {

                conta.depositar(deposito);
                return String.format("Novo saldo: " + conta.getSaldo());

            }
        }

        throw new RuntimeException("Erro, não foi possivel encontrar a conta ");

    }

    public String atualizarJuros(int cont) throws RuntimeException {

        boolean t = false;
        for (Conta conta : this.conta) {

            if (conta.getNumero() == cont) {
                if (conta instanceof Poupança) {

                    Poupança c1 = (Poupança) conta;

                    c1.atualizarJuros();
                    t = true;
                    return "Taxa de juros atualizada!!";

                }
            }
        }

        if (!t) {
            throw new RuntimeException("Erro não é uma conta poupança!!!");
        }
        throw new RuntimeException("Erro, não foi possivel encontrar a conta ");

    }

    public String RealizarEmprestimo(int cont, double emprestimo) throws RuntimeException {

        boolean t = false;
        for (Conta conta : this.conta) {

            if (conta.getNumero() == cont) {
                if (conta instanceof ContaEmpresarial) {

                    ContaEmpresarial c1 = (ContaEmpresarial) conta;

                    c1.realizarEmprestimo(emprestimo);
                    t = true;
                    return "Emprestimo realizado";

                }
            }
        }

        if (!t) {
            throw new RuntimeException("Erro não é uma conta empresarial!!!");
        }
        throw new RuntimeException("Erro, não foi possivel encontrar a conta ");

    }
}