package app.Repositories;

import app.entities.Seller;
import org.springframework.data.repository.CrudRepository;

public interface SellerRepo extends CrudRepository<Seller, Integer>
{
}
