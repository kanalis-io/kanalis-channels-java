/*
 * Copyright © 2022 JINSPIRED B.V.
 */

package io.kanalis.channels.spi.alpha;

import io.humainary.channels.Channels;
import io.humainary.channels.spi.ChannelsProvider;
import io.humainary.substrates.Substrates.Environment;
import io.humainary.substrates.sdk.AbstractContextProvider;

import static io.humainary.channels.Channels.TYPE;
import static io.humainary.substrates.Substrates.environment;

/**
 * The SPI implementation of {@link ChannelsProvider}.
 *
 * @author wlouth
 * @since 1.0
 */

final class Provider
  extends AbstractContextProvider<
  Channels.Channel< ? >,
  Channels.Context< ? > >
  implements ChannelsProvider {

  Provider () {

    super (
      environment ->
        new Context<> (
          environment,
          Channel::new
        )
    );

  }


  @Override
  public < T > Channels.Context< T > context (
    final Class< T > type
  ) {

    // we don't need to check the type of the
    // context creates as this is not shared

    //noinspection unchecked
    return
      (Channels.Context< T >)
        context (
          environment (
            TYPE,
            type
          )
        );

  }

  @Override
  public < T > Channels.Context< T > context (
    final Class< T > type,
    final Environment environment
  ) {

    final var context =
      context (
        environment.override (
          TYPE,
          type
        )
      );

    // we need to check whether the target type
    // is compatible with the type specified
    // in the event this is a shared context

    final var target =
      context
        .environment ()
        .getObject (
          TYPE,
          Class.class,
          type
        );

    if ( target == type ) {

      //noinspection unchecked

      return
        (Channels.Context< T >)
          context;

    } else {

      // return an unshared context

      return
        context (
          type
        );

    }


  }

}
