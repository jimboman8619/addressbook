package boot.repository;

import boot.entity.Person;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Viktor Eltyshev
 * DAO уровень
 */
public interface PersonRepository extends CrudRepository<Person, Integer> {

}
