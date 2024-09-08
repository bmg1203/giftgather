package com.project.giftgather.project.controller.api;

import com.project.giftgather.project.dto.ProjectRewardDTO;
import com.project.giftgather.project.service.ProjectRewardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/project/rewards")
@RequiredArgsConstructor
@Tag(name = "ProjectReward", description = "프로젝트 리워드 관련 API")
public class ProjectRewardRestController {

    private final ProjectRewardService projectRewardService;

    // 리워드 생성
    @PostMapping
    @Operation(summary = "Create Project Reward", description = "프로젝트 리워드 생성")
    public ResponseEntity<ProjectRewardDTO> createReward(@PathVariable String projectId, @RequestBody ProjectRewardDTO rewardDTO) {
        ProjectRewardDTO createdReward = projectRewardService.createReward(projectId, rewardDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdReward);
    }

    // 생성한 리워드 수정
    @PostMapping("/update/{rewardId}")
    @Operation(summary = "Update Project Reward", description = "프로젝트 리워드 수정")
    public ResponseEntity<String> updateReward(@PathVariable String rewardId, @RequestBody ProjectRewardDTO rewardDTO) {
        projectRewardService.updateReward(rewardId, rewardDTO);
        return ResponseEntity.ok("리워드가 성공적으로 수정되었습니다.");
    }

    // 특정 리워드 조회
    @GetMapping("/{rewardId}")
    @Operation(summary = "View Project Reward", description = "특정 리워드 조회")
    public ResponseEntity<ProjectRewardDTO> getReward(@PathVariable String rewardId) {
        ProjectRewardDTO rewardDTO = projectRewardService.getReward(rewardId);
        return ResponseEntity.ok(rewardDTO);
    }

    // 프로젝트에 속한 모든 리워드 조회
    @GetMapping("/project/{projectId}")
    @Operation(summary = "Specific Project's All Reward View", description = "특정 프로젝트의 모든 리워드 조회")
    public ResponseEntity<List<ProjectRewardDTO>> getRewardsByProject(@PathVariable String projectId) {
        List<ProjectRewardDTO> rewardDTOs = projectRewardService.getRewardsByProject(projectId);
        return ResponseEntity.ok(rewardDTOs);
    }
}
