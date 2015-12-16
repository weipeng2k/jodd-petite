package com.murdock.tools.petite.beans;

import java.util.Set;

import jodd.petite.meta.PetiteBean;
import jodd.petite.meta.PetiteInject;

@PetiteBean
public class GothamCity {

	@PetiteInject
	public Set<SuperHero> superHeros;

	public String whoIsThere() {
		String superHeroes = "";
		for (SuperHero superHero : superHeros) {
			superHeroes += superHero.getHeroName() + " ";
		}

		return superHeroes.trim();
	}
}
