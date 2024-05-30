package com.kamaya.code_test.service.animation;

public class Particle {

	Integer position;
	Character direction;

	public Particle(Integer position, Character direction){
		this.position = position;
		this.direction = direction;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Character getDirection() {
		return direction;
	}

	public void setDirection(Character direction) {
		this.direction = direction;
	}
}
