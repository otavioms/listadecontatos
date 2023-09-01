package br.com.otavioms.listadecontatos.modelos;

import java.util.ArrayList;

public class ControladorContato {
    private ArrayList<Contato> contatos;

    public ControladorContato(){
        contatos = new ArrayList<Contato>();
    }

    public void incluirContato(Contato contato){
        contatos.add(contato);
    }

    public void excluirContato(Contato contato){
        contatos.remove(contato);
    }

    public Contato selecionarContatoPorNome(String nome){
        Contato contato = null;
        for(int i = 0; i <contatos.size(); i++){
            if(contatos.get(i).getNome().equals(nome)){
                contato = contatos.get(i);
                break;
            }
        }
        return contato;
    }

    public ArrayList<Contato>obterContatos(){
        return contatos;
    }
}
