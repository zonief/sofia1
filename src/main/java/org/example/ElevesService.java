package org.example;

import java.util.HashMap;
import java.util.Map;

public class ElevesService {

  protected static final String KEY_CPT_ELEVE_REJETE = "KEY_CPT_ELEVE_REJETE";
  protected static final String KEY_CPT_ELEVE = "KEY_CPT_ELEVE";
  protected static final String KEY_CPT_UAI = "KEY_CPT_UAI";

  Map<String, Integer> resultats = new HashMap<>();

  public void initComptabiliserEleveParEtab(String codeUai) {
    String key = this.getCleEleveParEtab() + codeUai;
    resultats.put(key, 0);
  }

  public void comptabiliserElevesParEtab(String codeUai, Integer nbEleves) {
    String key = this.getCleEleveParEtab() + codeUai;
    resultats.put(key, nbEleves);
  }

  public Integer getComptabiliserElevesParEtab(String codeUai) {
    String key = "";
    if (codeUai != null) {
      key = this.getCleEleveParEtab() + codeUai;
    }
    return resultats.get(key);
  }

  public void rejeterElevesParEtab(String codeUai) {
    Integer cpt = 0;
    String key;
    if (resultats.get(KEY_CPT_ELEVE_REJETE) != null) {
      cpt = resultats.get(KEY_CPT_ELEVE_REJETE);
    }
    if (codeUai != null) {
      key = this.getCleRejetEleve() + codeUai;
      if (this.getComptabiliserElevesParEtab(codeUai) != null) {
        Integer nbElevesParEtab = this.getComptabiliserElevesParEtab(codeUai);
        resultats.put(key, nbElevesParEtab);
        resultats.put(KEY_CPT_ELEVE_REJETE, cpt + nbElevesParEtab);
        String cleElvAjoutesParEtab = KEY_CPT_UAI + codeUai;
        if (resultats.get(KEY_CPT_ELEVE) != null && resultats.get(cleElvAjoutesParEtab) != null) {
          Integer totalElevesAjoutes = resultats.get(KEY_CPT_ELEVE);
          Integer nbElevesAjoutesParEtab = resultats.get(cleElvAjoutesParEtab);
          if (totalElevesAjoutes >= nbElevesAjoutesParEtab) {
            Integer nbElevesActu = totalElevesAjoutes - nbElevesAjoutesParEtab;
            resultats.put(KEY_CPT_ELEVE, nbElevesActu);
          } else {
            resultats.put(KEY_CPT_ELEVE, 0);
          }
        }
      }
    }

  }

  public String getCleEleveParEtab() {
    return KEY_CPT_UAI;
  }

  public String getCleRejetEleve(){
    return KEY_CPT_ELEVE_REJETE;
  }

  public Map<String, Integer> getResultats() {
    return resultats;
  }

}