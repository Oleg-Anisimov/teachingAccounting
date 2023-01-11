package me.anisimov.teachingAccounting.domain;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseEntity {

    abstract Serializable getId();
}
