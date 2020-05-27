package es.spring5.remoran.cms.domain.vo;

import es.spring5.remoran.cms.domain.model.Role;
import lombok.Data;

@Data
public class UserRequest {
    String id;

    String name;

    Role role;
}
