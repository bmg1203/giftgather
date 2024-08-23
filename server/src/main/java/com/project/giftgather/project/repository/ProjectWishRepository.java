package com.project.giftgather.project.repository;

import com.project.giftgather.project.domain.Project;
import com.project.giftgather.project.domain.ProjectWish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectWishRepository extends JpaRepository<ProjectWish, String> {
}
