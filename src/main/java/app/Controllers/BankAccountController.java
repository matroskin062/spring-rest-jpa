package app.Controllers;

import app.Repositories.BankAccountRepo;
import app.entities.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class BankAccountController {
    @Autowired
    private BankAccountRepo accountRepo;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<BankAccount> getAll(){
        return accountRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public BankAccount getById(@PathVariable("id") Long id){
        return accountRepo.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void add(@RequestBody BankAccount account){
        accountRepo.save(account);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void update(
            @PathVariable("id") Integer id,
            @RequestBody BankAccount account
    )
    {
        account.setId(id);
        accountRepo.save(account);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        accountRepo.deleteById(id);
    }
}
