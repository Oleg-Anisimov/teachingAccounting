package me.anisimov.teachingAccounting.service;

import lombok.extern.slf4j.Slf4j;
import me.anisimov.teachingAccounting.domain.Enums.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EnumsService {

    private static final Map<String, List<String>> enumMap = new HashMap<>();

    public Map<String, List<String>> getAll(){
        return enumMap;
    }

    private static void putEnumList(Class<? extends Enum> enumType){
        List<String> enumConstants = Arrays.stream(enumType.getEnumConstants()).map(Enum::toString).collect(Collectors.toList());
        enumMap.put(enumType.getSimpleName(), enumConstants);
    }

    @PostConstruct
    public void init(){
        putEnumList(Category.class);
        putEnumList(Position.class);
        putEnumList(ActivityType.class);
        putEnumList(CabinetType.class);
        putEnumList(EmploymentType.class);
        putEnumList(AcademicProductionActivityForm.class);
        putEnumList(AcademicMethodActivityForm.class);
        putEnumList(AcademicMethodActivityType.class);
        putEnumList(EventLevel.class);
        putEnumList(EventType.class);
        putEnumList(ParticipationType.class);
        putEnumList(PromotionForm.class);
        putEnumList(WorkVector.class);
    }
}
