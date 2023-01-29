package me.anisimov.teachingAccounting.SpringBatch;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

public class AnimalFieldSetMapper implements FieldSetMapper<Animal> {

    @Override
    public Animal mapFieldSet(FieldSet fieldSet) {
        Animal animal = new Animal();
        animal.setId(fieldSet.readString("id"));
        animal.setName(fieldSet.readString("name"));
        return animal;
    }
}
