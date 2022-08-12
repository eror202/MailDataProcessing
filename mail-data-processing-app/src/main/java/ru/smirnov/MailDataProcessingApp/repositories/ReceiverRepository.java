package ru.smirnov.MailDataProcessingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smirnov.MailDataProcessingApp.models.Receiver;

import java.util.Optional;

@Repository
public interface ReceiverRepository extends JpaRepository<Receiver,Integer> {
    Optional<Receiver> getReferenceByIdentification(Integer identification);
}
