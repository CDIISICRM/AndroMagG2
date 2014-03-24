package fr.cdig2.androMag.metier;

import java.util.ArrayList;

public class Commentable {
	private ArrayList<Commentaire> lesCommentaire;

    public Commentable(ArrayList<Commentaire> lesCommentaire) {
        this.lesCommentaire = lesCommentaire;
    }

    public void setLesCommentaire(ArrayList<Commentaire> lesCommentaire) {
        this.lesCommentaire = lesCommentaire;
    }

}
