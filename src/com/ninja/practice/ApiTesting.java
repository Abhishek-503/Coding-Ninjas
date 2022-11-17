package com.ninja.practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


//class Result {
//
//	/*
//	 * Complete the 'getCapitalCity' function below.
//	 *
//	 * The function is expected to return a STRING.
//	 * The function accepts STRING country as parameter.
//	 * API URL: https://jsonmock.hackerrank.com/api/countries?name=<country>
//	 */
//
//	@GetMapping("/{name}")
//	public static String getCapitalCity(@PathVariable(value = "name") String country) {
//		URL url = new URL("https://api.nasa.gov/planetary/apod?api_key="+country);
//
//		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//
//		connection.setRequestProperty("accept", "application/json");
//
//		InputStream responseStream = connection.getInputStream();
//
//		ObjectMapper mapper = new ObjectMapper();
//		APOD apod = mapper.readValue(responseStream, APOD.class);
//
//		return apod.capital;
//
//	}
//	public class ApiTesting {
//		public static void main(String[] args) throws IOException {
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//			String country = bufferedReader.readLine();
//
//			String result = Result.getCapitalCity(country);
//
//			bufferedWriter.write(String.valueOf(result));
//			bufferedWriter.newLine();
//
//			bufferedReader.close();
//			bufferedWriter.close();
//		}
//	}

	//SELECT S.ID, E.SUBJECT, count(*) as NUMBER_OF_TIMES from STUDENT S INNER JOIN EXAMINATION E on S.ID = E.STUDENT_ID
	//GROUP BY E.SUBJECT,S.ID;
