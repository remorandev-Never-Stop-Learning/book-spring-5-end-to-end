package es.spring5.remoran.cms.domain.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Tag {
    String value;
}
