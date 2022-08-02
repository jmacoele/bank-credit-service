package com.nttdata.bankcreditservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.bankcreditservice.model.document.Credit;
import com.nttdata.bankcreditservice.service.CreditService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/credits")
@Slf4j
public class CreditController {

  @Autowired
  private CreditService creditService;

  @GetMapping
  @Operation(summary = "Get list of Credits")
  public Flux<Credit> getAll(){
    log.info("getAll" + "OK");
    return creditService.findAll().log();
  }

  @GetMapping("{id}")
  @Operation(summary = "Get Credit by Id")
  public Mono<Credit> getById(@PathVariable("id") final String id) {
    log.info("getById: " + id);
    return creditService.findById(id).log();
  }

  @PutMapping("{id}")
  @Operation(summary = "Update Credit by Id")
  public Mono<Credit> updateById(@PathVariable("id") final String id, @RequestBody final Credit credit) throws Exception {
    log.info("update: " + id);
    return creditService.save(id, credit).log();
  }

  @PostMapping (
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Create Credit")
  public Mono<Credit> create(@RequestBody final Credit credit) throws Exception {
    log.info("create: " + credit.getNumber());
    return creditService.save(credit).log();
  }

  @DeleteMapping("{id}")
  @Operation(summary = "Delete Credit")
  public Mono<Credit> delete(@PathVariable final String id) {
    log.info("delete: " + id);
    return creditService.delete(id).log();
  }

  @GetMapping("/exists/{id}")
  @Operation(summary = "verify existence of Credit")
  public Mono<Boolean> existsById(@PathVariable("id") final String id) {
    log.info("exists by: " + id);
    return creditService.existsById(id).log();
  }
}