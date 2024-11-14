package libellus.exemplocicd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ListaTestes {
    @Test
    @DisplayName("Testa se adicionou o item1 na primeira posição")
    public void testarAdicionarItem(){
        ListaService listaService = new ListaService();
        listaService.adicionarItem("item1");
        listaService.adicionarItem("item2");
        listaService.adicionarItem("item3");

        assertEquals(listaService.getLista().size(), 3);
        assertEquals("item1", listaService.getItemByIndice(0));
    }

    @Test
    @DisplayName("Testa se removeu o item1 da lista")
    public void testaRemoverItem(){
        ListaService listaService = new ListaService();
        listaService.adicionarItem("item1");

        assertEquals(true, listaService.removerItem("item1"));
    }
}
