import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

// Create a RestTemplate
RestTemplate restTemplate = new RestTemplate();

// Define the URL for the Druid indexing service
String druidIndexingServiceUrl = "http://druid-indexing-service:8090/druid/overlord/index";

// Prepare the headers
HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_JSON);

// Prepare the JSON record (replace with your actual JSON data)
String jsonRecord = "{ \"field1\": \"value1\", \"field2\": 42 }";

// Create an HttpEntity with headers and the JSON record
HttpEntity<String> entity = new HttpEntity<>(jsonRecord, headers);

// Send a POST request to the Druid indexing service
ResponseEntity<String> response = restTemplate.exchange(druidIndexingServiceUrl, HttpMethod.POST, entity, String.class);

// Check the response for success or error handling
if (response.getStatusCode().is2xxSuccessful()) {
    // Data ingestion was successful
} else {
    // Handle errors
}
