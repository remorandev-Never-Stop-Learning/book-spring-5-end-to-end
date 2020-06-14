package es.spring5.remoran.cms.domain.repository;

import es.spring5.remoran.cms.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserRepository extends MongoRepository<User, String> {

}
