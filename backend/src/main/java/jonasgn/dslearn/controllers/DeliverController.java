package jonasgn.dslearn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jonasgn.dslearn.dto.DeliverRevisionDTO;
import jonasgn.dslearn.services.DeliverService;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverController {

	@Autowired
	private DeliverService service;

	@PutMapping(value = "/{deliverId}")
	public ResponseEntity<Void> reviseDeliver(@PathVariable Long deliverId, @RequestBody DeliverRevisionDTO revision) {
		service.saveRevision(deliverId, revision);

		return ResponseEntity.noContent().build();
	}

}
