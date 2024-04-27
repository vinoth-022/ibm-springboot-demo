package com.ibm.springboot.demo;
import java.time.Duration;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTimeout;


import java.util.concurrent.TimeUnit;

import org.apache.juli.logging.Log;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ibm.springboot.demo.service.EmployeeService;

@SpringBootTest
class AppTests {

	@Autowired
	private EmployeeService employeeService;

	private static final Logger LOG = LoggerFactory.getLogger(AppTests.class);

	@BeforeAll
	public static void setUp() {
		LOG.info("before all");
	}

	@AfterAll
	public static void tearDown() {
		LOG.info("after all");
	}

//	@BeforeEach

//	@AfterEach

//	@Test
//	public void testAddEmp() {
//		Employee emp = new Employee("asdf", "Test Data", "test@data.com", 888888888888L, 90.9);
//		assertEquals(employeeService.addEmployee(emp), emp);
//	}

	@Test
	public void testAllEmps() {
		assertEquals(employeeService.getAllEmployees().size(), 15);
	}

	@ParameterizedTest
	@ValueSource(strings = { "Siddharth", "Yuvraj" })
	void testGetEmpsById(String employeeId) {
		assertEquals(employeeId, employeeService.getEmployeeByFirstName(employeeId).get(0).getFirstName());
	}

	@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
	@Test
	public void testAllEmpsTimeout() {
		assertTimeout(Duration.ofMillis(100), () -> {
			employeeService.getAllEmployees();
		});

	}

}
