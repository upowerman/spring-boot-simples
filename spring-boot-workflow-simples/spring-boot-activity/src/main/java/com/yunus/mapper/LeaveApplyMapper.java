package com.yunus.mapper;

import com.yunus.po.LeaveApply;

public interface LeaveApplyMapper {

	void save(LeaveApply apply);

	LeaveApply getLeaveApply(int id);

	int updateByPrimaryKey(LeaveApply record);

}
