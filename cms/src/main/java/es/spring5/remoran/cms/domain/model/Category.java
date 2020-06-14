package es.spring5.remoran.cms.domain.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection =  "category")
public class Category {

    @Id
    String id;

    String name;
}
