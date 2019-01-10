package app.Repositories;

import app.entities.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepo extends CrudRepository<BankAccount, Long> {
}
