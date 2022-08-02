package com.nttdata.bankcreditservice.service;

import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bankcreditservice.model.document.Credit;
import com.nttdata.bankcreditservice.model.document.type.CreditTypeEnum;
import com.nttdata.bankcreditservice.model.repository.ICreditRepository;
import com.nttdata.bankcreditservice.model.service.ICreditService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CreditService implements ICreditService {

  @Autowired
  private ICreditRepository creditRepository;

  @Override
  public Mono<Credit> findById(String id) {
    return this.creditRepository.findById(id)
        .switchIfEmpty(Mono.empty());
  }

  @Override
  public Flux<Credit> findAll() {
    return this.creditRepository.findAll()
        .switchIfEmpty(Flux.empty());
  }

  private void validateCredit(Credit credit) throws Exception {

    /***
     * Reglas para credito Personal
     */

    if (credit.getCreditType().equals(CreditTypeEnum.PERSONAL)) {
      String clientId = credit.getClientId();

      creditRepository.findAll()
          .any(x -> x.getClientId().equals(clientId)
              && !x.getId().equals(credit.getId()))
          .then(Mono.error(new Exception(
              "Credito personal solo se permite un solo crédito por persona.")));
    }

  }

  @Override
  public Mono<Credit> save(Credit credit) throws Exception {
    credit.setId(UUID.randomUUID().toString());
    validateCredit(credit);
    return this.creditRepository.save(credit);
  }

  @Override
  public Mono<Credit> save(String id, Credit credit)
      throws Exception {
    validateCredit(credit);
    return this.creditRepository.save(credit);
  }

  @Override
  public Mono<Credit> delete(String id) {
    final Mono<Credit> credit = findById(id);
    if (Objects.isNull(credit)) {
      return Mono.empty();
    }
    return findById(id).switchIfEmpty(Mono.empty())
        .filter(Objects::nonNull)
        .flatMap(creditToBeDeleted -> this.creditRepository
            .delete(creditToBeDeleted)
            .then(Mono.just(creditToBeDeleted)));
  }

  @Override
  public Mono<Boolean> existsById(String id) {
    return this.creditRepository.existsById(id);
  }
}
