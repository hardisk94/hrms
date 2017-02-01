package com.coviam.internalapp.hrms.generalutil.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.coviam.internalapp.hrms.leavemgmt.entity.LeaveHistory;
import com.coviam.internalapp.hrms.utils.ColumnUtils;

@Repository
public class GeneralUtilDAOImpl implements GeneralUtilDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<LeaveHistory> findAll() {
		String sql = "SELECT * FROM LEAVEHISTORY WHERE LEAVEHISTORY.LEAVE_STATUS = 'pending' AND  LEAVEHISTORY.EMPLOYEE_ID IN (SELECT EMPLOYEE.EMPLOYEE_ID FROM EMPLOEE WHERE EMPLOYEE.CUSTOMER_ID  = ? AND  EMPLOYEE.DEPT_ID IN (SELECT DEPARTMENT.DEPT_ID FROM DEPARTMENT JOIN LEAD ON DEPARTMENT_LEAD.LEAD_ID = LEAD.LEAD_ID JOIN ON DEPARTMENT ON DEPARTMENT_LEAD.DEPT_ID = DEPARTMENT.DEPT_ID WHERE LEAD.LEAD_ID = ?))";
		return this.jdbcTemplate.query(sql, new LeaveHistoryMapper());
	}
	
	
	public LeaveHistory find(int id) {
		return this.jdbcTemplate.queryForObject("select * from product where LEAVEHISTORY where leave_history_id = ?", new LeaveHistoryMapper(), id);
	}
	
	private static final class  LeaveHistoryMapper implements RowMapper<LeaveHistory>{

		@Override
		public LeaveHistory mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			LeaveHistory leaveHistory = new LeaveHistory();
			leaveHistory.setLeaveHistoryId(resultSet.getInt(ColumnUtils.LEAVEHISTORY_LEAVE_HISTORY_ID));
			leaveHistory.setCustomerId(resultSet.getString(ColumnUtils.LEAVEHISTORY_CUSTOMER_ID));
			leaveHistory.setEmployeeId(resultSet.getString(ColumnUtils.LEAVEHISTORY_EMPLOYEE_ID));
			leaveHistory.setFromDate(resultSet.getDate(ColumnUtils.LEAVEHISTORY_FROM_DATE));
			leaveHistory.setToDate(resultSet.getDate(ColumnUtils.LEAVEHISTORY_TO_DATE));
			leaveHistory.setLeaveType(resultSet.getString(ColumnUtils.LEAVEHISTORY_LEAVE_TYPE));
			leaveHistory.setLeaveReason(resultSet.getString(ColumnUtils.LEAVEHISTORY_LEAVE_REASON));
			
			return leaveHistory ;
		}
		
	}
	
	
}
