/*
 * Copyright © 2022 JINSPIRED B.V.
 */

package io.kanalis.channels.spi.alpha;

import io.humainary.channels.spi.ChannelsProvider;
import io.humainary.spi.Providers.Factory;

/**
 * The SPI provider factory implementation of {@link ChannelsProvider}.
 *
 * @author wlouth
 * @since 1.0
 */

public final class ProviderFactory
  implements Factory< ChannelsProvider > {

  @Override
  public ChannelsProvider create () {

    return
      new Provider ();

  }

}
