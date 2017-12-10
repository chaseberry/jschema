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

* Apply root schema to entire instance document (3.1)
* Absence of validation keywords does not restrict validation - can act as no-op to value with specific value (3.2)
* If the type of the value is not compatible with the keywords target type, the value is valid in regards to that keyword (3.2.1)
* Annotations must be ignored inside a `not` subschema and inside failing branches of `oneOf`, `anyOf`, `then`, or `else` (3.3)
* The nul(\u0000) character is valid inside of a string (4.1)
* Regex is defined from `ecma262` and are not anchored (4.3)


# Validation Keywords

## Number Specific (6.1)

### type (6.1.1)
* Must be String or Array
* If array, each value must be a unique string
* Allowed values are `null`, `boolean`, `object`, `array`, `number`, `string`, `integer`
* The type of the value must be (in) the value of the type field

### enum (6.1.2)
* Must be an array
* Elements can be any value
* Should have at least 1 element
* Should be unique
* Value must be in array

### const (6.1.3)
* Can be any type
* Value must equal this

### multipleOf (6.2.1)
* Must be a number, > 0
* Value / this must be an int

### maximum (6.2.2)
* Must be a number
* Value must be <= this

### exclusiveMaximum (6.2.3)
* Must be a number
* Value must be < this

### minimum (6.2.4)
* Must be a number
* Value must be >= this

### exclusiveMinimum (6.2.5)
* Must be a number
* Value must be > this

## String Specific (6.3)

### maxLength (6.3.1)
* Must be an int >= 0
* Value length must be <= this

### minLength (6.3.2)
* Must be an int >= 0
* Value length must be >= this
* Omitting this keyword is the same as supplying with a value of 0

### pattern (6.3.3)
* Must be a string
* Should be a regex
* Valid if the string matches this

## Array Specific (6.4)

### items (6.4.1)
* Must be an Schema or Array of Schemas
* If a single schema, validates all elements of an array against
* If array, validates each element against the schema at the same position
* Elements past the array size are valid
* Omitted is the same as supplying {}

### additionalItems (6.4.2)
* Must be a schema
* Applied to all elements past the items field size
* Must be ignored if items is a schema
* Omitted is the same as supplying {}

### maxItems (6.4.3)
* Must be an int >= 0
* Size of value must be <= this

### minItems (6.4.4)
* Must be an int >= 0
* Size of value must be >= this
* Omitted is the same as supplying 0

### uniqueItems (6.4.5)
* Must be a boolean
* If true, every element must not equal any other
* Omitted is the same as supplying false

### contains (6.4.6)
* Must be a Schema
* At least one element must match this schema

## Object Specific (6.5)

### maxProperties (6.5.1)
* Must be an int >= 0
* Number of properties must be <= this

### minProperties (6.5.2)
* Must be an int <= 0
* Number of properties must be >= this
* Omitted is the same as supplying 0

### required (6.5.3)
* Must be an array, all elements must be Strings, and unique
* Every item in this array must be a property in the value
* Omitted is the same as supplying []

### properties (6.5.4)
* Must be an object, each value must be a Schema
* Each key-value pair validates against the same key-value pair in the value
* Missing keys in the value are ignored
* Omitted is the same as supplying {}

### patternProperties (6.5.5)
* Must be an object, each property should be a regex, each value must be a schema
* If a key in the value matches a regex key in this, its value must the regex keys schema
* Omitted is the same as supplying {}

### additionalProperties (6.5.6)
* Must be a Schema
* Validates the value of any keys not matched by `properties` or `patternProperties`
* Omitted is the same as supplying {}

### dependencies (6.5.7)
* Must be an object, each value must be an array or Schema
* If the value is a Schema and the key matches a key in the object,
the entire object must match the Schema
* If the value is an array each element must be a string and unique,
if the key matches a key in the object, each value in the array must be in the object
* Omitted is the same as supplying {}

### propertyNames (6.5.8)
* Must be a Schema
* Every key in the value must match the schema, type will always be string*
* Omitted is the same as supplying {}

## Conditionals (6.6)

### if (6.6.1)
* Must be a Schema
* Always validates

### then (6.6.2)
* Must be a Schema
* If the value validated against an if in the scope of this,
then it must also validate against this
* If the value did not validate against an if, or there is no if, this always validates

### else (6.6.3)
* Must be a Schema
* If the value did not validate against an if in the scope of this,
then it must also validate against this
* If the value did validate against an if, or there is no if, this always validates

## Combination Keywords (6.7)

### allOf (6.7.1)
* Must be a non-empty array. Each element must be a Schema
* Value is valid if it validates against all of the supplied schemas

### anyOf (6.7.2)
* Must be a non-empty array. Each element must be a Schema
* Value is valid if it validates against any of the supplied schemas

### oneOf (6.7.3)
* Must be a non-empty array. Each element must be a Schema
* Value is valid if it validates against only one of the supplied schemas

### not (7.6.4)
* Must be a Schema
* Value is valid if it vails to validate against the Schema provided

## format (7)
* Must be a string
* A non-conformant value type should validate
* Can be disabled
* Should support the following

### Dates/Times (7.3.1)
* Applied to strings
* Should support `date-time`, `date`, and `time`
* If `full-date`, and `full-time` are supported, `date` and `time` must be supported
* Should not support name-space collisions unless validation against RFC 3339, section 5.6 is correct

### Emails (7.3.2)
* Applied to strings
* Valid against `email`, and `idn-email` (RFC 5322, section 3.4.1, RFC 6531)
* `idn-email` is a superset of `email`

### Hostnames (7.3.3)
* Applied to strings
* Valid against `hostname`, and `idn-hostname`  (RFC 1034, section 3.1,RFC 5890, section 2.3.2.3)
* `idn-hostname` is a superset of `hostname`

### IP Address (7.3.4)
* Applied to strings
* Valid against `ipv4` and `ipv6` (RFC 2673, section 3.2, RFC 4291, section 2.2)

### Resource Ids
* Applied to strings
* Valid against `uri`, `uri-reference`, `iri`, and `iri-reference` (RFC3986, RFC3986, RFC3987, RFC3987)
* `iri` is a superset of `uri` and `iri-reference` is a superset of `uri-reference`

### URI Template
* Applied to strings
* Valid against `uri-template` (RFC6570)
* Can be used for iris

### Json pointers
* Applied to strings
* Valid against `json-pointer`, and `relative-json-pointer` (RFC 6901, section 5, Relative JSON Pointer)

### Regex
* Applied to strings
* Valid against regexes (ECMA 262)

## Non-Json Data (8)
* Non Json data encoded as a string
* Should support the following
* Option to disable validation on these keywords

### contentEncoding (8.3)
* Must be a string
* Applied to strings
* Value is binary data encoded by this type

### contentMediaType (8.4)
* Must be a string
* Applied to strings
* Value is binary data matching this media type

## definitions (9)
* Must be an object
* Each value of a given key must be a Schema

## Annotations