package jonasgn.dslearn.entities.pk;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import jonasgn.dslearn.entities.Offer;
import jonasgn.dslearn.entities.User;

@Embeddable
public class EnrollmentPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User student;

	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;

	public EnrollmentPK() {
	}

	public EnrollmentPK(User student, Offer offer) {
		this.student = student;
		this.offer = offer;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(offer, student);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnrollmentPK other = (EnrollmentPK) obj;
		return Objects.equals(offer, other.offer) && Objects.equals(student, other.student);
	}

}
