package com.saper.boxbackend.dto;

import com.saper.boxbackend.model.Team;

public class TeamResponseDTO {
    public Long team_id;

    public String schedule;

    public Long box_id;

    public TeamResponseDTO(Team team) {
        this.team_id = team.getId();
        this.schedule = team.getSchedule();
        this.box_id = team.getBox().getId();
    }
}
