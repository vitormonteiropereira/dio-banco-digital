public abstract class Conta implements IConta {
    private String ag;
    private int numero;
    private double saldo = 0;
    Cliente cliente;

    public static final String NUMERO_AGENCIA = "1234";
    public static int SEQUENCIAL = 1;

    public Conta(Cliente cliente) {
        this.ag = NUMERO_AGENCIA;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        if (this.sacar(valor) == true) {
            contaDestino.depositar(valor);
            System.out.println("Transferência realizada com sucesso");
        }
        else {
            System.out.println("Saldo insufuciente para transferencia");
        }
    }


    public Cliente getCliente() {
        return cliente;
    }


    public double getSaldo() {
        return saldo;
    }


    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "cliente=" + cliente.getNome() +
                ", numero=" + numero +
                ", ag='" + ag + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
