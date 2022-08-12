package test.java;

import gleidev.com.junit.entidades.Filme;
import gleidev.com.junit.entidades.Locacao;
import gleidev.com.junit.entidades.Usuario;
import gleidev.com.junit.servicos.LocacaoService;
import gleidev.com.junit.utils.DataUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class LocacaoServiceTest {
    @Test
    public void test() {
        //Cenário
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 2, 5.0);
        //Ação
        Locacao locacao = service.alugarFilme(usuario, filme);
        //Verificação
        Assert.assertFalse(locacao.getValor() != 5.0);
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
    }
}
