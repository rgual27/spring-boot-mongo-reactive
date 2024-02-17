package com.vass.reactiveservice.mapper;

import com.vass.reactiveservice.dto.PersonAgeDto;
import com.vass.reactiveservice.dto.PersonDto;
import com.vass.reactiveservice.model.PersonDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(uses = DateToAgeMapper.class, componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface PersonMapper {

    @Mapping(target = "age", source = "birthDay")
    PersonAgeDto asPersonAge(PersonDocument personDocument);

    PersonDto asPerson(PersonDocument personDocument);

    PersonDocument asPersonDocument(PersonDto person);
}
