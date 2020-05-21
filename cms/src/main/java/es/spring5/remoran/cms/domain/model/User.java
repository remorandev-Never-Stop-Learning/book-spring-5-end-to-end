package es.spring5.remoran.cms.domain.model;

import lombok.Data;

@Data
public class User {
    String id;
    String identity;
    String name;
    Role role;
}
