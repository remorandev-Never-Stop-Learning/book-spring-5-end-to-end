package es.spring5.remoran.cms.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "system_user")
public class User {
    @Id
    @GeneratedValue(generator = "system_uuid")
    @GenericGenerator(name = "system_uuid", strategy = "uuid")
    String id;

    String identity;

    String name;

    Role role;
}
