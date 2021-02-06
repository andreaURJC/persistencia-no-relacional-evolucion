package com.urjc.plains.repository;

import com.urjc.plains.models.Revision;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RevisionRepository extends JpaRepository<Revision, Long> {
}
