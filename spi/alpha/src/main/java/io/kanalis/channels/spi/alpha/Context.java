/*
 * Copyright © 2022 JINSPIRED B.V.
 */

package io.kanalis.channels.spi.alpha;

import io.humainary.channels.Channels;
import io.humainary.channels.Channels.Channel;
import io.humainary.substrates.Substrates.Environment;
import io.humainary.substrates.Substrates.Name;
import io.humainary.substrates.Substrates.Type;
import io.humainary.substrates.sdk.AbstractContext;

import static io.humainary.channels.Channels.Channel.TYPE;

final class Context< T >
  extends AbstractContext< Channel< T >, T >
  implements Channels.Context< T > {

  Context (
    final Environment environment,
    final Producer< ? extends Channel< T >, T > producer
  ) {

    super (
      environment,
      producer
    );

  }

  @Override
  protected Type type () {

    return
      TYPE;

  }


  @Override
  public Channel< T > channel (
    final Name name
  ) {

    return
      instrument (
        name
      );

  }

}
