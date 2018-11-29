package br.edu.ifsul.util.relatorios;

import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para ser utilizada como fonte de dados no JasperStudio 
 * a fim de ser possivel testar um relatório com fonte de dados JavaBeans
 * @author Prof. Me. Jorge Luis Boeira Bavaresco
 * @email jorge.bavaresco@passofundo.ifsul.edu.br
 * @organization IFSUL - Campus Passo Fundo
 */
public class FabricaObjetos {

    public static List<Produto> carregaProdutos(){
        List<Produto> lista = new ArrayList<>();
        Marca m = new Marca();
        m.setNome("Dell");
        Produto p1 = new Produto();
        p1.setMarca(m);
        p1.setId(1);
        p1.setNome("Mouse Laser");
        p1.setPreco(120.00);
        lista.add(p1);
        Produto p2 = new Produto();
        p2.setMarca(m);
        p2.setId(2);
        p2.setNome("Teclado sem fio");
        p2.setPreco(150.00);
        lista.add(p2);  
        return lista;
    }
}
