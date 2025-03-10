package kks.lend36back.persistence.student_preference;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentPreferenceRepository extends JpaRepository<StudentPreference, Integer> {
  }