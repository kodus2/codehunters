package hu.codehunters.serviceb.repository;

import hu.codehunters.serviceb.repository.entity.ForbiddenWord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "forbiddenWords")
public interface ForbiddenWordsRepository extends CrudRepository<ForbiddenWord, Long> {
}
