package edu.fudan.mylang.pf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.beans.factory.BeanFactory;

import edu.fudan.mylang.pf.event.EntityEventsManager;

@MappedSuperclass
public abstract class BaseModelObject implements IModelObject,
		IContextAwareModelObject, Comparable<IModelObject> {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;
	
	/*@Version
	private Long version;
	
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long _id) {
		id = _id;
	}

	@Column(length = 16)
	private String modifier;

	/**
	 * get last modifier
	 * 
	 * @return last modifier
	 */
	public String getModifier() {
		return modifier;
	}

	/**
	 * set last modifier
	 * 
	 * @param modifier
	 *            last modifier.
	 */
	public void setModifier(String modifier) {
		if (!(new EqualsBuilder().append(this.modifier, modifier).isEquals())) {
			this.modifier = modifier;
			firePropertyChanged("modifier");
		}
	}

	@Basic
	Integer active = 1;

	public Boolean isActive() {
		return active == 1;
	}

	public void setIsActive(Boolean isActive) {
		active = (isActive ? 1 : 0);
	}

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	/**
	 * get last modified date
	 * 
	 * @return last modified date
	 */

	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * set last modified date
	 * 
	 * @param modifiedDate
	 *            last modified date.
	 */
	public void setModifiedDate(Date modifiedDate) {
		if (!(new EqualsBuilder().append(this.modifiedDate, modifiedDate)
				.isEquals())) {
			this.modifiedDate = modifiedDate;
			firePropertyChanged("modifiedDate");
		}
	}
	
	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@Column(length = 16)
	private String creator;
	
	@Version
    @Column(name="OPTLOCK")
	private Long version;
	
	public Long getVersion(){
		return version;
	}
	
	public void setVersion(Long version){
		this.version = version;
	}

	@Transient
	transient private Collection<IModelChangeListener> modelChangeListeners = new ArrayList<IModelChangeListener>();

	public void addModelChangeListener(IModelChangeListener listener) {
		modelChangeListeners.add(listener);
	}

	private void firePropertyChanged(String propertyName) {
		for (IModelChangeListener listener : modelChangeListeners) {
			listener.PropertyChanged(propertyName);
		}
	}

	public int compareTo(IModelObject o) {
		return this.getId().compareTo(o.getId());
	}

	public boolean equals(Object other) {
		if (other == null || other.getClass() != this.getClass())
			return false;
		EqualsBuilder eb = new EqualsBuilder();
		eb.append(this.getId(), ((IModelObject) other).getId());
		return eb.isEquals();
	}

	@Transient
	transient private IObjectFactory objectFactory;

	public IObjectFactory getObjectFactory() {
		return objectFactory;
	}

	@Transient
	transient private BeanFactory beanFactory;
	
	public void entityInitialized(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	
	public BeanFactory getBeanFactory(){
		return beanFactory;
	}
	
	public void preinitialize(){
	}

	public void setObjectFactory(IObjectFactory objectFactory) {
		this.objectFactory = objectFactory;
	}

	/**
	 * use HashCodeBuilder to calculate a hashcode
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getId()).toHashCode();
	}

	public String getObjectDescription() {
		return toString();
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	@Override
	public void checkValid() {
		
	}
	
	@Override
	public void delete() {
		objectFactory.delete(this);
	}
}
