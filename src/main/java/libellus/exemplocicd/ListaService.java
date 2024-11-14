package libellus.exemplocicd;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListaService {
    private List<String> lista;

    public ListaService(){
        lista = new ArrayList<>();
    }

    public String adicionarItem(String item){
        if(item == null || item.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Item não pode ser vazio");
        }

        lista.add(item);
        return lista.get(lista.size() - 1);
    }

    public boolean removerItem(String item){
        if(!lista.contains(item)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado");
        }

        lista.remove(item);
        return true;
    }

    public List<String> getLista(){
        return lista;
    }

    public String getItemByIndice(int indice){
        if(indice < 0 || indice >= lista.size()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado");
        }

        return lista.get(indice);
    }
}
