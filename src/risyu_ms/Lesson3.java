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
public class Lesson3 {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String className;
	@Persistent
	private String teacher;
	
	@Persistent
	private String explanation;

	public Lesson3(String className, String teacher,String explanation) {
		super();
		this.className = className;
		this.teacher = teacher;
	
		this.explanation = explanation;
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
	
	public String getTeacher() {
		if (teacher == null) {
			teacher = " ";
		}
		return teacher;
	}
	
	public void setTeacher(String teacher){
		this.teacher = teacher;
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
	

}

