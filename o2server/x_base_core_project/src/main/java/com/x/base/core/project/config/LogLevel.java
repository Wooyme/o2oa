package com.x.base.core.project.config;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import com.x.base.core.project.annotation.FieldDescribe;
import com.x.base.core.project.logger.Logger;

public class LogLevel extends ConfigObject {

	@FieldDescribe("是否启用调试")
	private String x_program_center = "";

	@FieldDescribe("是否启用调试")
	private String x_processplatform_service_processing = "";

	@FieldDescribe("是否启用调试")
	private String x_processplatform_assemble_surface = "";

	@FieldDescribe("是否启用调试")
	private String x_processplatform_assemble_designer = "";

	@FieldDescribe("是否启用调试")
	private String x_query_assemble_designer = "";

	@FieldDescribe("是否启用调试")
	private String x_query_assemble_surface = "";

	@FieldDescribe("是否启用调试")
	private String x_query_service_processing = "";

	@FieldDescribe("是否启用调试")
	private String x_meeting_assemble_control = "";

	@FieldDescribe("是否启用调试")
	private String x_organization_assemble_authentication = "";

	@FieldDescribe("是否启用调试")
	private String x_organization_assemble_control = "";

	@FieldDescribe("是否启用调试")
	private String x_general_assemble_control = "";

	@FieldDescribe("是否启用调试")
	private String x_file_assemble_control = "";

	@FieldDescribe("是否启用调试")
	private String x_attendance_assemble_control = "";

	@FieldDescribe("是否启用调试")
	private String x_collaboration_core_message = "";

	@FieldDescribe("是否启用调试")
	private String x_organization_core_express = "";

	@FieldDescribe("是否启用调试")
	private String x_query_core_express = "";

	@FieldDescribe("是否启用调试")
	private String x_bbs_assemble_control = "";

	@FieldDescribe("是否启用调试")
	private String x_calendar_assemble_control = "";

	@FieldDescribe("是否启用调试")
	private String x_cms_assemble_control = "";

	@FieldDescribe("是否启用调试")
	private String x_component_assemble_control = "";

	@FieldDescribe("是否启用调试")
	private String x_hotpic_assemble_control = "";

	@FieldDescribe("是否启用调试")
	private String x_message_assemble_communicate = "";

	@FieldDescribe("是否启用调试")
	private String x_mind_assemble_control = "";

	@FieldDescribe("是否启用调试")
	private String x_okr_assemble_control = "";

	@FieldDescribe("是否启用调试")
	private String x_organization_assemble_express = "";

	@FieldDescribe("是否启用调试")
	private String x_organization_assemble_personal = "";

	@FieldDescribe("是否启用调试")
	private String x_portal_assemble_designer = "";

	@FieldDescribe("是否启用调试")
	private String x_portal_assemble_surface = "";

	@FieldDescribe("是否启用调试")
	private String x_processplatform_assemble_bam = "";

	@FieldDescribe("审计日志配置")
	private Audit audit = Audit.defaultInstance();

	public static LogLevel defaultInstance() {
		return new LogLevel();
	}

	public Audit audit() {
		return (null == this.audit) ? Audit.defaultInstance() : this.audit;
	}

	public String x_attendance_assemble_control() {
		return this.getLevel(this.x_attendance_assemble_control);
	}

	public String x_collaboration_core_message() {
		return this.getLevel(this.x_collaboration_core_message);
	}

	public String x_organization_core_express() {
		return this.getLevel(this.x_organization_core_express);
	}

	public String x_query_core_express() {
		return this.getLevel(this.x_query_core_express);
	}

	public String x_bbs_assemble_control() {
		return this.getLevel(this.x_bbs_assemble_control);
	}

	public String x_calendar_assemble_control() {
		return this.getLevel(this.x_calendar_assemble_control);
	}

	public String x_cms_assemble_control() {
		return this.getLevel(this.x_cms_assemble_control);
	}

	public String x_component_assemble_control() {
		return this.getLevel(this.x_component_assemble_control);
	}

	public String x_hotpic_assemble_control() {
		return this.getLevel(this.x_hotpic_assemble_control);
	}

