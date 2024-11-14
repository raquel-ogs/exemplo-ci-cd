package libellus.exemplocicd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("listas")
public class ListaController {
    @Autowired
    private ListaService listaService;

    @GetMapping
    public ResponseEntity<List<String>> getLista(){
        if(listaService.getLista().isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaService.getLista());
    }

    @GetMapping("/{indice}")
    public ResponseEntity<String> getItemByIndice(@PathVariable int indice){
        String itemBusca = listaService.getItemByIndice(indice);
        return ResponseEntity.ok(itemBusca);
    }

    @PostMapping
    public ResponseEntity<String> cadastrar(@RequestBody String item){
        String itemAdicionado = listaService.adicionarItem(item);
        return ResponseEntity.status(201).body(itemAdicionado);
    }

    @DeleteMapping
    public ResponseEntity<Void> remover(@RequestBody String item){
        listaService.removerItem(item);
        return ResponseEntity.noContent().build();
    }
}
