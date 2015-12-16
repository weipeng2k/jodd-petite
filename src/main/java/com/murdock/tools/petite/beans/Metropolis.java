package com.murdock.tools.petite.beans;

import java.util.Collection;

import jodd.petite.meta.PetiteBean;
import jodd.petite.meta.PetiteInject;

@PetiteBean
public class Metropolis implements SuperHero {

	@PetiteInject
	public Collection<SuperHero> superHeros;

	public String whoIsThere() {
		String superHeroes = "";
		for (SuperHero superHero : superHeros) {
			superHeroes += superHero.getHeroName() + " ";
		}

		return superHeroes.trim();
	}

	public String getHeroName() {
		return "delegate";
	}
}
