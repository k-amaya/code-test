package com.kamaya.code_test.rs;

import com.kamaya.code_test.rs.dto.request.AnimationRequest;
import com.kamaya.code_test.rs.dto.request.MissingLettersRequest;
import com.kamaya.code_test.rs.dto.response.AnimationResponse;
import com.kamaya.code_test.rs.dto.response.MissingLettersResponse;
import com.kamaya.code_test.service.animation.AnimationService;
import com.kamaya.code_test.service.missing_letters.MissingLettersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/code-test")
public class CodeTestController {

	private final AnimationService animationService;
	private final MissingLettersService missingLettersService;

	@Autowired
	public CodeTestController(AnimationService animationService, MissingLettersService missingLettersService){
		this.animationService = animationService;
		this.missingLettersService = missingLettersService;
	}

	@GetMapping(value = "/animation")
	public ResponseEntity<AnimationResponse> getAnimation(@RequestBody AnimationRequest animationRequest){
		AnimationResponse animationResponse = new AnimationResponse();
		animationResponse.setParticlesPositions(animationService.animate(animationRequest.getSpeed(), animationRequest.getParticlesPositions()));
		return new ResponseEntity<>(animationResponse, HttpStatus.OK);
	}

	@GetMapping(value = "/missing-letters")
	public ResponseEntity<MissingLettersResponse> getMissingLetters(@RequestBody MissingLettersRequest missingLettersRequest){
		MissingLettersResponse missingLettersResponse = new MissingLettersResponse();
		missingLettersResponse.setMissingLetters(missingLettersService.getMissingLetters(missingLettersRequest.getPhrase()));
		return new ResponseEntity<>(missingLettersResponse, HttpStatus.OK);
	}

}
