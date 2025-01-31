package com.texte.primeiraapi.repository;

import java.util.ArrayList;//importando o objeto arrylista
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;


import com.texte.primeiraapi.model.Produto; //importando a classe de model 
import org.springframework.stereotype.Repository;//esta se conectandoao spring para permtir a interção por outros arquivos por meion deste gerenciador

@Repository
public class ProdutoRepository {
    private ArrayList<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoID= 0;

    /**
     * retorna uma lista de produtos 
     * @return lista de produtos 
     *///esse e um comentario responsavel por identificar e apresentar o que as funçoes fazem e esclusivo do javascript 
    public List<Produto> obterTodos(){
        return produtos;
        

    }


    /**
     * metodo que retorna o produto encontrado pelo seu id 
     * @param id do produto que sera localizado
     * @return retorna um produto seja encontrado
     */
    public Optional<Produto> obterPorId(Integer id){
        return produtos
                        .stream()
                        .filter(Produto -> Produto.getId() == id)
                        .findFirst();

    }


    /**
     * metodo para adicionar podto na lista 
     * @param produto que sera adiciionado
     * @return retorna oo produto que foi adicionado na lista 
     */
    public Produto adicionar(Produto produto){
        ultimoID++;
        produto.setId(ultimoID);
        produtos.add(produto);
        return produto;

    }

    /**
     * metodo para deletar o poduto por id 
     * @param id do produto a ser deletado.
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }



    /**
     * Metodo para atualizar o produto da lista 
     * @param produto que sera atualizado
     * @return retorna o produto após atualizar a lista 
     */

    public Produto atualizar(Produto produto){

        //encontrar o produto
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());
        // eu tenho que remover o produto antigo da lista
        if(produtoEncontrado.isEmpty()){
            throw new InputMismatchException("produto não encontrado");
        }
        //eu tenho que remover o produto da antiga lista 
        deletar(produto.getId());
        //depois adicionar o novo produto 
        produtos.add(produto);

        return produto;



    }

    
}
