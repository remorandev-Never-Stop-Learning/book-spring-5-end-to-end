package es.spring5.remoran.cms.domain.repository;

import es.spring5.remoran.cms.domain.model.News;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface NewsRepository extends ReactiveMongoRepository<News, String> {
}
