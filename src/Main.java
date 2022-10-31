import java.util.Scanner;

public class Main {

    private static String[] nomes;
    private static float[] av1;
    private static float[] av2;
    private static final int TAMANHO = 4;

    public static void main(String[] args) {

        nomes = new String[TAMANHO];
        av1 = new float[TAMANHO];
        av2 = new float[TAMANHO];

        Scanner in = new Scanner(System.in);

        String opcao;
        int pos = 0;

        do {
            System.out.println("[1] Registar as notas de um novo aluno");
            System.out.println("[2] Consultar boletim de um aluno");
            System.out.println("[3] Consultar notas da turma");
            System.out.println("[4] Sair");

            System.out.print("Informe a opção desejada: ");
            opcao = in.next();

            switch (opcao) {
                case "1":
                    if(pos < TAMANHO) {
                        System.out.print("Informe o nome do aluno: ");
                        nomes[pos] = in.next();

                        System.out.print("Informe a nota AV1 do aluno: ");
                        av1[pos] = in.nextFloat();

                        System.out.print("Informe a nota AV2 do aluno: ");
                        av2[pos] = in.nextFloat();

                        imprimir(pos);

                        pos++;
                    } else {
                        System.out.println("Impossível realizar a inserção de notas do aluno!");
                    }
                    break;
                case "2":
                    System.out.print("Informe o funcionário para impressão: ");
                    int id = in.nextInt();

                    if(id >= 0 && id < pos) {
                        imprimir(id);
                        break;
                    } else {
                        System.out.println("O índice ["+ id +"} é inválido!");
                        break;
                    }
                case "3":
                    imprimir();
                    break;

                case "4":
                    System.out.println("Saída");
                    break;

                default:
                    System.out.println("A opção ["+opcao+"] inválida");
                    break;
            }
        } while (!"4".equalsIgnoreCase(opcao));

        System.out.println("Hello world!");

        in.close();
    }
    
    private static void imprimir(int indice) {
        float nota = calcularNota(indice);
        String situacao = obterSituacao(nota);

        System.out.println("------------------------------------------");
        System.out.println("Nome do Aluno: " + nomes[indice]);
        System.out.println("Nota da AV1: " + av1[indice]);
        System.out.println("Nota da AV2: " + av2[indice]);
        System.out.println("Média final: " + nota);
        System.out.println("Situação: " + situacao + "\n");
    }

    private static String obterSituacao(float nota) {
        if(nota < 4) {
            return "Reprovado!";
        } else if (nota >= 4 && nota < 7) {
            return "Prova Final!";
        } else if (nota >= 7) {
            return "Aprovado!";
        } else {
            return "Aluno não obteve nota!";
        }
    }

    private static float calcularNota(int indice) {
        float nota = av1[indice] + av2[indice];
        return nota / 2;
    }

    private static void imprimir() {
        for (int i = 0; i < TAMANHO; i++) {
            if(nomes[i] != null) {
                imprimir(i);
            }
        }
    }
}