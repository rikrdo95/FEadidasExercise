package com.adidas.serenitySteps;

import com.adidas.serenitySteps.steps;
import com.adidas.utils.utils;

import cucumber.api.DataTable;

public class steps {

  public static void iNavigateToTheSectionsSECTIONS(String section) {
  }

  public static void iAddToTheCartTheProductPRODUCT(String product) {
  }

  public static void iDeleteFromTheCartTheProductPRODUCT(String product) {
  }

  public static void iWantToPlaceTheOrder() {
  }

  public static void iFillTheFormFields() {
  }

  public static void iClickOnELEMENT(String element) {
  }

  public static void iCheckTheFields(DataTable fields) {
  }

  public static void iClickOnOkToFinishThePurchase() {
  }

  private static void wait(int milis) {
    try {
      Thread.sleep(milis);
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
