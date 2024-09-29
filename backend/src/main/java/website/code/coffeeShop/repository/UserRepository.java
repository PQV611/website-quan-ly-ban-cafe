package website.code.coffeeShop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import website.code.coffeeShop.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);

    Users findByEmail(String email);

    Users findByPhone(String phone);

    void deleteById(int uid);

}
