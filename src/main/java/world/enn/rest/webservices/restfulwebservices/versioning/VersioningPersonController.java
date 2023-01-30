package world.enn.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	// URI Versioning
	/* @GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson(){
		return new PersonV1 ("Eya Ngo Ndjip");
	}

	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson(){
		return new PersonV2 (new Name("Eya", "No Ndjip"));
	} */


	// Request Parameters Versioning
	/*@GetMapping(path = "/person", params = "version=1")
	public PersonV1 getFirstVersionOfPersonRequestParameter(){
		return new PersonV1 ("Eya Ngo Ndjip");
	}

	@GetMapping(path = "/person", params = "version=2")
	public PersonV1 getSecondVersionOfPersonRequestParameter(){
		return new PersonV1 ("Ngo Ndjip");
	}*/


	// Custom Header Versioning
	/*@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeader(){
		return new PersonV1 ("Eya Ngo Ndjip");
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeader(){
		return new PersonV2 (new Name("Eya", "No Ndjip"));
	}*/


	@GetMapping(path = "/person/accept", produces="application/vdn.company.app-v1+json")
	public PersonV1 getFirstVersionOfPersonMediaType(){
		return new PersonV1 (" Ngo Ndjip");
	}

	@GetMapping(path = "/person/accept", produces="application/vdn.company.app-v2+json")
	public PersonV2 getSecondVersionOfPersonMediaType(){
		return new PersonV2 (new Name("Eya", "Ngo Ndjip"));
	}




}
