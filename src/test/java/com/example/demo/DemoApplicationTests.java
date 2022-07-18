package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DemoApplicationTests {

	private TraceGraphAnalyzer analyzer;

	@BeforeEach
	public void setup() {
		analyzer = new TraceGraphAnalyzer();
		analyzer.addEdge("A", "B", 5.0);
		analyzer.addEdge("B", "C", 4.0);
		analyzer.addEdge("C", "D", 8.0);
		analyzer.addEdge("D", "C", 8.0);
		analyzer.addEdge("D", "E", 6.0);
		analyzer.addEdge("A", "D", 5.0);
		analyzer.addEdge("C", "E", 2.0);
		analyzer.addEdge("E", "B", 3.0);
		analyzer.addEdge("A", "E", 7.0);
	}

	@Test
	public void testQuestion1() {
		Optional<Integer> answer = analyzer.question1();
		assertTrue(answer.isPresent());
		assertEquals(9, answer.get());
	}

	@Test
	public void testQuestion2() {
		Optional<Integer> answer = analyzer.question2();
		assertTrue(answer.isPresent());
		assertEquals(5, answer.get());
	}

	@Test
	public void testQuestion3() {
		Optional<Integer> answer = analyzer.question3();
		assertTrue(answer.isPresent());
		assertEquals(13, answer.get());
	}

	@Test
	public void testQuestion4() {
		Optional<Integer> answer = analyzer.question4();
		assertTrue(answer.isPresent());
		assertEquals(22, answer.get());
	}

	@Test
	public void testQuestion5() {
		Optional<Integer> answer = analyzer.question5();
		assertTrue(answer.isEmpty());
	}

	@Test
	public void testQuestion6() {
		Optional<Integer> answer = analyzer.question6();
		assertTrue(answer.isPresent());
		assertEquals(2, answer.get());
	}

	@Test
	public void testQuestion7() {
		Optional<Integer> answer = analyzer.question7();
		assertTrue(answer.isPresent());
		assertEquals(3, answer.get());
	}

	@Test
	public void testQuestion8() {
		Optional<Integer> answer = analyzer.question8();
		assertTrue(answer.isPresent());
		assertEquals(9, answer.get());
	}

	@Test
	public void testQuestion9() {
		Optional<Integer> answer = analyzer.question9();
		assertTrue(answer.isPresent());
		assertEquals(9, answer.get());
	}

	@Test
	public void testQuestion10() {
		Optional<Integer> answer = analyzer.question10();
		assertTrue(answer.isPresent());
		assertEquals(7, answer.get());
	}

}
