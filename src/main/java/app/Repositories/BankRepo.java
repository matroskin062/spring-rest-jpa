package app.Repositories;

import app.entities.Bank;
import org.springframework.data.repository.CrudRepository;

public interface BankRepo extends CrudRepository<Bank, Long> {
}
