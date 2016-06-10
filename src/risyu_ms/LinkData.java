package risyu_ms;

import java.net.URL;
import java.util.Date;

import javax.jdo.annotations.*;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class LinkData {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;

	@Persistent
	private String className;

	@Persistent
	private String teacher;

	@Persistent
	private String explanation;

	@Persistent
	private Date datetime;

	public LinkData(String className, String teacher, String explanation, Date datetime) {
		super();
		this.className = className;
		this.teacher = teacher;
		this.explanation = explanation;
		this.datetime = datetime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getclassName() {
		return className;
	}

	public void setclassName(String className) {
		this.className = className;
	}

	public String getteacher() {
		return teacher;
	}

	public void setteacher(String teacher) {
		this.teacher = teacher;
	}

	public String getexplanation() {
		return explanation;
	}

	public void setexplanation(String explanation) {
		this.explanation = explanation;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
}


