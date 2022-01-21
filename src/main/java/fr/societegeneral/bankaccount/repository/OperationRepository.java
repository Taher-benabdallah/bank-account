package fr.societegeneral.bankaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.societegeneral.bankaccount.entity.Operation;
@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{}
