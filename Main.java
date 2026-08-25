import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        paciente[] pacientes = new paciente[200];
        int qtdPacientes = 0;

        consulta[] consultas = new consulta[200];
        int qtdConsultas = 0;

        int opcao;

        do {

            System.out.println("\n==============================");
            System.out.println("       SISTEMA CLÍNICO");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar paciente");
            System.out.println("2 - Listar pacientes");
            System.out.println("3 - Buscar paciente");
            System.out.println("4 - Cadastrar consulta");
            System.out.println("5 - Listar consultas");
            System.out.println("6 - Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            switch (opcao) {

                case 1:
                    qtdPacientes = cadastroPaciente(pacientes, qtdPacientes, teclado);
                    break;

                case 2:
                    listarPacientes(pacientes, qtdPacientes);
                    break;

                case 3:
                    buscarPaciente(pacientes, qtdPacientes, teclado);
                    break;

                case 4:
                    qtdConsultas = cadastroConsulta(consultas, qtdConsultas, pacientes, qtdPacientes, teclado);
                    break;

                case 5:
                    listarConsultas(consultas, qtdConsultas);
                    break;

                case 6:
                    System.out.println("\nSistema encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (opcao != 6);

        teclado.close();
    }


    public static int cadastroPaciente(paciente[] pacientes, int qtdPacientes, Scanner teclado) {

        if (qtdPacientes >= pacientes.length) {

            System.out.println("Lista de pacientes cheia.");

            return qtdPacientes;
        }

        System.out.println("\n===== CADASTRO DE PACIENTE =====");

        System.out.print("Digite o nome do(a) paciente: ");
        String nome = teclado.nextLine();

        System.out.print("Digite o telefone do paciente: ");
        String telefone = teclado.nextLine();

        paciente paciente1 = new paciente(nome, telefone);

        pacientes[qtdPacientes] = paciente1;

        qtdPacientes++;

        System.out.println("\nPaciente cadastrado com sucesso!");

        return qtdPacientes;
    }


    public static void listarPacientes(paciente[] pacientes, int qtdPacientes) {

        System.out.println("\n===== LISTA DE PACIENTES =====");

        if (qtdPacientes == 0) {

            System.out.println("Nenhum paciente cadastrado.");

            return;
        }

        for (int i = 0; i < qtdPacientes; i++) {

            System.out.println("\nPaciente " + (i + 1));
            System.out.println("Nome: " + pacientes[i].getNome());
            System.out.println("Telefone: " + pacientes[i].getTelefone());
        }
    }


    public static void buscarPaciente(paciente[] pacientes, int qtdPacientes, Scanner teclado) {

        System.out.println("\n===== BUSCAR PACIENTE =====");

        if (qtdPacientes == 0) {

            System.out.println("Nenhum paciente cadastrado.");

            return;
        }

        System.out.print("Digite o nome do paciente: ");
        String nomeBusca = teclado.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < qtdPacientes; i++) {

            if (pacientes[i].getNome().equalsIgnoreCase(nomeBusca)) {

                System.out.println("\nPaciente encontrado!");
                System.out.println("Nome: " + pacientes[i].getNome());
                System.out.println("Telefone: " + pacientes[i].getTelefone());

                encontrado = true;
            }
        }

        if (!encontrado) {

            System.out.println("\nPaciente não encontrado.");
        }
    }

    public static int cadastroConsulta(consulta[] consultas, int qtdConsultas, paciente[] pacientes, int qtdPacientes, Scanner teclado) {

        if (qtdConsultas >= consultas.length) {

            System.out.println("Agenda de consultas está cheia.");

            return qtdConsultas;
        }

        if (qtdPacientes == 0) {

            System.out.println("\nNão é possível cadastrar uma consulta.");
            System.out.println("Cadastre pelo menos um paciente primeiro.");

            return qtdConsultas;
        }

        System.out.println("\n===== CADASTRO DE CONSULTA =====");

        System.out.println("\nEscolha o paciente:");

        for (int i = 0; i < qtdPacientes; i++) {

            System.out.println((i + 1) + " - " + pacientes[i].getNome());
        }

        System.out.print("Digite o número do paciente: ");

        int escolhaPaciente = teclado.nextInt();
        teclado.nextLine();


        if (escolhaPaciente < 1 || escolhaPaciente > qtdPacientes) {

            System.out.println("Paciente inválido!");

            return qtdConsultas;
        }


        paciente pacienteEscolhido = pacientes[escolhaPaciente - 1];

        System.out.println("\nPaciente selecionado: " + pacienteEscolhido.getNome());


        System.out.print("Digite a data da consulta (dd/mm/aaaa): ");
        String dataConsulta = teclado.nextLine();

        int consultasNoDia = 0;
        int  limiteConsultasDia=10;

        for (int i = 0; i < qtdConsultas; i++) {

            if (consultas[i].getDataConsulta().equals(dataConsulta)) {
                consultasNoDia++;
            }
        }
        if (consultasNoDia >= limiteConsultasDia) {

            System.out.println("\nEssa data já atingiu o limite de " + limiteConsultasDia + " consultas!");

            return qtdConsultas;
        }

        System.out.print("Digite o tipo da consulta: ");
        String tipoConsulta = teclado.nextLine();

        System.out.print("Digite o horário da consulta: ");
        String horarioConsulta = teclado.nextLine();
        for (int i = 0; i < qtdConsultas; i++) {

            if (consultas[i].getDataConsulta().equals(dataConsulta) && consultas[i].gethorarioConsulta().equals(horarioConsulta)) {
                System.out.println("\nERRO: Já existe uma consulta");
                System.out.println("nesse horário nessa data!");
                return qtdConsultas;
            }
        }
        System.out.print("Digite o valor da consulta: R$ ");
        double valorConsulta = teclado.nextDouble();

        teclado.nextLine();

        consulta consulta1 = new consulta(tipoConsulta, valorConsulta, horarioConsulta,dataConsulta, pacienteEscolhido);

        consultas[qtdConsultas] = consulta1;

        qtdConsultas++;

        System.out.println("\nConsulta cadastrada com sucesso!");

        return qtdConsultas;
    }


    public static void listarConsultas(consulta[] consultas, int qtdConsultas) {

        System.out.println("\n===== LISTA DE CONSULTAS =====");

        if (qtdConsultas == 0) {

            System.out.println("Nenhuma consulta cadastrada.");

            return;
        }

        for (int i = 0; i < qtdConsultas; i++) {

            System.out.println("\nConsulta " + (i + 1));

            System.out.println("Paciente: " + consultas[i].getPaciente().getNome());

            System.out.println("Telefone: " + consultas[i].getPaciente().getTelefone());

            System.out.println("Tipo: " + consultas[i].getTipoConsulta());

            System.out.println("Valor: R$ " + consultas[i].getValorConsulta());

            System.out.println("Horário: " + consultas[i].gethorarioConsulta());

            System.out.println("Data: " + consultas[i].getDataConsulta());

            System.out.println("--------------------------");
        }
    }
}





