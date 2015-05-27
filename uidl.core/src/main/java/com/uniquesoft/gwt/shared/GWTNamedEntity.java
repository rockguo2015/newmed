package com.uniquesoft.gwt.shared;

/**
 * This class extends from the GWTEntity, except the id information, it records
 * the name and class information about the UI component.
 * 
 */
public class GWTNamedEntity extends GWTEntity implements
		Comparable<GWTNamedEntity> {

	private String name;
	public static final String P_NAME = "name";

	/**
	 * create an empty class
	 */
	protected GWTNamedEntity() {
	}

//	/**
//	 * Create a class, and initialize the id.
//	 * 
//	 * @param id
//	 */
//	public GWTNamedEntity(Long id) {
//		super(id,null);
//	}

	/**
	 * Create a class, and initialize the id and name.
	 * 
	 * @param id
	 * @param name
	 */
	private GWTNamedEntity(Long id, String name) {
		super(id,name);
		this.name = name;
	}

	/**
	 * Create a class, and initialize the id, name and class information.
	 * 
	 * @param id
	 * @param name
	 * @param clazz
	 */
	public GWTNamedEntity(Long id, String name, String clazz) {
		this(id, name);
		this.setClazzName(clazz);
	}

	/**
	 * @return get the component value
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the component name.
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(GWTNamedEntity other) {
		if (this.getName() == null)
			return -1;
		if (other == null || other.getName() == null)
			return 1;
		return this.getName().compareTo(other.getName());
	}

	@Override
	public String toString() {
		return name==null?"<NONAME>":name;
	}
}
