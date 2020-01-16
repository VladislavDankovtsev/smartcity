package ru.dankovtsev.smartcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dankovtsev.smartcity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
