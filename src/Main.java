import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();

        arvore.inserir(0);
        arvore.inserir(-3);
        arvore.inserir(-5);
        arvore.inserir(-4);
        arvore.inserir(5);
        arvore.inserir(3);
        arvore.inserir(4);
        arvore.inserir(10);
        arvore.inserir(7);
        arvore.inserir(9);

        Scanner leitor = new Scanner(System.in);
        boolean rodando = true;

        while (rodando)
        {
            System.out.print("\nDeseja remover algum nó? (sim/nao): ");
            String resposta = leitor.nextLine();

            if (resposta.equalsIgnoreCase("sim"))
            {
                System.out.print("Digite qual nó você deseja remover: ");
                int valor = Integer.parseInt(leitor.nextLine());

                arvore.remover(valor);
                System.out.println("Nó removido!");

                System.out.print("Qual percurso deseja realizar? (Pre, Em, Pos): ");
                String percurso = leitor.nextLine();

                System.out.println("Exibindo percurso " + percurso + ":");
                arvore.exibir(percurso);
            }
            else
            {
                rodando = false;
            }
        }

        leitor.close();
    }
}