import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> listacontas;

    public Banco(String nome) {
        this.nome = nome;
        this.listacontas = new ArrayList<>();
    }

    public void addConta (Conta conta){
        listacontas.add(conta);
        System.out.println("Conta criada com sucesso");
    }

    public Conta getConta (int numero) {
        for (Conta conta : listacontas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

    public void removerConta(int numero) {
        Conta conta = getConta(numero);
        if (conta != null) {
            listacontas.remove(conta);
            System.out.println("Conta " + numero + " removida com sucesso.");
        } else {
            System.out.println("Conta " + numero + " não encontrada.");
        }
    }

    public void listarContas(){
        for (Conta conta : listacontas){
            System.out.println(conta.toString());
        }
    }

    public void calcularValorNoBanco(){
        double total = 0;
        for (Conta conta : listacontas){
            total += conta.getSaldo();
        }
        System.out.println("O valor total armazenado no banco é de: R$"+ total);
    }
}



