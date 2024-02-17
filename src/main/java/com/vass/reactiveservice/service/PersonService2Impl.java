package com.vass.reactiveservice.service;

import com.vass.reactiveservice.dto.PersonAgeDto;
import com.vass.reactiveservice.dto.PersonDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService2Impl implements PersonService {
    @Override
    public Flux<PersonDto> all() {
        return null;
    }

    @Override
    public Flux<PersonAgeDto> allWithAge() {
        return null;
    }

    @Override
    public Mono<PersonDto> byId(String id) {
        return null;
    }

    @Override
    public Mono<PersonDto> create(Mono<PersonDto> person) {
        return null;
    }

    @Override
    public Mono<PersonDto> update(Mono<PersonDto> person) {
        return null;
    }

    @Override
    public Mono<Void> delete(String id) {
        return null;
    }
}
