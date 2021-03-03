package guru.springframework.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class ClassMo {

	@Id
	@GeneratedValue
	private Long id;
	private String companyId;
	private String companyName;
	private String reportLogo;
	private String reportLogopath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getReportLogo() {
		return reportLogo;
	}
	public void setReportLogo(String reportLogo) {
		this.reportLogo = reportLogo;
	}
	public String getReportLogopath() {
		return reportLogopath;
	}
	public void setReportLogopath(String reportLogopath) {
		this.reportLogopath = reportLogopath;
	}



}