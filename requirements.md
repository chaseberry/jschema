http://json-schema.org/latest/json-schema-core.html

* Schema is an object or boolean (4.3.1)
* Ignore unknown keys (4.3.1, 6.4)
* Support custom keywords (4.3.2, 6.4)

* `$schema` URI (7)
* `$ref` URI - Does not need to download, but can (8)
* `$id` URI - Should not be `` or `#`, URI should not have `#`, unless empty, subschema ids must be `#` only (9.2)
* Multiple loaded schemas with the same `$id` value is an error (9.2.2)
* `$comment` String - Can be used in error/debug output, may remove key if a shortened version is requested (10)

http://json-schema.org/latest/json-schema-validation.html

