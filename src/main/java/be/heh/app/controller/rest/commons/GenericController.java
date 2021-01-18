package be.heh.app.controller.rest.commons;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1")
// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class GenericController {

    List<String> authorized = new ArrayList<>();

    @PostConstruct
    public void init() {
        //authorized.add("category");
    }

    private void authorized(String objet) {
        if (authorized.contains(objet)) {
            // throw new Exception("BLBAL");
        }
    }

    /*@GetMapping("/{variable}")
    public List getAll(@PathVariable("variable") String objet) {
        authorized(objet);
        AbstractService service = InitService.serviceMap.get(objet);
        return (List) service.getAll();
    }

    @GetMapping("/{variable}/{id}")
    public Object get(@PathVariable("variable") String objet, @PathVariable("id") String str) {
        int id = Utils.StringToInt(str);
        if (id == 0) {
            //TODO erreur
        }
        authorized(objet);
        AbstractService service = InitService.serviceMap.get(objet);
        return (Object) service.get(id);
    }*/

    /*@DeleteMapping("/{variable}/{id}")
    public void delete(@PathVariable("variable") String objet, @PathVariable("id") String str) {
        int id = Utils.StringToInt(str);
        if (id == 0) {
            //TODO erreur
        }
        authorized(objet);
        AbstractService service = InitService.serviceMap.get(objet);
        service.delete(id);
    }*/

}
