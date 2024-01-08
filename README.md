# XCLJ

Clojure, XML edition.

```xml
<xclj>
    <defn>x [a]
        <println>a</println>
    </defn>
    <defn>main [arg]
        <x>
            <q tag="+">arg arg</q>
        </x>
    </defn>
</xclj>
```

## Semantics Bootcamp

Instead of using parentheses to denote function application, we use XML tags. The tag name is the function name,
and the tag contents are the function arguments. For example, the following Clojure code:

```clojure
(println (add 1 2))
```

would be written in XCLJ as:

```xml
<println>
    <add>1 2</add>
</println>
```

Should you need to use a function that cannot be expressed as a valid XML tag name, you can use the `<q>` tag:

```xml
<q tag="+">1 2</q>
```

`<q>` also literally inserts its contents.

## Usage

```bash
$ java -jar xclj-uber.jar <input-file> args...
```

The input file must have an `<xclj>` root tag. The function called must be called `main`.
All arguments are passed to the `main` function as a vector of evaluated strings.

This is a joke project, but if you happen to somehow find it useful, I'd love to hear about it.