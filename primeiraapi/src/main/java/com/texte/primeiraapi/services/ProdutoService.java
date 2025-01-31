package com.texte.primeiraapi.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.texte.primeiraapi.model.Produto;
import com.texte.primeiraapi.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;


    /**
     * retorna todos os prdutos 
     * @return
     */
    public List<Produto> obterTodos(){

        return produtoRepository.obterTodos();
    }


    public Optional<Produto> obterPorId(Integer id){
        return produtoRepository.obterPorId(id);
    }

    public Produto adicionar(Produto produto){
        //poderia ter auguma regra de negocio aqui para validar o produto.
        return produtoRepository.adicionar(produto);
    }

    public void deletar(Integer id){
        produtoRepository.deletar(id);
    }

    public Produto atualizar(Integer id,Produto produto){
        produto.setId(id);

        return produtoRepository.atualizar(produto);






    }


    
}
