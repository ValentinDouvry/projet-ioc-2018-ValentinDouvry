package ca.qc.cgmatane.informatique.outilmeteore;

import ca.qc.cgmatane.informatique.outilmeteore.vue.VueOutilObjetsSpatiaux;

public class OutilObjetsSpatiauxApp {

	public static void main(String[] parametres) {		
		VueOutilObjetsSpatiaux vue = new VueOutilObjetsSpatiaux();
		vue.launch(VueOutilObjetsSpatiaux.class, parametres);
	}

}
