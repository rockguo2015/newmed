package com.fudanmed.platform.core.domain.impl;

import com.fudanmed.platform.core.domain.RCMaintenanceTeam;

public class RCGroupTaskStatCriteriaData {
	private RCMaintenanceTeam team;
	private Long cnt;

	public RCGroupTaskStatCriteriaData(RCMaintenanceTeam team, Long cnt) {
		super();
		this.team = team;
		this.cnt = cnt;
	}
}
