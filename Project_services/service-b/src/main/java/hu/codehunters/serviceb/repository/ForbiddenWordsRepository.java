package hu.codehunters.serviceb.repository;

import hu.codehunters.serviceb.repository.entity.ForbiddenWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RestResource(path = "forbiddenWords")
//@Repository
public interface ForbiddenWordsRepository extends CrudRepository<ForbiddenWord, Long> {

	Optional<ForbiddenWord> findByForbiddenWord(String name);

}
