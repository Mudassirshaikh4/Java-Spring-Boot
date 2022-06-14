package com.boot.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Steelcontroll {
	@Autowired
	private Steelguidline steelguidline;

	@GetMapping("/steels")
	public ResponseEntity<List<Steel>> getSteels() {
		List<Steel> list = steelguidline.getAllsteels();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	@GetMapping("/steels/{id}")
	public ResponseEntity<Steel> getSteel(@PathVariable("id") int id) {
		
		Steel steel = steelguidline.getSteelById(id);
		try {
		if (steel == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		}
	
		catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.of(Optional.of(steel));
	}

	@PostMapping("/steels")
	public ResponseEntity<Steel> addSteel(@RequestBody Steel steel) {
		Steel u = null;
		try {
			u = this.steelguidline.addSteel(steel);
			System.out.println(steel);
			return ResponseEntity.of(Optional.of(u));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/steels/{steelid}")
	public ResponseEntity<Object> deleteSteel(@PathVariable("steelid") int steelid) {
		try {
			this.steelguidline.deleteSteel(steelid);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/steels/{steelid}")
	public ResponseEntity<Steel> UpdateSteel(@RequestBody Steel steel, @PathVariable("steelid") int steelid) {
		try {
			this.steelguidline.UpdateSteel(steel, steelid);
			return ResponseEntity.ok().body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
}
