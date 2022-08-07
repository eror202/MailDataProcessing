package ru.smirnov.MailDataProcessingApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.smirnov.MailDataProcessingApp.models.PostPath;

@Repository
public interface PostPathRepository extends JpaRepository<PostPath,Integer> {
}
