package com.vass.reactiveservice.service;

import com.vass.reactiveservice.dto.PersonAgeDto;
import com.vass.reactiveservice.dto.PersonDto;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public interface PersonService {
    Flux<PersonDto> all();

    Flux<PersonAgeDto> allWithAge();

    Mono<PersonDto> byId(String id);

    Mono<PersonDto> create(Mono<PersonDto> person);

    Mono<PersonDto> update(Mono<PersonDto> person);

    Mono<Void> delete(String id);
}
