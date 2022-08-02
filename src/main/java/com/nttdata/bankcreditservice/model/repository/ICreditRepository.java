package com.nttdata.bankcreditservice.model.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.bankcreditservice.model.document.Credit;

@Repository
public interface ICreditRepository extends ReactiveMongoRepository<Credit, String> {

}
