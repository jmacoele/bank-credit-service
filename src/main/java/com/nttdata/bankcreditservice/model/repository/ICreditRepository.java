package com.nttdata.bankcreditservice.model.repository;

import com.nttdata.bankcreditservice.model.document.Credit;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
/**
 * ICreditRepository interface.
 *
 * @author jmacoele
 *
 */

@Repository
public interface ICreditRepository
    extends ReactiveMongoRepository<Credit, String> {

}
