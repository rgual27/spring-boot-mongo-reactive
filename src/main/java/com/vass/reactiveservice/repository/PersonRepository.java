package com.vass.reactiveservice.repository;

import com.vass.reactiveservice.model.PersonDocument;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends ReactiveMongoRepository<PersonDocument, String> { }
