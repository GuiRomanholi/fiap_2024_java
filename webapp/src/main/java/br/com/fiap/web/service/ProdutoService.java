package br.com.fiap.web.service;

import br.com.fiap.web.dao.ProdutoDao;
import br.com.fiap.web.model.Produto;

import java.util.List;

public class ProdutoService {

    private ProdutoDao produtoDao = new ProdutoDao();

    public List<Produto> listar(){
        return produtoDao.listar();
    }

    //Retorna um unico produto -> buscarPoId
    public Produto buscarPorId(int codigo){
        return produtoDao.buscarPorId(codigo);
    }

}
