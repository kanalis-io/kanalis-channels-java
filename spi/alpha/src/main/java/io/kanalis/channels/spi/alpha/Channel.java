/*
 * Copyright © 2022 JINSPIRED B.V.
 */

package io.kanalis.channels.spi.alpha;

import io.humainary.channels.Channels;
import io.humainary.substrates.Substrates.Inlet;
import io.humainary.substrates.sdk.AbstractInstrument;

final class Channel< T >
  extends AbstractInstrument< T >
  implements Channels.Channel< T > {

  Channel (
    final Inlet< T > inlet
  ) {

    super (
      inlet
    );

  }


  @Override
  public void send (
    final T payload
  ) {

    inlet.emit (
      payload
    );

  }
}
