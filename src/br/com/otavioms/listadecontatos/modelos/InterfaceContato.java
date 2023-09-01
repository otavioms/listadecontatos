package br.com.otavioms.listadecontatos.modelos;

import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceContato {

    private Scanner scanner;
    private ControladorContato controladorContato;

    public InterfaceContato() {
        scanner = new Scanner(System.in);
        controladorContato = new ControladorContato();
    }

    private int obterOpcao() {
        System.out.println("#########################");
        System.out.println("Lista de Contatos");
        System.out.println("1. Incluir");
        System.out.println("2. Localizar");
        System.out.println("3. Excluir");
        System.out.println("4. Listar");
        System.out.println("0. Sair");
        System.out.println("########################");
        System.out.print("Opcao: ");

        return scanner.nextInt();
    }

    private void incluirContato() {
        String nome;
        String telefone;
        String email;

        System.out.print("Nome: ");
        nome = scanner.next();
        System.out.print("Telefone: ");
        telefone = scanner.next();
        System.out.print("Email: ");
        email = scanner.next();

        Contato contato = new Contato(nome, telefone, email);
        controladorContato.incluirContato(contato);
    }

    private void localizarContato() {
        String nome;

        System.out.print("Informe o nome: ");
        nome = scanner.next();

        Contato contato = controladorContato.selecionarContatoPorNome(nome);
        if (contato != null) {
            System.out.println("Contato\n"
                    + "Nome: " + contato.getNome() + "\n"
                    + "Telefone: " + contato.getTelefone() + "\n"
                    + "Email: " + contato.getEmail());
        } else {
            System.out.println("Contato nao encontrado");
        }
    }

    private void excluirContato() {
        String nome;

        System.out.print("Informe o nome: ");
        nome = scanner.next();

        Contato contato = controladorContato.selecionarContatoPorNome(nome);
        if (contato != null) {
            controladorContato.excluirContato(contato);
            System.out.println("Contato excluido");
        } else {
            System.out.println("Contato nao encontrado");
        }
    }

    private void listarContatos() {
        ArrayList<Contato> contatos = controladorContato.obterContatos();
        Contato contato = null;
        for (int i = 0; i < contatos.size(); i++) {
            contato = contatos.get(i);
            System.out.println("Nome: " + contato.getNome()
                    + " Telefone: " + contato.getTelefone()
                    + " Email: " + contato.getEmail());
        }
    }

    public void executar(){
        int opcao = 0;
        do{
            opcao = obterOpcao();
            switch (opcao){
                case 1: incluirContato();
                    break;
                case 2: localizarContato();
                    break;
                case 3: excluirContato();
                    break;
                case 4: listarContatos();
            }
        }while(opcao != 0);
    }
}
