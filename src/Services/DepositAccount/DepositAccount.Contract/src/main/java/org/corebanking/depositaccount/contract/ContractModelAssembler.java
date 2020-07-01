package org.corebanking.depositaccount.contract;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.EntityModel;

import org.springframework.stereotype.Component;

@Component
public class ContractModelAssembler implements RepresentationModelAssembler<Contract, EntityModel<Contract>> {
    @Override
    public EntityModel<Contract> toModel(final Contract contract) {
        return EntityModel.of(contract,
            linkTo(methodOn(ContractController.class).getAccount(contract.getContractId())).withSelfRel(),
            linkTo(methodOn(ContractController.class).getAccounts()).withRel("accounts"));
    }
}