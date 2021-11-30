package com.mercadolibre.onboarding_testp.unit.beans;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.mercadolibre.onboarding_testp.beans.RandomSampleBean;
import com.mercadolibre.onboarding_testp.dtos.SampleDTO;
import org.junit.jupiter.api.Test;

public class RandomSampleBeanTest {

  @Test
  public void randomPositiveTestOK() {
    RandomSampleBean randomSample = new RandomSampleBean();

    SampleDTO sample = randomSample.random();

    assertTrue(sample.getRandom() >= 0);
  }
}
