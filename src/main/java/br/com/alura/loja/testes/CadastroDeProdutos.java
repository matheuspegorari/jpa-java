package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.testes.br.com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProdutos {
    public static void main(String[] args) {
        Categoria catCelular =
                new Categoria("Celular");
        Produto celular =
                new Produto("1","2",new BigDecimal("580"), catCelular);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);
        CategoriaDao catDao = new CategoriaDao(em);

        em.getTransaction().begin();
            catDao.cadastrar(catCelular);
            dao.cadastrar(celular);
            em.getTransaction().commit();
        em.close();
    }
}
