package ru.smirnov.MailDataProcessingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smirnov.MailDataProcessingApp.models.TypesOfPost;

@Repository
public interface TypesOfPostRepository extends JpaRepository<TypesOfPost,Integer> {
}
