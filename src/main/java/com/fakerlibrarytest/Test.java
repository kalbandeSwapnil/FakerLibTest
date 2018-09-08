package com.fakerlibrarytest;

import java.io.FileWriter;
import java.io.IOException;
import com.github.javafaker.*;

/**
 * Hello world!
 *
 */
public class App {

	private static final String FILE_HEADER = "id,FirstName,LastName,Address,PhoneNumber";
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";

	public static void main(String[] args) {
		FileWriter fileWriter = null;
		System.out.println("Hello World!");
		Faker faker = new Faker();
		try {
			fileWriter = new FileWriter("C:\\Learning_2018\\sampleCSV.csv");
			fileWriter.append(FILE_HEADER);
			System.out.println(FILE_HEADER);
			fileWriter.append(NEW_LINE_SEPARATOR);
			String record;
			
			for (int i = 1; i <= 10; i++) {
				
				record = i + COMMA_DELIMITER + faker.firstName() + COMMA_DELIMITER + faker.lastName() + COMMA_DELIMITER
						+ faker.streetAddress(true) + COMMA_DELIMITER + faker.phoneNumber();
				System.out.println(record);
				fileWriter.append(record);
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
