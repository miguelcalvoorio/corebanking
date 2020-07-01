package org.corebanking.depositaccount.contract;

import java.util.stream.Collectors;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController {
    private ContractRepository contractRepository;
    private ContractModelAssembler contractlModelAssembler;

    ContractController(final ContractRepository contractRepository, ContractModelAssembler contractlModelAssembler) {
        this.contractRepository = contractRepository;
        this.contractlModelAssembler = contractlModelAssembler;
    }

    @GetMapping("/accounts")
    public CollectionModel<EntityModel<Contract>> getAccounts() {
        List<EntityModel<Contract>> contracts = contractRepository.findAll().stream()
            .map(contractlModelAssembler::toModel)
            .collect(Collectors.toList());

        return CollectionModel.of(contracts,
            linkTo(methodOn(ContractController.class).getAccounts()).withSelfRel());
    }

    @GetMapping("/accounts/{contractId}")
    public EntityModel<Contract> getAccount(@PathVariable final Long contractId) {
        Contract contract = contractRepository.findById(contractId)
            .orElseThrow(() -> new ContractNotFoundException(contractId));

        return contractlModelAssembler.toModel(contract);
    }
}