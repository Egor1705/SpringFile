package by.bsu.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import by.bsu.app.model.Subject;
@Repository
public interface SubjectRepo extends CrudRepository<Subject,Integer> {
List<Subject> findByPrefix(String prefix);

@Query("Select s from Subject s where id>11")
List<Subject> findSpecial(); 

}
