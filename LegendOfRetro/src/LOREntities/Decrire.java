package LOREntities;
// Generated May 10, 2018 11:22:26 PM by Hibernate Tools 4.3.1



/**
 * Decrire generated by hbm2java
 */
public class Decrire  implements java.io.Serializable {


     private DecrireId id;
     private Jeu jeu;
     private Tag tag;

    public Decrire() {
    }

    public Decrire(DecrireId id, Jeu jeu, Tag tag) {
       this.id = id;
       this.jeu = jeu;
       this.tag = tag;
    }
   
    public DecrireId getId() {
        return this.id;
    }
    
    public void setId(DecrireId id) {
        this.id = id;
    }
    public Jeu getJeu() {
        return this.jeu;
    }
    
    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }
    public Tag getTag() {
        return this.tag;
    }
    
    public void setTag(Tag tag) {
        this.tag = tag;
    }




}


