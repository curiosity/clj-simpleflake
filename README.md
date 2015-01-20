# clj-simpleflake

This is an implementation of Simpleflake[http://engineering.custommade.com/simpleflake-distributed-id-generation-for-the-lazy/], a Snowflake-compatible (time-ordered) 64-bit id generator written in Clojure. Simpleflakes provide 41 bits of milliseconds since Jan 1, 2010 UTC and 23 bits of randomness.

The reference Python implementation is located at https://github.com/SawdustSoftware/simpleflake.

## Usage

```clj
(require 'clj-simpleflake.core)
(clj-simpleflake.core/simpleflake)
```

You could use ``clj-simpleflake.core/extract-bits`` to grab the timestamp or the random bits, but no utility is provided (you have to convert the ms since Jan 1, 2010 timestamp to something else yourself). Pull requests welcome.

## License

Copyright © 2015 Brandon Joseph Adams <emidln@gmail.com>

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version. This is the same license as Clojure itself.
