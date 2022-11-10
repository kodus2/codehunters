package hu.codehunters.serviceb.repository.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@EqualsAndHashCode
@Entity
public class ForbiddenWord {



	@Id
	@GeneratedValue
	private Long id;

	@EqualsAndHashCode.Exclude
	private String forbiddenWord;
}
