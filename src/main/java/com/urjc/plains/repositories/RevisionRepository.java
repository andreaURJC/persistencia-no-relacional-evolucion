package com.urjc.plains.repositories;

import com.urjc.plains.models.Revision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionRepository extends JpaRepository<Revision, Long> {
}
