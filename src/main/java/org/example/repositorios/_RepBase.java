package org.example.repositorios;

import org.example.entidades._EntidadeBase;

import java.util.ArrayList;
import java.util.List;

public interface _RepBase <T extends _EntidadeBase> {

    void adicionar(T entidade);
    void atualizar(T entidade);
    void remover (T entidade);
    List<T> listar();
}
