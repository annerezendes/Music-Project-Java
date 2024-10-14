package org.example.repositorios;

import org.example.entidades._EntidadeBase;

import java.util.ArrayList;
import java.util.List;

public class RepBaseImp <T extends _EntidadeBase> implements _RepBase<T> {

    protected  ArrayList<T> lista = new ArrayList<>();
    @Override
    public void adicionar(T entidade) {
        lista.add(entidade);
    }

    @Override
    public void atualizar(T entidade) {
        var entidadeAntiga = lista.stream().filter(item -> entidade.getId() == item.getId()).findFirst();
        lista.remove(entidadeAntiga);
        lista.add(entidade);
    }

    @Override
    public void remover(T entidade) {
    lista.remove(entidade);
    }

    @Override
    public List<T> listar() {
        return lista;
    }
}
