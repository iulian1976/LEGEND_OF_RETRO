/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.Controleur;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Home
 */
public class GUI extends JFrame implements ActionListener
{
    private Controleur controleur;
    
    private enum Menu {AUCUN, PRODUIT, ACHAT, VENTE, PERSONNE, PROMO};
    private Menu FLAG_menuOuvert; // à fixer (voir ouvrirMenu. Et oui, à fixer quand même, car on en a besoin !)
    private JPanel menuOuvert;
    private JPanel menuPanel;
    private JButton buttonProduit;
    private JButton buttonAchat;
    private JButton buttonVente;
    private JButton buttonClient;
    private JButton buttonPromo;
    
    public GUI(Controleur controleur)
    {
        super();
        
        //initialisation des composants
        menuPanel = new JPanel();
        menuPanel.setPreferredSize(new java.awt.Dimension(150, 560));
        
        buttonProduit = new JButton();
        buttonProduit.setText("Produit");
        buttonProduit.addActionListener(this);

        buttonAchat = new JButton();
        buttonAchat.setText("Achat");
        buttonAchat.addActionListener(this);
        
        buttonVente = new JButton();
        buttonVente.setText("Vente");
        buttonVente.addActionListener(this);
        
        buttonClient = new JButton();
        buttonClient.setText("Client / Fournisseur");
        buttonClient.addActionListener(this);
        
        buttonPromo = new JButton();
        buttonPromo.setText("Promo");
        buttonPromo.addActionListener(this);

        //les lignes suivantes servent à dessiner le menu. Elles ont été générées automatiquement par un form.
        GroupLayout menuPanelLayout = new GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(buttonProduit, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(buttonClient, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(buttonAchat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonVente, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonPromo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonProduit, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonClient, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonAchat, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonVente, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPromo, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        //mise en forme de la fenêtres.
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(this.menuPanel, BorderLayout.WEST);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(990, 560);
        this.setVisible(true);
        
        this.controleur = controleur;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == buttonAchat)
            ouvrirMenu(Menu.ACHAT);
        else if (e.getSource() == buttonVente)
            ouvrirMenu(Menu.VENTE);
        else if (e.getSource() == buttonClient)
            ouvrirMenu(Menu.PERSONNE);
        else if (e.getSource() == buttonProduit)
            ouvrirMenu(Menu.PRODUIT);
        else if (e.getSource() == buttonPromo)
            ouvrirMenu(Menu.PROMO);
        else //erreur
            throw new UnsupportedOperationException("Erreur GUI : origine de l'action inconnue.");
    }
    
    private void ouvrirMenu(Menu m)
    {
        //si le menu est déjà ouvert, on ignore la commande.
        //Un autre choix pourrait être de rouvrir le menu quand même, mais avec les champs vidés. A débattre.
        //Remarque : cette portion du code NE MARCHE PAS !
        if (this.FLAG_menuOuvert != null && (m.compareTo(this.FLAG_menuOuvert) == 0))
            return;
        //sinon
        this.FLAG_menuOuvert = m;
        if (m == Menu.PRODUIT)
        {
            fermerMenu();
            this.menuOuvert = new menuProduit(this.controleur);
            Container c = this.getContentPane();
            c.add(this.menuOuvert, BorderLayout.CENTER);
            this.setContentPane(c);
        }
        else if (m == Menu.PERSONNE)
        {
            fermerMenu();
            this.menuOuvert = new menuPersonne(this.controleur);
            Container c = this.getContentPane();
            c.add(this.menuOuvert, BorderLayout.CENTER);
            this.setContentPane(c);
        }
        else if (m == Menu.PROMO)
        {
            fermerMenu();
            this.menuOuvert = new menuPromo(this.controleur);
            Container c = this.getContentPane();
            c.add(this.menuOuvert, BorderLayout.CENTER);
            this.setContentPane(c);
        }
        else
            throw new UnsupportedOperationException("Le programme ne gère pas encore ce menu.");
    }
    public void fermerMenu()
    {
        Container c = this.getContentPane();
        c.removeAll();
        c.add(this.menuPanel, BorderLayout.WEST);
        this.setContentPane(c);
        
        this.menuOuvert = null;
        this.FLAG_menuOuvert = Menu.AUCUN;
    }
}
