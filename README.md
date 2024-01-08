# XCLJ

Clojure, XML edition.

```xml
<fn>[arg]
    <println><q tag="+">arg arg</q></println>
</fn>
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

The input file should consist of a single function. The `args` will be passed to that function as an evaluated list.

This is a joke project, but if you happen to somehow find it useful, I'd love to hear about it.