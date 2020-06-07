package es.spring5.remoran.cms.domain.service;

import es.spring5.remoran.cms.domain.repository.NewsRepository;
import org.springframework.stereotype.Service;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }


}
