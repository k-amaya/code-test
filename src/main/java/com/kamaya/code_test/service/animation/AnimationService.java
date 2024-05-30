package com.kamaya.code_test.service.animation;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimationService {

	public List<String> animate(int speed, String particlesInit){
		//List of the particles change positions, represented as a string
		List<String> response = new ArrayList<>();

		//Generates a list with the start information of each particle, the list contains a particle object with the
		// information of position and direction
		List<Particle> particles = new ArrayList<>();
		for(int index = 0 ; index<particlesInit.length() ; index++){
			particles.add(new Particle(index, particlesInit.charAt(index)));
		}

		//Generates the representation of particles start positions and add to the response list as the first position of particles
		String firstLine = createFirstLine(particles);
		response.add(firstLine);

		//Generates the representation of particles end positions
		String lastLine = createLastLine(particlesInit);

		//If there is no particles moving (firstLine equals lastLine), return the list with only the first line inside
		if(firstLine.equals(lastLine) || particlesInit.isBlank()){
			return response;
		}

		//String which represents the positions of the particles on every step, it will be restarted(new empty string) on every step
		String nextPositions = "";

		//Loop that process each step of the particles' movement, it finishes when nextPositions(positions of the particles at the step) of the particles is equal
		// to lastLine variable (representation of how the last line is supposed to be)
		while(!nextPositions.equals(lastLine)) {
			//Calculates the new positions of the particles using the speed
			particles.forEach(p -> changePosition(speed, p));
			//Generate the string representation of the positions of the particles
			nextPositions = createPositionsLine(particles);
			response.add(nextPositions);
		}

		return response;
	}

	private void changePosition(int speed, Particle particle){
		//Calculates the new position of a particles using the direction and the speed, the new position is
		// assigned over the actual position of the object Particle

		if(particle.getDirection() == 'R'){
			particle.setPosition(particle.getPosition() + speed);
		}

		if(particle.getDirection() == 'L'){
			particle.setPosition(particle.getPosition() - speed);
		}
	}

	private String createFirstLine(List<Particle> particles){
		String response = "";

		for(Particle particle: particles){

			if(particle.getDirection() == 'R' || particle.getDirection() == 'L'){
				response = response.concat("X");
			}

			if(particle.getDirection() == '.'){
				response = response.concat(".");
			}
		}

		return response;
	}

	private String createLastLine(String particles){
		String response = "";

		for(int index = 0 ; index<particles.length() ; index++){
			response = response.concat(".");
		}

		return response;
	}

	private String createPositionsLine(List<Particle> particles){
		String response = "";

		//Char used as a representation of the position of the particles
		char[] positions = new char[particles.size()];

		for(Particle particle: particles){
			//If a particle is in the particles range, it is added to the positions char to represent its position as an 'X'
			if(particleInRange(particle, particles.size())){
				positions[particle.getPosition()] = 'X';
			}
		}

		//Generates the string response that represents the particles positions
		for(int index = 0 ; index< particles.size() ; index++){
			//If the value is not a particle (represented as an 'X'), add to the response a '.'
			if(positions[index] != 'X'){
				response = response.concat(".");
			}else{
				//If there is a particle (represented as an 'X'), add to the response an 'X'
				response = response.concat(String.valueOf(positions[index]));
			}
		}

		return response;
	}

	//Method that validates that a particle is in the range (0, lastParticlePosition) and the position contains a particle
	private boolean particleInRange(Particle particle, int maxPosition){
		return particle.getPosition() >= 0 && particle.getPosition() < maxPosition && particle.getDirection() != '.';
	}
}
