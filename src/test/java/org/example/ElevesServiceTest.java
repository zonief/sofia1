package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ElevesServiceTest {

  @Test
  public void initComtabiliserEleveParEtab_ContainsValue() {

    ElevesService elevesService = new ElevesService();
    elevesService.initComptabiliserEleveParEtab("codeUai");
    //le couple key value est bien ajouté à la map
    assertNotNull(elevesService.getResultats().get(elevesService.getCleEleveParEtab() + "codeUai"));
    //la valeur est bien initialisée à 0
    assertEquals(Integer.valueOf(0),
        elevesService.getResultats().get(elevesService.getCleEleveParEtab() + "codeUai"));
  }

  @Test
  public void comptabiliserElevesParEtab() {
    ElevesService elevesService = new ElevesService();
    elevesService.initComptabiliserEleveParEtab("codeUai");
    elevesService.comptabiliserElevesParEtab("codeUai", 1);
    //le couple key value est bien ajouté à la map
    assertNotNull(elevesService.getResultats().get(elevesService.getCleEleveParEtab() + "codeUai"));
    //il y a bien 1 élève dans la map pour cet établissement
    assertEquals(Integer.valueOf(1),
        elevesService.getResultats().get(elevesService.getCleEleveParEtab() + "codeUai"));
  }

  @Test
  public void rejeterElevesParEtab() {
    ElevesService elevesService = new ElevesService();
    elevesService.initComptabiliserEleveParEtab("codeUai");
    elevesService.comptabiliserElevesParEtab("codeUai", 1);
    elevesService.rejeterElevesParEtab("codeUai");
    //le couple key value est bien ajouté à la map
    assertNotNull(elevesService.getResultats().get(elevesService.getCleRejetEleve() + "codeUai"));
    //il y a bien 1 élève rejeté dans la map pour cet établissement
    assertEquals(Integer.valueOf(1),
        elevesService.getResultats().get(elevesService.getCleRejetEleve() + "codeUai"));
    //il y a bien 1 éléve pour cet établissement
    assertEquals(Integer.valueOf(1),
        elevesService.getResultats().get(elevesService.getCleEleveParEtab() + "codeUai"));
  }

}
