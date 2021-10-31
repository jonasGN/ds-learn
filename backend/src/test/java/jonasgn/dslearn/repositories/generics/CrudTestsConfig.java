package jonasgn.dslearn.repositories.generics;

public class CrudTestsConfig {

	private Long existingId;
	private Long nonExistingId;
	private Long dependentId;

	public CrudTestsConfig(Long existingId, Long nonExistingId, Long dependentId) {
		this.existingId = existingId;
		this.nonExistingId = nonExistingId;
		this.dependentId = dependentId;
	}

	public Long getExistingId() {
		return existingId;
	}

	public void setExistingId(Long existingId) {
		this.existingId = existingId;
	}

	public Long getNonExistingId() {
		return nonExistingId;
	}

	public void setNonExistingId(Long nonExistingId) {
		this.nonExistingId = nonExistingId;
	}

	public Long getDependentId() {
		return dependentId;
	}

	public void setDependentId(Long dependentId) {
		this.dependentId = dependentId;
	}

	public static CrudTestsConfig createDefault() {
		return new CrudTestsConfig(1L, 1000L, 3L);
	}

}
