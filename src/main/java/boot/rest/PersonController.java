package boot.rest;

import boot.PersonService;
import boot.entity.Person;
import boot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository repository;

    /**
     * Метод для отображения информации о всех сотрудниках
     */
    @RequestMapping(value="/api/persons")
    public ResponseEntity<Object> findAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    /**
     * Метод для вставки нового сотрудника в адресную книгу
     * @param person тело запроса в формате JSON
     */
    @RequestMapping(value="/api/persons",method = RequestMethod.POST)
    public void createPerson(@RequestBody Person person){
        repository.save(person);
    }

    /**
     * Метод для посиска информации о сотруднике по его табельному номеру
     * @param id табельный номер сотрудника, данные которого нужн обновить
     */    
    @RequestMapping(value="/api/persons/{id}",method = RequestMethod.GET)
    public ResponseEntity<Object> findPersonById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    /**
     * Метод для обновления информации о сотруднике по id
     * @param id сотрудника, данные которого нужн обновить
     * @param person тело запроса запроса в формате JSON
     */
    @RequestMapping(value="/api/persons/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Object> updatePersonById(@PathVariable("id") Integer id, @RequestBody Person person) {
        Optional<Person> personOptional = repository.findById(id);
        if (!personOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Person oldPerson = personOptional.get();
        PersonService personService = new PersonService();
        try {
            personService.copyNonNullProperties(person, oldPerson);
        } catch ( IllegalAccessException e ) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        repository.save(oldPerson);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /**
     * Метод для удаления информации сотрудника по id
     * @param id сотрудника, данные которого нужн обновить
     */
    @RequestMapping(value="/api/persons/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deletePersonById(@PathVariable("id") Integer id) {
        Optional<Person> personOptional = repository.findById(id);
        if (!personOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Person person = personOptional.get();
        repository.delete(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Метод для удаления информации о всех сотрудниках
     */
    @RequestMapping(value="/api/persons",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAllPersons() {
        repository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }


    }
