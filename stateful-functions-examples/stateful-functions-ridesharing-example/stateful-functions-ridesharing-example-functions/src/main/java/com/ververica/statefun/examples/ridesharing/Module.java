/*
 * Copyright 2019 Ververica GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ververica.statefun.examples.ridesharing;

import com.google.auto.service.AutoService;
import com.ververica.statefun.sdk.spi.StatefulFunctionModule;
import java.util.Map;

@AutoService(StatefulFunctionModule.class)
public class Module implements StatefulFunctionModule {

  @Override
  public void configure(Map<String, String> globalConfiguration, Binder binder) {
    FunctionProvider provider = new FunctionProvider();
    binder.bindFunctionProvider(FnPassenger.TYPE, provider);
    binder.bindFunctionProvider(FnDriver.TYPE, provider);
    binder.bindFunctionProvider(FnRide.TYPE, provider);
    binder.bindFunctionProvider(FnGeoCell.TYPE, provider);

    binder.bindIngress(KafkaSpecs.FROM_DRIVER_SPEC);
    binder.bindIngressRouter(Identifiers.FROM_DRIVER, new InboundDriverRouter());
    binder.bindEgress(KafkaSpecs.TO_DRIVER_SPEC);

    binder.bindIngress(KafkaSpecs.FROM_PASSENGER_SPEC);
    binder.bindIngressRouter(Identifiers.FROM_PASSENGERS, new InboundPassengerRouter());
    binder.bindEgress(KafkaSpecs.TO_PASSENGER_SPEC);
  }
}
