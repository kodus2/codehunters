package hu.codehunters.serviceb.repository.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class ForbiddenWord {

	@Id
	@GeneratedValue
	private Long id;

	private String forbiddenWord;
}
