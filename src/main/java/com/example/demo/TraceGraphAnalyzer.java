package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.AllDirectedPaths;
import org.jgrapht.alg.shortestpath.EppsteinShortestPathIterator;
import org.jgrapht.alg.shortestpath.YenShortestPathIterator;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TraceGraphAnalyzer {

	private static Logger LOGGER = LoggerFactory.getLogger(TraceGraphAnalyzer.class);
	private final SimpleDirectedWeightedGraph<String, DefaultEdge> graph = new SimpleDirectedWeightedGraph<>(
			DefaultEdge.class);

	public Optional<Integer> question1() {
		String questionNumber = "question 1: ";
		LOGGER.info("");

		if (graph.containsEdge("A", "B") && graph.containsEdge("B", "C")) {
			DefaultEdge edge1 = graph.getEdge("A", "B");
			double weight1 = graph.getEdgeWeight(edge1);

			DefaultEdge edge2 = graph.getEdge("B", "C");
			double weight2 = graph.getEdgeWeight(edge2);

			LOGGER.info("{} {}", questionNumber, weight1 + weight2);
			return Optional.of((int) (weight1 + weight2));
		} else {
			LOGGER.info("{} NO SUCH TRACE", questionNumber);
			return Optional.empty();
		}
	}

	public Optional<Integer> question2() {
		String questionNumber = "question 2: ";
		LOGGER.info("");

		if (graph.containsEdge("A", "D")) {
			DefaultEdge edge1 = graph.getEdge("A", "D");
			double weight1 = graph.getEdgeWeight(edge1);

			LOGGER.info("{} {}", questionNumber, weight1);
			return Optional.of((int) (weight1));
		} else {
			LOGGER.info("{} NO SUCH TRACE", questionNumber);
			return Optional.empty();
		}
	}

	public Optional<Integer> question3() {
		String questionNumber = "question 3: ";
		LOGGER.info("");
		if (graph.containsEdge("A", "D") && graph.containsEdge("D", "C")) {
			DefaultEdge edge1 = graph.getEdge("A", "D");
			double weight1 = graph.getEdgeWeight(edge1);

			DefaultEdge edge2 = graph.getEdge("D", "C");
			double weight2 = graph.getEdgeWeight(edge2);

			LOGGER.info("{} {}", questionNumber, weight1 + weight2);
			return Optional.of((int) (weight1 + weight2));
		} else {
			LOGGER.info("{} NO SUCH TRACE", questionNumber);
			return Optional.empty();
		}
	}

	public Optional<Integer> question4() {
		String questionNumber = "question 4: ";
		LOGGER.info("");

		if (graph.containsEdge("A", "E") && graph.containsEdge("E", "B") && graph.containsEdge("B", "C")
				&& graph.containsEdge("C", "D")) {
			DefaultEdge edge1 = graph.getEdge("A", "E");
			double weight1 = graph.getEdgeWeight(edge1);

			DefaultEdge edge2 = graph.getEdge("E", "B");
			double weight2 = graph.getEdgeWeight(edge2);

			DefaultEdge edge3 = graph.getEdge("B", "C");
			double weight3 = graph.getEdgeWeight(edge3);

			DefaultEdge edge4 = graph.getEdge("C", "D");
			double weight4 = graph.getEdgeWeight(edge4);

			LOGGER.info("{} {}", questionNumber, weight1 + weight2 + weight3 + weight4);
			return Optional.of((int) (weight1 + weight2 + weight3 + weight4));
		} else {
			LOGGER.info("{} NO SUCH TRACE", questionNumber);
			return Optional.empty();
		}
	}

	public Optional<Integer> question5() {
		String questionNumber = "question 5: ";
		LOGGER.info("");

		if (graph.containsEdge("A", "E") && graph.containsEdge("E", "D")) {
			DefaultEdge edge1 = graph.getEdge("A", "E");
			double weight1 = graph.getEdgeWeight(edge1);

			DefaultEdge edge2 = graph.getEdge("E", "D");
			double weight2 = graph.getEdgeWeight(edge2);

			LOGGER.info("{} {}", questionNumber, weight1 + weight2);
			return Optional.of((int) (weight1 + weight2));
		} else {
			LOGGER.info("{} NO SUCH TRACE", questionNumber);
			return Optional.empty();
		}
	}

	public Optional<Integer> question6() {
		String questionNumber = "question 6: ";
		LOGGER.info("");

		AllDirectedPaths<String, DefaultEdge> paths = new AllDirectedPaths<>(graph);
		List<GraphPath<String, DefaultEdge>> matchingPaths = paths.getAllPaths("C", "C", false, 3);
		for (GraphPath<String, DefaultEdge> matchingPath : matchingPaths) {
			if (matchingPath.getVertexList().size() > 1) {
				LOGGER.info("{} matching path {}", questionNumber, matchingPath.getVertexList());
			}
		}
		int numberOfMatchingPaths = (int) matchingPaths.stream().filter(p -> p.getVertexList().size() > 1).count();
		LOGGER.info("{} number of matching paths {}", questionNumber, numberOfMatchingPaths);

		return Optional.of(numberOfMatchingPaths);
	}

	public Optional<Integer> question7() {
		String questionNumber = "question 7: ";
		LOGGER.info("");

		AllDirectedPaths<String, DefaultEdge> paths = new AllDirectedPaths<>(graph);
		List<GraphPath<String, DefaultEdge>> matchingPaths = paths.getAllPaths("A", "C", false, 4);
		for (GraphPath<String, DefaultEdge> matchingPath : matchingPaths) {
			if (matchingPath.getVertexList().size() == 5) {
				LOGGER.info("{} matching path {}", questionNumber, matchingPath.getVertexList());
			}
		}
		int numberOfMatchingPaths = (int) matchingPaths.stream().filter(p -> p.getVertexList().size() == 5).count();
		LOGGER.info("{} number of matching paths {}", questionNumber, numberOfMatchingPaths);
		return Optional.of(numberOfMatchingPaths);
	}

	public Optional<Integer> question8() {
		String questionNumber = "question 8: ";
		LOGGER.info("");

		YenShortestPathIterator<String, DefaultEdge> paths = new YenShortestPathIterator<>(graph, "A", "C");
		while (paths.hasNext()) {
			GraphPath<String, DefaultEdge> path = paths.next();
			LOGGER.info("{} path {}, weight {}", questionNumber, path.getVertexList(), path.getWeight());
		}

		paths = new YenShortestPathIterator<>(graph, "A", "C");
		if (paths.hasNext()) {
			GraphPath<String, DefaultEdge> path = paths.next();
			LOGGER.info("{} shortest path {}, weight {}", questionNumber, path.getVertexList(), path.getWeight());
			return Optional.of((int) path.getWeight());
		} else {
			return Optional.empty();
		}
	}

	public Optional<Integer> question9() {
		String questionNumber = "question 9: ";
		LOGGER.info("");

		EppsteinShortestPathIterator<String, DefaultEdge> paths = new EppsteinShortestPathIterator<>(graph, "B", "B");
		Optional<GraphPath<String, DefaultEdge>> shortestPath = Optional.empty();
		int i = 0;
		LOGGER.info("Printing the shortest 3 paths");
		while (paths.hasNext() && i < 4) {
			i++;
			GraphPath<String, DefaultEdge> path = paths.next();
			if (path.getVertexList().size() > 1) {
				if (shortestPath.isEmpty()) {
					shortestPath = Optional.of(path);
				}
				LOGGER.info("{} path {}, weight {}", questionNumber, path.getVertexList(), path.getWeight());
			}
		}

		if (shortestPath.isPresent()) {
			LOGGER.info("{} shortest path {}, weight {}", questionNumber, shortestPath.get().getVertexList(),
					shortestPath.get().getWeight());
		}
		return shortestPath.map(p -> Optional.of((int) (p.getWeight()))).orElse(Optional.empty());
	}

	public Optional<Integer> question10() {
		String questionNumber = "question 10: ";
		LOGGER.info("");

		EppsteinShortestPathIterator<String, DefaultEdge> paths = new EppsteinShortestPathIterator<>(graph, "C", "C");
		boolean reachedPathEqualToOrGreaterThan30 = false;
		int numberOfPathsWithWeightLessThan30 = 0;

		LOGGER.info("Printing paths with average weight less than 30");
		while (paths.hasNext() && !reachedPathEqualToOrGreaterThan30) {
			GraphPath<String, DefaultEdge> path = paths.next();
			if (path.getVertexList().size() > 1) {
				if (path.getWeight() < 30.0) {
					numberOfPathsWithWeightLessThan30++;
					LOGGER.info("{} path {}, weight {}", questionNumber, path.getVertexList(), path.getWeight());
				} else {
					reachedPathEqualToOrGreaterThan30 = true;
				}
			}
		}

		LOGGER.info("{} Number of paths with weight less than 30 : {}", questionNumber,
				numberOfPathsWithWeightLessThan30);

		return Optional.of(numberOfPathsWithWeightLessThan30);
	}

	public void addEdge(String sourceVertex, String destinationVertex, double weight) {
		if (!graph.containsVertex(sourceVertex)) {
			graph.addVertex(sourceVertex);
		}
		if (!graph.containsVertex(destinationVertex)) {
			graph.addVertex(destinationVertex);
		}
		DefaultEdge e = graph.addEdge(sourceVertex, destinationVertex);
		if (e == null) {
			throw new IllegalArgumentException(
					"Edge from " + sourceVertex + " to " + destinationVertex + " already exists");
		}
		graph.setEdgeWeight(e, weight);
		LOGGER.info("Added edge {}-{} with weight {}", sourceVertex, destinationVertex, weight);
	}
}
