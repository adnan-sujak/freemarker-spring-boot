package newfreemarker.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {



    //JpaRepositroy is an interface provided by Spring Data JPA. It contains a set of CRUD methods
    // such as save, findbyId, findAll, delete to work with the DB
    //when extending Jparepo, the interface UserRepo inherits all those methods
}
