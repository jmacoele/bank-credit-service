package com.nttdata.bankcreditservice.model.service;

import com.nttdata.bankcreditservice.model.document.Credit;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
/**
 * ICreditService Interface.
 *
 * @author jmacoele
 *
 */

public interface ICreditService {

  Mono<Credit> findById(String id);

  Flux<Credit> findAll();

  Mono<Boolean> existsById(String id);

  Mono<Credit> save(Credit credit) throws Exception;

  Mono<Credit> save(String id, Credit credit) throws Exception;

  Mono<Credit> delete(String id);

}
