package ru.dankovtsev.smartcity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.dankovtsev.smartcity.model.Server;

@Repository
public interface ServerRepository extends JpaRepository<Server,Long> {
}
