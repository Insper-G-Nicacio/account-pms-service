package insper.store.account;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account create(Account account) {
        return accountRepository.save(new AccountModel(account)).to();
    }

    public void delete(String id) {
        accountRepository.deleteById(id);
    }

    public Account findById(String id) {
        return accountRepository.findById(id).orElse(null).to();
    }

    public List<Account> findByAll() {
        return StreamSupport.stream(
            accountRepository.findAll().spliterator(),
            false
        ).map(AccountModel::to)
        .toList();
    }

}