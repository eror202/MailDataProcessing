package ru.smirnov.MailDataProcessingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smirnov.MailDataProcessingApp.models.PostPath;
import ru.smirnov.MailDataProcessingApp.models.Receiver;

import java.util.Optional;

@Repository
public interface PostPathRepository extends JpaRepository<PostPath,Integer> {
    Optional<PostPath> findPostPathByReceiverIdentification(Receiver receiver);
}
