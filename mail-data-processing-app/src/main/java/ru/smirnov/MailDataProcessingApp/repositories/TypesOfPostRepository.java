package ru.smirnov.MailDataProcessingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smirnov.MailDataProcessingApp.models.Receiver;
import ru.smirnov.MailDataProcessingApp.models.TypesOfPost;

import java.util.Optional;

@Repository
public interface TypesOfPostRepository extends JpaRepository<TypesOfPost,Integer> {


    Optional<TypesOfPost> getReferenceByReceiverIdentification(Receiver receiver);
}
