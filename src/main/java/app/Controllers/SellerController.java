package app.Controllers;

import app.Repositories.SellerRepo;
import app.entities.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SellerController {

    @Autowired
    private SellerRepo sellerRepo;

    @RequestMapping(method = RequestMethod.GET, value = "/main")
    public String main(){
        return "main";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/seller")
    public Iterable<Seller> getAll() {
        return sellerRepo.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/seller/{id}")
    public Seller getById(@PathVariable("id") Integer id) {
        return sellerRepo.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/api/seller")
    public void create(
            @RequestBody Seller seller
    )
    {
        sellerRepo.save(seller);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/api/update/{id}")
    public void update(
            @PathVariable("id") Integer id,
            @RequestBody Seller seller
    )
    {
        seller.setId(id);
        sellerRepo.save(seller);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/seller/{id}")
    public void delete(@PathVariable("id") Integer id){
        sellerRepo.deleteById(id);
    }

}
