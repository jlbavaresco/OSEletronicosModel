package br.edu.ifsul.util.relatorios;

import br.edu.ifsul.modelo.ContaReceber;
import br.edu.ifsul.modelo.ContaReceberID;
import br.edu.ifsul.modelo.Marca;
import br.edu.ifsul.modelo.OrdemServico;
import br.edu.ifsul.modelo.PessoaFisica;
import br.edu.ifsul.modelo.Produto;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    public static List<ContaReceber> carregaContas(){
        List<ContaReceber> lista = new ArrayList<>();
        PessoaFisica pf = new PessoaFisica();
        pf.setNome("João da Silva");
        pf.setCpf("999.999.345-87");
        OrdemServico os = new OrdemServico();
        os.setPessoaFisica(pf);
        os.setId(1);
        ContaReceber conta = new ContaReceber();
        ContaReceberID id = new ContaReceberID();
        id.setOrdemServico(os);
        id.setNumeroParcela(1);
        conta.setId(id);
        conta.setValor(500.00);
        conta.setVencimento(Calendar.getInstance());
        lista.add(conta);
        return lista;
    }
}
