package es.spring5.remoran.cms.domain.repository;

import es.spring5.remoran.cms.domain.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface CategoryRepository extends MongoRepository<Category, String> {

}
