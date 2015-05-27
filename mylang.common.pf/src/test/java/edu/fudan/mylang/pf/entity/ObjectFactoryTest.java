package edu.fudan.mylang.pf.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

import edu.fudan.mylang.pf.IObjectFactory;
import edu.fudan.mylang.pf.test.BaseHsqlTest;

@ContextConfiguration(locations = { "classpath:ApplicationContext.xml" })
public class ObjectFactoryTest extends BaseHsqlTest {

	protected IObjectFactory of;

	@Before
	public void setUp() {
		of = (IObjectFactory) appContext.getBean("objectFactory");
	}

	@Test
	public void createEntityTest() {

		IPerson person = Person.createPerson("test", of);

		try {
			assertEquals(((Person) person).getObjectFactory(), of);
			assertEquals(1, of.all(Person.class).size());

			IPerson person1 = of.get(IPerson.class, person.getId());
			assertEquals(person, person1);

			IPerson person2 = of.get(Person.class, person.getId());
			assertEquals(person, person2);
		} finally {
			of.delete(person);
		}
	}

	@Test
	@Ignore
	public void loadEntityWithObjectFactoryInjectionTest() {
		IPerson person = Person.createPerson("test", of);
		try {
			// Load by get
			IPerson person1 = of.get(IPerson.class, person.getId());
			assertEquals(person, person1);
			assertEquals(of, ((Person) person1).getObjectFactory());

			// Load by all
			IPerson person2 = of.all(IPerson.class).iterator().next();
			assertEquals(person, person2);
			assertEquals(of, ((Person) person2).getObjectFactory());
		} finally {
			of.delete(person);
		}
	}

	@Test
	public void loginDeleteTest() {
		assertEquals(0, of.all(IPerson.class).size());

		IPerson person = Person.createPerson("test", of);
		of.logicDelete(person);

		// cann't found by normal query
		assertEquals(0, of.all(IPerson.class).size());

		// object still exist in storage
		assertEquals(person, of.get(IPerson.class, person.getId()));

		of.delete(person);

		assertNull(of.get(IPerson.class, person.getId()));
	}

}
