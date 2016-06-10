package risyu_ms;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 *
 * @author g14911ih
 */
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class TimeTable {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String className;
	@Persistent
	private String student;
	/*
	@Persistent
	private String teacher;
	@Persistent
	private String term;
	@Persistent
	private String week;
	@Persistent
	private String explanation;
	@Persistent
	private int period;
    @Persistent
    private int credit;
*/
	public TimeTable(String className, String teacher, String term, String week, int period, int credit,
			String explanation) {
		super();
		this.className = className;
		this.student = student;
		/*
		this.teacher = teacher;
		this.term = term;
		this.week = week;
		this.period = period;
		this.explanation = explanation;
		this.credit = credit;*/
	}
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id=id;
	}

	public String getClassName() {
		if (className == null) {
			className = " ";
		}
		return className;
	}
	
	public void setClassName(String className){
		this.className = className;
	}
	
	public String getStudent(){
		return student;
	}
	public void setStudent(String student){
		this.student=student;
	}
	/*
	public String getTeacher() {
		if (teacher == null) {
			teacher = " ";
		}
		return teacher;
	}
	
	public void setTeacher(String teacher){
		this.teacher = teacher;
	}

	public String getWeek() {
		if (week == null) {
			week = " ";
		}
		return week;
	}
	
	public void setWeek(String week){
		this.week = week;
	}

	public int getPeriod() {
		return period;
	}
	
	public void setPeriod(int period){
		this.period = period;
	}

	public String getTerm() {
		if (term == null) {
			term = " ";
		}
		return term;
	}
	
	public void setTerm(String term){
		this.term = term;
	}

	public String getExplanation() {
		if (explanation == null) {
			explanation = " ";
		}
		return explanation;
	}

	public void setExplanation(String explanation){
		this.explanation = explanation;
	}
	
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit){
		this.credit = credit;
	}*/
}

