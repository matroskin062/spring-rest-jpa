package app.Controllers;

import app.Repositories.BankRepo;
import app.entities.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankRepo bankRepo;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Bank> getAll(){
        return bankRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Bank getById(@PathVariable("id") Long id){
        return bankRepo.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void add(@RequestBody Bank bank){
        bankRepo.save(bank);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void update(
            @PathVariable("id") Integer id,
            @RequestBody Bank bank
    )
    {
        bank.setId(id);
        bankRepo.save(bank);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        bankRepo.deleteById(id);
    }
}
