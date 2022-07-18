package com.example.demo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Value("classpath:graphdata.csv")
	Resource resourceFile;

	private static Logger LOGGER = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		TraceGraphAnalyzer analyzer = new TraceGraphAnalyzer();
		loadGraphData(analyzer);

		analyzer.question1();
		analyzer.question2();
		analyzer.question3();
		analyzer.question4();
		analyzer.question5();
		analyzer.question6();
		analyzer.question7();
		analyzer.question8();
		analyzer.question9();
		analyzer.question10();
	}

	public void loadGraphData(TraceGraphAnalyzer analyzer) throws IOException {
		List<String> graphDataLines = Files.readAllLines(resourceFile.getFile().toPath(), StandardCharsets.UTF_8);
		for (String graphDataLine : graphDataLines) {
			List<String> graphDataList = Arrays.asList(graphDataLine.split(","));
			for (String graphData : graphDataList) {
				LOGGER.info("graph data {}", graphData);
				if (!isGraphDataValid(graphData)) {
					throw new IllegalArgumentException(graphData + " does not match expected format [A-Z][A-Z][0-9]");
				} else {
					analyzer.addEdge(graphData.substring(0, 1), graphData.substring(1, 2),
							Double.parseDouble(graphData.substring(2, 3)));
				}
			}
		}
	}

	public boolean isGraphDataValid(final String input) {
		// Compile regular expression
		final Pattern pattern = Pattern.compile("[A-Z][A-Z]\\d");
		// Match regex against input
		final Matcher matcher = pattern.matcher(input);
		// Use results...
		return matcher.matches();
	}

}
