package com.geekster.Recipe.Management.Repo;

import com.geekster.Recipe.Management.Model.Step;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepo extends JpaRepository<Step,Long> {

    Step findByStepId(Long stepId);
}
