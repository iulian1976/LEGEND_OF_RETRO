/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author Home
 */
public class Zone
{
    private int id;
    private String nom;
    
    public Zone()
    {
        this.id = -1;
        this.nom = "";
    }
    public Zone(int id, String nom)
    {
        this.id = id;
        this.nom = nom;
    }
    public int getId()              {return this.id;}
    public String getNom()          {return this.nom;}
    public void setId(int id)               {this.id = id;}
    public void setNom(String nom)          {this.nom = nom;}
}
