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
