package app.Controllers;

import app.Repositories.ClientRepo;
import app.entities.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepo clientRepo;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Client> getAll(){
        return clientRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Client getById(@PathVariable("id") Long id){
        return clientRepo.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void add(@RequestBody Client client){
        clientRepo.save(client);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void update(
            @PathVariable("id") Integer id,
            @RequestBody Client client
    )
    {
        client.setId(id);
        clientRepo.save(client);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "delete/{id}")
    public void delete(@PathVariable("id") Long id){
        clientRepo.deleteById(id);
    }

}
