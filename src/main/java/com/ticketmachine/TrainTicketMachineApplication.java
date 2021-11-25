package com.ticketmachine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.ticketmachine.helper.SuggestHelper;
import com.ticketmachine.helper.TrieNodeHelper;

@SpringBootApplication
public class TrainTicketMachineApplication implements CommandLineRunner {

	private static Logger LOG = LoggerFactory.getLogger(TrainTicketMachineApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TrainTicketMachineApplication.class, args);
	}

	@Autowired
	ResourceLoader resourceLoader;

	@Override
	public void run(String... args) {
		LOG.info("Testing autocomplete algorithm...");

		List<String> stationList = null;
		try {
			Resource resource = resourceLoader.getResource("stationsDataSet.txt");
			Path worldListPath = resource.getFile().toPath();
			stationList = Files.readAllLines(worldListPath);
		} catch (IOException e) {
			LOG.info("Cannot read lines from file...");
			e.printStackTrace();
		}
		// This method will suggest all stations that start with a certain prefix
		System.out.println(SuggestHelper.suggest("Al", TrieNodeHelper.getTrieNode(stationList)));
	}

}
