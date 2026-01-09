7.3.1 Pattern Extract Method 
 
In der Klasse Sportartikel: 
 
 protected String gibZurueck(char trenner) { 
   return (this.getEinkaufsdatum() + "") + trenner  
    +  this.getPreis(); 
  } 
 
In der Klasse Ball: 
 
  public String gibZurueck(char trenner) { 
  return this.getMaterial() + trenner 
       + this.getSportart() + trenner + this.getStatus() + trenner 
       + this.getNutzung() + trenner + super.gibZurueck(trenner); 
 } 
 
In der Klasse Trikot: 
 
  public String gibZurueck(char trenner) { 
  return this.getTrikotnummer() + (trenner + "") 
       + this.getGroesse() + trenner 
            + super.gibZurueck(trenner); 
 }

 View Alternative 

 private void zeigeTrikotsAn() { 
      txtAnzeigeTrikots.setText(trikotsModel.gibTrikotsZurueck('|')); 
     } 
     
     private void zeigeBaelleAn() { 
      String text = ""; 
      // Ersetzen der for-Schleife durch eine for each-Schleife ist  
   // nur moeglich, wenn SportartikelListe eine Instanz von Iterable  
   // ist. 
       for(int i = 0; i < baelleModel.getBaelle().getAnzahlSportartikel();  
    i++) { 
        text = text + baelleModel.getBaelle() 
     .getSportartikel(i).gibBallZurueck('|') + "\n"; 
       } 
      txtAnzeigeBaelle.setText(text); 
      zeigeInformationsfensterAn("Beachten Sie die Anzeige der Bälle!"); 
     }