	public String x_message_assemble_communicate() {
		return this.getLevel(this.x_message_assemble_communicate);
	}

	public String x_mind_assemble_control() {
		return this.getLevel(this.x_mind_assemble_control);
	}

	public String x_okr_assemble_control() {
		return this.getLevel(this.x_okr_assemble_control);
	}

	public String x_organization_assemble_express() {
		return this.getLevel(this.x_organization_assemble_express);
	}

	public String x_organization_assemble_personal() {
		return this.getLevel(this.x_organization_assemble_personal);
	}

	public String x_portal_assemble_designer() {
		return this.getLevel(this.x_portal_assemble_designer);
	}

	public String x_portal_assemble_surface() {
		return this.getLevel(this.x_portal_assemble_surface);
	}

	public String x_processplatform_assemble_bam() {
		return this.getLevel(this.x_processplatform_assemble_bam);
	}

	public String x_program_center() {
		return this.getLevel(this.x_program_center);
	}

	public String x_processplatform_service_processing() {
		return this.getLevel(this.x_processplatform_service_processing);
	}

	public String x_processplatform_assemble_surface() {
		return this.getLevel(this.x_processplatform_assemble_surface);
	}

	public String x_processplatform_assemble_designer() {
		return this.getLevel(this.x_processplatform_assemble_designer);
	}

	public String x_query_assemble_surface() {
		return this.getLevel(this.x_query_assemble_surface);
	}

	public String x_query_assemble_designer() {
		return this.getLevel(this.x_query_assemble_designer);
	}

	public String x_query_service_processing() {
		return this.getLevel(this.x_query_service_processing);
	}

	public String x_meeting_assemble_control() {
		return this.getLevel(this.x_meeting_assemble_control);
	}

	public String x_organization_assemble_authentication() {
		return this.getLevel(this.x_organization_assemble_authentication);
	}

	public String x_organization_assemble_control() {
		return this.getLevel(this.x_organization_assemble_control);
	}

	public String x_general_assemble_control() {
		return this.getLevel(this.x_general_assemble_control);
	}

	public String x_file_assemble_control() {
		return this.getLevel(this.x_general_assemble_control);
	}

	private String getLevel(String str) {
		if (StringUtils.equalsIgnoreCase(str, Logger.ERROR)) {
			return Logger.ERROR;
		}
		if (StringUtils.equalsIgnoreCase(str, Logger.WARN)) {
			return Logger.WARN;
		}
		if (StringUtils.equalsIgnoreCase(str, Logger.INFO)) {
			return Logger.INFO;
		}
		if (StringUtils.equalsIgnoreCase(str, Logger.DEBUG)) {
			return Logger.DEBUG;
		}
		if (StringUtils.equalsIgnoreCase(str, Logger.TRACE)) {
			return Logger.TRACE;
		}
		return Logger.INFO;
	}

	public static class Audit extends ConfigObject {

		public static final Integer DEFAULT_LOGSIZE = 31;
		public static final Boolean DEFAULT_ENABLE = false;

		public static Audit defaultInstance() {
			return new Audit();
		}

		@FieldDescribe("是否启用审计日志")
		private Boolean enable;

		@FieldDescribe("审计日志保留天数")
		private Integer logSize;

		@FieldDescribe("审计日志归属系统code")
		private String system;

		@FieldDescribe("审计日志归属系统名称")
		private String systemName;

		@FieldDescribe("审计日志归属省份")
		private String companycode;

		public Boolean enable() {
			return BooleanUtils.isTrue(this.enable);
		}

		public Integer logSize() {
			if ((null == logSize) || (logSize < 0)) {
				return DEFAULT_LOGSIZE;
			} else {
				return this.logSize;
			}
		}
		public String getSystem() { return system; }

		public void setSystem(String system) {
			this.system = system;
		}

		public String getSystemName() { return systemName; }

		public void setSystemName(String systemName) { this.systemName = systemName; }

		public String getCompanycode() { return companycode; }

		public void setCompanycode(String companycode) { this.companycode = companycode; }
	}
}